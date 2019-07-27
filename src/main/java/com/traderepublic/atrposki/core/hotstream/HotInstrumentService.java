package com.traderepublic.atrposki.core.hotstream;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;

import java.sql.Timestamp;

public interface HotInstrumentService {
    /**
     * Inserts a hotness change event into the database.
     *
     * @param priceEventDTO the price event that trigerred the hotness change
     * @param now           the timestamp of the event
     * @param type          the type of the event, true meaning the instrument became hot, false meaning it became cold
     */
    void saveHotnesChange(PriceEventDTO priceEventDTO, Timestamp now, boolean type);

    /**
     * Checks if an instrument has a price that varied for more then the treshold since the timestamp. The metric we are checking against the treshold is
     * defined in {@link com.traderepublic.atrposki.core.hotstream.models.PriceAggregatesDTO#isHotterThen(double)}
     *
     * @return true, it the instrument is hot, false otherwise
     * @param timestamp the point in the past from which on the hotness will be calculated
     * @param isin      the isin of the instrument we are interested in
     * @param treshold  the treshold
     */
    boolean isInstrumentHot(Timestamp timestamp, String isin, double treshold);

    /**
     * @return true if the instrument has been reported as hot already, false otherwise
     * */
    boolean isHotnessNotified(String isin);
}
