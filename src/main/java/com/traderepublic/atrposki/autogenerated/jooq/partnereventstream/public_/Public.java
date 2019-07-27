/*
 * This file is generated by jOOQ.
 */
package com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_;


import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.DefaultCatalog;
import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.InstrumentEvent;
import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.InstrumentHotnessChangeEvent;
import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.PriceEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -351037954;

    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>PUBLIC.INSTRUMENT_EVENT</code>.
     */
    public final InstrumentEvent INSTRUMENT_EVENT = com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.InstrumentEvent.INSTRUMENT_EVENT;

    /**
     * The table <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT</code>.
     */
    public final InstrumentHotnessChangeEvent INSTRUMENT_HOTNESS_CHANGE_EVENT = com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.InstrumentHotnessChangeEvent.INSTRUMENT_HOTNESS_CHANGE_EVENT;

    /**
     * The table <code>PUBLIC.PRICE_EVENT</code>.
     */
    public final PriceEvent PRICE_EVENT = com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.PriceEvent.PRICE_EVENT;

    /**
     * No further instances allowed
     */
    private Public() {
        super("PUBLIC", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            InstrumentEvent.INSTRUMENT_EVENT,
            InstrumentHotnessChangeEvent.INSTRUMENT_HOTNESS_CHANGE_EVENT,
            PriceEvent.PRICE_EVENT);
    }
}
