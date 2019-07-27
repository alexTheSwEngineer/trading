package com.traderepublic.atrposki.core.quotehistory;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.TimeProvider;
import com.traderepublic.atrposki.core.quotehistory.models.Candlestick;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Service
public class QuoteHistoryAggregator {
    QuoteService quoteService;
    TimeProvider timeProvider;

    public QuoteHistoryAggregator(QuoteService quoteService, TimeProvider timeProvider) {
        this.quoteService = quoteService;
        this.timeProvider = timeProvider;
    }

    public PriceEventDTO onPriceEvent(PriceEventDTO priceEventDTO) {
        quoteService.saveEvent(priceEventDTO);
        return priceEventDTO;
    }


    /**
     * Returns a window of "count" canlesticks. Each of them is 1 minute "wide"
     * @param isin the isin of the selected instrument
     *             @param count maximum required candlestick count
     * @return a list of candlestics for the last {@param count } minutes. If there are no price informations about the instrument, and empty array is returned.
     * In case there are missing time slots in the middle or end of the window, the last previous candlestick is duplicated in the empty slots.
     * If there are missing time slots in the beginning of the window, the last known price is duplicated for the empty slots.
     * If there is no known price for the begining of the window, the window is turncated to the maximum size possible with the available information
     * */
    public List<Candlestick> getAggregatedHistory(String isin, int count) {
        Timestamp beginTimestamp = timeProvider.beforeMinutes(count);
        LocalDateTime beginSlot = beginTimestamp.toLocalDateTime().withSecond(0);
        LocalDateTime endSlot = beginSlot.plusMinutes(count).withSecond(0);
        List<Candlestick> candlesticks = quoteService.getCandlesticksWithoutOpenCloseIdsAfter(isin, beginTimestamp);
        Boolean startCandlestickIsMissing = candlesticks.stream().findFirst().map(x -> !x.belongsToSlot(beginSlot)).orElse(true);

        if (!startCandlestickIsMissing) {
            return fillMissingCandlesticksAndOpenCloseData(candlesticks.get(0), beginSlot, candlesticks, count);
        }

        //Start candlestick is missing, find a historical ancor.
        Candlestick defaultCandlestick;
        Optional<Candlestick> latestEventUptoWindow = quoteService.findLatestEventBefore(beginSlot);
        if (latestEventUptoWindow.isPresent()) {
            return fillMissingCandlesticksAndOpenCloseData(latestEventUptoWindow.get(), beginSlot, candlesticks, count);
        }


        if (candlesticks.isEmpty()) {
            //no historical data and not even partial curent data -> empty result
            return new ArrayList<>();
        } else {
            // partial curent data, but no historical data -> smaller window
            defaultCandlestick = candlesticks.get(0);
            int minutesBetweenNowAndFirstCandleStick = (int) MINUTES.between(defaultCandlestick.getDateTime(),endSlot);
            return fillMissingCandlesticksAndOpenCloseData(defaultCandlestick, defaultCandlestick.getDateTime(), candlesticks, minutesBetweenNowAndFirstCandleStick);
        }
    }

    private List<Candlestick> fillMissingCandlesticksAndOpenCloseData(Candlestick defaultCandlestick, LocalDateTime beginCandlestickDate, List<Candlestick> candlesticks, int count) {
        fillMissingOpenCloseData(candlesticks);
        return duplicatePredecesorInMIssingSlots(defaultCandlestick, beginCandlestickDate, candlesticks, count);
    }

    private List<Candlestick> duplicatePredecesorInMIssingSlots(Candlestick defaultCandlestick, LocalDateTime beginCandlestickDate, List<Candlestick> candlesticks, int count) {
        Map<LocalDateTime, Candlestick> candlesticksBySlot = candlesticks.stream().collect(toMap(Candlestick::getDateTime, identity()));
        List<Candlestick> res = new ArrayList<>();
        LocalDateTime slot = beginCandlestickDate;
        Candlestick previous = defaultCandlestick;
        for (int i = 0; i < count; i++, slot = slot.plusMinutes(1)) {
            Candlestick candlestick = candlesticksBySlot.getOrDefault(slot, previous);
            res.add(candlestick);
            previous = candlestick;
        }
        return res;
    }

    private void fillMissingOpenCloseData(List<Candlestick> candlesticks) {
        Set<Integer> idsTofetch = new HashSet<>();
        candlesticks.forEach(candlestick -> {
            idsTofetch.add(candlestick.getClosePriceEventId());
            idsTofetch.add(candlestick.getOpenPriceEventId());
        });

        Map<Integer, PriceEventDTO> pricesById = quoteService.findByIdIn(idsTofetch);
        candlesticks.forEach(candlestick -> {
            PriceEventDTO closePriceEvent = pricesById.get(candlestick.getClosePriceEventId());
            candlestick.setClosePrice(closePriceEvent.getPrice());
            candlestick.setCloseTimestamp(closePriceEvent.getTimestamp());

            PriceEventDTO openPriceEvent = pricesById.get(candlestick.getOpenPriceEventId());
            candlestick.setOpenPrice(openPriceEvent.getPrice());
            candlestick.setOpenTimestamp(openPriceEvent.getTimestamp());
        });
    }

}
