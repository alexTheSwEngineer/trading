package com.traderepublic.atrposki.core.hotstream;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.TimeProvider;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class HotStreamAggregator {
    public static final double TRESHOLD = 0.1;
    HotInstrumentPublisher hotInstrumentEventPublisher;
    TimeProvider timeProvider;
    HotInstrumentService service;

    public HotStreamAggregator(HotInstrumentPublisher hotInstrumentEventPublisher, TimeProvider timeProvider, HotInstrumentService service) {
        this.hotInstrumentEventPublisher = hotInstrumentEventPublisher;
        this.timeProvider = timeProvider;
        this.service = service;
    }

    /**
     * This method checks if the prices of the instrument with the same isin as this eventDTO have fluctuated for more then  {@link
     * HotStreamAggregator#TRESHOLD} in the last 5 minutes. The formula that calculates this is defined in {@link com.traderepublic.atrposki.core.hotstream.models.PriceAggregatesDTO#isHotterThen(double)}
     * {@link com.traderepublic.atrposki.core.hotstream.models.PriceAggregatesDTO#isHotterThen(double)}
     * If a instrument is hot, the hotInstrumentPublisher will be prompted to fire a HotIsin event provided that the isntrument is on a hot streak that has not been already notified.
     * If an isntrument becomes hot, a second notification will be fired only if it becomes cold first.
     *
     * @param priceEventDTO the price change event that trigers the check for hotness for the coresponding instrument.
     * @return PriceEventDto that was passed as a parameter
     */
    public PriceEventDTO onPriceEvent(PriceEventDTO priceEventDTO) {
        Timestamp before5mins = timeProvider.beforeMinutes(5);
        boolean isInstrumentHot = service.isInstrumentHot(before5mins, priceEventDTO.getIsin(), TRESHOLD);
        boolean alreadyNotified = service.isHotnessNotified(priceEventDTO.getIsin());

        if (isInstrumentHot && !alreadyNotified) {
            hotInstrumentEventPublisher.publishHotIsin(priceEventDTO.getIsin());
            service.saveHotnesChange(priceEventDTO, before5mins, true);

            return priceEventDTO;
        }

        if (!isInstrumentHot && alreadyNotified) {
            service.saveHotnesChange(priceEventDTO, before5mins, false);
        }
        return priceEventDTO;
    }


}
