package com.traderepublic.atrposki.core.hotstream;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.TimeProvider;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class HotStreamAggregatorTest {
    private List<String> published;
    private List<Boolean> savedEvents;
    private TimeProvider timeProvider;
    private HotStreamAggregator hotStreamAggregator;

    @Before
    public void init() {
        timeProvider = mock(TimeProvider.class);
    }

    @Test
    public void givenPreviousEventPublishAndHotInstrument_aggregatorDoesNotRaiseAnewEvent() {
        createHotStreamAggregator(true, true);

        hotStreamAggregator.onPriceEvent(new PriceEventDTO().setIsin("arbitraryIsin"));


        assertEquals(0, published.size());
        assertEquals(0, savedEvents.size());
    }

    @Test
    public void givenPreviousEventNotPublishAndHotInstrument_aggregatorRaiseAnewEvent() {
        createHotStreamAggregator(true, false);

        hotStreamAggregator.onPriceEvent(new PriceEventDTO().setIsin("arbitraryIsin"));

        assertEquals(1, published.size());
        assertEquals(1, savedEvents.size());
        assertTrue(savedEvents.get(0));
    }

    @Test
    public void givenPreviousEventPublishAndColdInstrument_aggregatorRaiseAnewCooledEvent() {
        hotStreamAggregator = createHotStreamAggregator(false, true);

        hotStreamAggregator.onPriceEvent(new PriceEventDTO().setIsin("arbitraryIsin"));


        assertEquals(0, published.size());
        assertEquals(1, savedEvents.size());
        assertFalse(savedEvents.get(0));
    }

    @Test
    public void givenPreviousEventNotPublishAndColdInstrument_aggregatorDoesnRaiseAnEvent() {


        createHotStreamAggregator(false, false);

        hotStreamAggregator.onPriceEvent(new PriceEventDTO().setIsin("arbitraryIsin"));

        assertEquals(0, published.size());
        assertEquals(0, savedEvents.size());
    }


    private HotStreamAggregator createHotStreamAggregator(boolean isInstrumentHot, boolean isHotnessNotified) {
        published = new ArrayList<>();
        savedEvents = new ArrayList<>();
        HotInstrumentService service = new HotInstrumentService() {
            @Override
            public void saveHotnesChange(PriceEventDTO priceEventDTO, Timestamp now, boolean type) {
                savedEvents.add(type);
            }

            @Override
            public boolean isInstrumentHot(Timestamp timestamp, String isin, double treshold) {
                return isInstrumentHot;
            }

            @Override
            public boolean isHotnessNotified(String isin) {
                return isHotnessNotified;
            }
        };
        HotInstrumentPublisher publisher = new HotInstrumentPublisher() {
            @Override
            public String publishHotIsin(String isin) {
                published.add(isin);
                return isin;
            }
        };

        hotStreamAggregator = new HotStreamAggregator(publisher, timeProvider, service);
        return hotStreamAggregator;
    }

}
