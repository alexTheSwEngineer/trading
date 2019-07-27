package com.traderepublic.atrposki.core.hotstream;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.hotstream.models.PriceAggregatesDTO;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

import static com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.InstrumentHotnessChangeEvent.INSTRUMENT_HOTNESS_CHANGE_EVENT;
import static com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.PriceEvent.PRICE_EVENT;
import static org.jooq.impl.DSL.*;

@Service
public class JooqHotInstumentService implements HotInstrumentService {
    private DefaultDSLContext db;

    public JooqHotInstumentService(DefaultDSLContext db) {
        this.db = db;
    }

    @Override
    public void saveHotnesChange(PriceEventDTO priceEventDTO, Timestamp now, boolean type) {
        db.insertInto(INSTRUMENT_HOTNESS_CHANGE_EVENT, INSTRUMENT_HOTNESS_CHANGE_EVENT.ISIN, INSTRUMENT_HOTNESS_CHANGE_EVENT.TIMESTAMP, INSTRUMENT_HOTNESS_CHANGE_EVENT.HOT)
                .values(priceEventDTO.getIsin(), now, type)
                .execute();
    }


    @Override
    public boolean isInstrumentHot(Timestamp timestamp, String isin, double treshold) {
        return db.select(max(PRICE_EVENT.PRICE).as("maxPrice"),
                min(PRICE_EVENT.PRICE).as("minPrice"),
                avg(PRICE_EVENT.PRICE).as("avgPrice"))
                .from(PRICE_EVENT)
                .where(PRICE_EVENT.ISIN.eq(isin).and(PRICE_EVENT.TIMESTAMP.gt(timestamp)))
                .fetch().stream()
                .findFirst()
                .map(PriceAggregatesDTO::fromRecord)
                .map(instrument -> instrument.isHotterThen(treshold))
                .orElse(false);
    }

    @Override
    public boolean isHotnessNotified(String isin) {
        return db.select(max(INSTRUMENT_HOTNESS_CHANGE_EVENT.ID).as("maxid"))
                .from(INSTRUMENT_HOTNESS_CHANGE_EVENT)
                .where(INSTRUMENT_HOTNESS_CHANGE_EVENT.ISIN.eq(isin))
                .fetch()
                .stream().findFirst().map(x -> x.value1())
                .flatMap(latestId -> db.select(INSTRUMENT_HOTNESS_CHANGE_EVENT.HOT)
                            .from(INSTRUMENT_HOTNESS_CHANGE_EVENT)
                            .where(INSTRUMENT_HOTNESS_CHANGE_EVENT.ID.eq(latestId))
                            .fetch()
                            .stream()
                            .map(x -> x.value1())
                            .findFirst()
                )
                .orElse(false);
    }
}
