package com.traderepublic.atrposki.core.quotehistory;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.PriceEvent;
import com.traderepublic.atrposki.core.TimeProvider;
import com.traderepublic.atrposki.core.quotehistory.models.Candlestick;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuoteHistoryAggregatorTest {
    QuoteService quoteService;
    TimeProvider timeProvider;

    @Before
    public void init(){
        quoteService = mock(QuoteService.class);
        timeProvider = mock(TimeProvider.class);
    }

    @Test
    public void givenFullHistoryOfCandlesticks_aggregatorReturnsAllOfThemInCorrectOrder(){
        Timestamp now = Timestamp.valueOf(LocalDateTime.of(1991,12,12,15,32));
        LocalDateTime nowSlot = now.toLocalDateTime().withSecond(0);

        HashMap<Integer, PriceEventDTO> priceEventsMap = new HashMap<>();
        priceEventsMap.put(4,priceEvent(nowSlot.minusMinutes(4),4,4));
        priceEventsMap.put(3,priceEvent(nowSlot.minusMinutes(3),3,3));
        priceEventsMap.put(2,priceEvent(nowSlot.minusMinutes(2),2,2));
        priceEventsMap.put(1,priceEvent(nowSlot.minusMinutes(1),1,1));

        List<Candlestick> candleSticks = asList(candlestick(nowSlot.minusMinutes(4), 4, 4),
                candlestick(nowSlot.minusMinutes(3), 3, 3),
                candlestick(nowSlot.minusMinutes(2), 2, 2),
                candlestick(nowSlot.minusMinutes(1), 1, 1)
        );


        QuoteHistoryAggregator quoteHistoryAggregator = getQuoteHistoryAggregator(now, priceEventsMap, candleSticks);

        List<Candlestick> actual = quoteHistoryAggregator.getAggregatedHistory("arbitraryIsn", 4);
        assertEquals(4,actual.size());
        assertEquals(candleSticks.get(0),actual.get(0));
        assertEquals(candleSticks.get(1),actual.get(1));
        assertEquals(candleSticks.get(2),actual.get(2));
        assertEquals(candleSticks.get(3),actual.get(3));


    }

    @Test
    public void givenMissingCandlesticksInSlotsOnTheRightOfTheWindow_aggregatorReturnsCopiesOfTheLast(){
        Timestamp now = Timestamp.valueOf(LocalDateTime.of(1991,12,12,15,32));
        LocalDateTime nowSlot = now.toLocalDateTime().withSecond(0);

        HashMap<Integer, PriceEventDTO> priceEventsMap = new HashMap<>();
        priceEventsMap.put(4,priceEvent(nowSlot.minusMinutes(4),4,4));
        priceEventsMap.put(3,priceEvent(nowSlot.minusMinutes(3),3,3));

        List<Candlestick> candleSticks = asList(candlestick(nowSlot.minusMinutes(4), 4, 4),
                candlestick(nowSlot.minusMinutes(3), 3, 3)
        );


        QuoteHistoryAggregator quoteHistoryAggregator = getQuoteHistoryAggregator(now, priceEventsMap, candleSticks);

        List<Candlestick> actual = quoteHistoryAggregator.getAggregatedHistory("arbitraryIsn", 4);
        assertEquals(4,actual.size());
        assertEquals(candleSticks.get(0),actual.get(0));
        assertEquals(candleSticks.get(1),actual.get(1));
        assertEquals(candleSticks.get(1),actual.get(2));
        assertEquals(candleSticks.get(1),actual.get(3));
    }

    @Test
    public void givenMissingCandlesticksOnTheBeginingOfTheWindowAndNoPreviousHistory_aggregatorReturnsSmallerWindow(){
        Timestamp now = Timestamp.valueOf(LocalDateTime.of(1991,12,12,15,32));
        LocalDateTime nowSlot = now.toLocalDateTime().withSecond(0);

        HashMap<Integer, PriceEventDTO> priceEventsMap = new HashMap<>();
        priceEventsMap.put(2,priceEvent(nowSlot.minusMinutes(2),2,2));
        priceEventsMap.put(1,priceEvent(nowSlot.minusMinutes(1),1,1));

        List<Candlestick> candleSticks = asList(
                candlestick(nowSlot.minusMinutes(2), 2, 2),
                candlestick(nowSlot.minusMinutes(1), 1, 1)
        );

        when(quoteService.findLatestEventBefore(any(LocalDateTime.class))).thenReturn(Optional.empty());


        QuoteHistoryAggregator quoteHistoryAggregator = getQuoteHistoryAggregator(now, priceEventsMap, candleSticks);

        List<Candlestick> actual = quoteHistoryAggregator.getAggregatedHistory("arbitraryIsn", 4);
        assertEquals(2,actual.size());
        assertEquals(candleSticks.get(0),actual.get(0));
        assertEquals(candleSticks.get(1),actual.get(1));
    }


    @Test
    public void givenMissingCandlesticksOnTheBeginingOfTheWindowAndExistingPreviousHistory_aggregatorReturnsCopiesOfExistinHistoryInMissingSlots(){
        Timestamp now = Timestamp.valueOf(LocalDateTime.of(1991,12,12,15,32));
        LocalDateTime nowSlot = now.toLocalDateTime().withSecond(0);

        HashMap<Integer, PriceEventDTO> priceEventsMap = new HashMap<>();
        priceEventsMap.put(2,priceEvent(nowSlot.minusMinutes(2),2,2));
        priceEventsMap.put(1,priceEvent(nowSlot.minusMinutes(1),1,1));

        List<Candlestick> candleSticks = asList(
                candlestick(nowSlot.minusMinutes(2), 2, 2),
                candlestick(nowSlot.minusMinutes(1), 1, 1)
        );

        Candlestick historicalCandlestick = candlestick(nowSlot.minusMinutes(5), 5, 5);

        when(quoteService.findLatestEventBefore(any(LocalDateTime.class))).thenReturn(Optional.of(historicalCandlestick));


        QuoteHistoryAggregator quoteHistoryAggregator = getQuoteHistoryAggregator(now, priceEventsMap, candleSticks);

        List<Candlestick> actual = quoteHistoryAggregator.getAggregatedHistory("arbitraryIsn", 4);
        assertEquals(4,actual.size());
        assertEquals(historicalCandlestick,actual.get(0));
        assertEquals(historicalCandlestick,actual.get(1));
        assertEquals(candleSticks.get(0),actual.get(2));
        assertEquals(candleSticks.get(1),actual.get(3));
    }

    private QuoteHistoryAggregator getQuoteHistoryAggregator(Timestamp now, HashMap<Integer, PriceEventDTO> priceEventsMap, List<Candlestick> candleSticks) {

        when(timeProvider.now()).thenReturn(now);
        when(timeProvider.beforeMinutes(eq(4))).thenReturn(Timestamp.valueOf(now.toLocalDateTime().minusMinutes(4)));
        when(quoteService.getCandlesticksWithoutOpenCloseIdsAfter(anyString(),any(Timestamp.class)))
        .thenReturn(candleSticks);
        when(quoteService.findByIdIn(any(Set.class))).thenReturn(priceEventsMap);


        return new QuoteHistoryAggregator(quoteService, timeProvider);
    }

    private Candlestick candlestick(LocalDateTime slot,double allValues,int id){
        Timestamp timestamp = Timestamp.valueOf(slot);
        return new Candlestick().setCloseTimestamp(timestamp)
                                .setOpenTimestamp(timestamp)
                                .setClosePrice(allValues)
                                 .setOpenPrice(allValues)
                                .setMaxPrice(allValues)
                .setOpenPriceEventId(id)
                .setClosePriceEventId(id)
                .setMinPrice(allValues)
                .setYear(slot.getYear())
                .setMonth(slot.getMonthValue())
                .setDay(slot.getDayOfMonth())
                .setHour(slot.getHour())
                .setMinute(slot.getMinute());
    }

    private PriceEventDTO priceEvent(LocalDateTime slot,double price,int id){
        Timestamp timestamp = Timestamp.valueOf(slot);
        return new PriceEventDTO().setTimestamp(timestamp)
                .setId(id)
                .setPrice(price);
    }
}
