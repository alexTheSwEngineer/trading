/*
 * This file is generated by jOOQ.
 */
package com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables;


import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.Indexes;
import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.Keys;
import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.Public;
import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.records.InstrumentHotnessChangeEventRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class InstrumentHotnessChangeEvent extends TableImpl<InstrumentHotnessChangeEventRecord> {

    private static final long serialVersionUID = 1940925325;

    /**
     * The reference instance of <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT</code>
     */
    public static final InstrumentHotnessChangeEvent INSTRUMENT_HOTNESS_CHANGE_EVENT = new InstrumentHotnessChangeEvent();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InstrumentHotnessChangeEventRecord> getRecordType() {
        return InstrumentHotnessChangeEventRecord.class;
    }

    /**
     * The column <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT.ID</code>.
     */
    public final TableField<InstrumentHotnessChangeEventRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT.ISIN</code>.
     */
    public final TableField<InstrumentHotnessChangeEventRecord, String> ISIN = createField("ISIN", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT.HOT</code>.
     */
    public final TableField<InstrumentHotnessChangeEventRecord, Boolean> HOT = createField("HOT", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT.TIMESTAMP</code>.
     */
    public final TableField<InstrumentHotnessChangeEventRecord, Timestamp> TIMESTAMP = createField("TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP.precision(6).nullable(false), this, "");

    /**
     * Create a <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT</code> table reference
     */
    public InstrumentHotnessChangeEvent() {
        this(DSL.name("INSTRUMENT_HOTNESS_CHANGE_EVENT"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT</code> table reference
     */
    public InstrumentHotnessChangeEvent(String alias) {
        this(DSL.name(alias), INSTRUMENT_HOTNESS_CHANGE_EVENT);
    }

    /**
     * Create an aliased <code>PUBLIC.INSTRUMENT_HOTNESS_CHANGE_EVENT</code> table reference
     */
    public InstrumentHotnessChangeEvent(Name alias) {
        this(alias, INSTRUMENT_HOTNESS_CHANGE_EVENT);
    }

    private InstrumentHotnessChangeEvent(Name alias, Table<InstrumentHotnessChangeEventRecord> aliased) {
        this(alias, aliased, null);
    }

    private InstrumentHotnessChangeEvent(Name alias, Table<InstrumentHotnessChangeEventRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> InstrumentHotnessChangeEvent(Table<O> child, ForeignKey<O, InstrumentHotnessChangeEventRecord> key) {
        super(child, key, INSTRUMENT_HOTNESS_CHANGE_EVENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.INSTRUMENT_HOTNESS_CHANGE_EVENT_ISIN, Indexes.INSTRUMENT_HOTNESS_CHANGE_EVENT_TIMESTAMP, Indexes.PRIMARY_KEY_D);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<InstrumentHotnessChangeEventRecord, Integer> getIdentity() {
        return Keys.IDENTITY_INSTRUMENT_HOTNESS_CHANGE_EVENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<InstrumentHotnessChangeEventRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_D;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<InstrumentHotnessChangeEventRecord>> getKeys() {
        return Arrays.<UniqueKey<InstrumentHotnessChangeEventRecord>>asList(Keys.CONSTRAINT_D);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrumentHotnessChangeEvent as(String alias) {
        return new InstrumentHotnessChangeEvent(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrumentHotnessChangeEvent as(Name alias) {
        return new InstrumentHotnessChangeEvent(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public InstrumentHotnessChangeEvent rename(String name) {
        return new InstrumentHotnessChangeEvent(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InstrumentHotnessChangeEvent rename(Name name) {
        return new InstrumentHotnessChangeEvent(name, null);
    }
}
