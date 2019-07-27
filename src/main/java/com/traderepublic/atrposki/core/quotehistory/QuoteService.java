package com.traderepublic.atrposki.core.quotehistory;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.quotehistory.models.Candlestick;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface QuoteService {
    /**
     * @param ids the ids of the selected price events. Must not be null or empty.
     * @return a map of PriceEvents by their id
     */
    Map<Integer, PriceEventDTO> findByIdIn(Set<Integer> ids);

    /**
     * Creates a fake candlestick of the last price change event before the selected slot.
     *
     * @param lastSlot the last slot for which a candlestick is calculated
     * @return the latest Candlestick before the date given as parameter.
     */
    Optional<Candlestick> findLatestEventBefore(LocalDateTime lastSlot);

    /**
     * @param id the id of the selected priceEvent
     * @return a priceEvent with the given id if such exists, empty optional otherwise
     */
    Optional<PriceEventDTO> findPriceEventById(int id);


    /**
     * @param timestamp the point in furthes back in time after which candlesticks will be calculated
     * @param isin the selected isin
     * @return a incomplete candlestick representation for the given isin, after the timestamp. Each candle stick is 1
     * minute "wide" and will have the correct open and close price event ids, but their data will not be fecthed. This means that the candlesticks
     * retured by this method will have a 0/null open and close timestamp and price.
     */
    List<Candlestick> getCandlesticksWithoutOpenCloseIdsAfter(String isin, Timestamp timestamp);

    void saveEvent(PriceEventDTO priceEventDTO);
}
