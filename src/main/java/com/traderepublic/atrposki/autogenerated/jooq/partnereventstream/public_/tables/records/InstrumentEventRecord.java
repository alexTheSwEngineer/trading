/*
 * This file is generated by jOOQ.
 */
package com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.records;


import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.InstrumentEvent;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class InstrumentEventRecord extends UpdatableRecordImpl<InstrumentEventRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = -659735455;

    /**
     * Setter for <code>PUBLIC.INSTRUMENT_EVENT.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.INSTRUMENT_EVENT.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>PUBLIC.INSTRUMENT_EVENT.ISIN</code>.
     */
    public void setIsin(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.INSTRUMENT_EVENT.ISIN</code>.
     */
    public String getIsin() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.INSTRUMENT_EVENT.DESCRIPTION</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.INSTRUMENT_EVENT.DESCRIPTION</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.INSTRUMENT_EVENT.ACTION</code>.
     */
    public void setAction(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.INSTRUMENT_EVENT.ACTION</code>.
     */
    public String getAction() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return InstrumentEvent.INSTRUMENT_EVENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return InstrumentEvent.INSTRUMENT_EVENT.ISIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return InstrumentEvent.INSTRUMENT_EVENT.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return InstrumentEvent.INSTRUMENT_EVENT.ACTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getIsin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getAction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getIsin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrumentEventRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrumentEventRecord value2(String value) {
        setIsin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrumentEventRecord value3(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrumentEventRecord value4(String value) {
        setAction(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrumentEventRecord values(Integer value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InstrumentEventRecord
     */
    public InstrumentEventRecord() {
        super(InstrumentEvent.INSTRUMENT_EVENT);
    }

    /**
     * Create a detached, initialised InstrumentEventRecord
     */
    public InstrumentEventRecord(Integer id, String isin, String description, String action) {
        super(InstrumentEvent.INSTRUMENT_EVENT);

        set(0, id);
        set(1, isin);
        set(2, description);
        set(3, action);
    }
}
