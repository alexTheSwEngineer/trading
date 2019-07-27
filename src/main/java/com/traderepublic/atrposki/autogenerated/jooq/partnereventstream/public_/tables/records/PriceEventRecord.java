/*
 * This file is generated by jOOQ.
 */
package com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.records;


import com.traderepublic.atrposki.autogenerated.jooq.partnereventstream.public_.tables.PriceEvent;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class PriceEventRecord extends UpdatableRecordImpl<PriceEventRecord> implements Record9<Integer, Double, String, Timestamp, Integer, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = 1416541338;

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.PRICE</code>.
     */
    public void setPrice(Double value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.PRICE</code>.
     */
    public Double getPrice() {
        return (Double) get(1);
    }

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.ISIN</code>.
     */
    public void setIsin(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.ISIN</code>.
     */
    public String getIsin() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.TIMESTAMP</code>.
     */
    public void setTimestamp(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.TIMESTAMP</code>.
     */
    public Timestamp getTimestamp() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.YEAR</code>.
     */
    public void setYear(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.YEAR</code>.
     */
    public Integer getYear() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.MONTH</code>.
     */
    public void setMonth(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.MONTH</code>.
     */
    public Integer getMonth() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.DAY</code>.
     */
    public void setDay(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.DAY</code>.
     */
    public Integer getDay() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.HOUR</code>.
     */
    public void setHour(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.HOUR</code>.
     */
    public Integer getHour() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>PUBLIC.PRICE_EVENT.MINUTE</code>.
     */
    public void setMinute(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>PUBLIC.PRICE_EVENT.MINUTE</code>.
     */
    public Integer getMinute() {
        return (Integer) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Double, String, Timestamp, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Double, String, Timestamp, Integer, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return PriceEvent.PRICE_EVENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field2() {
        return PriceEvent.PRICE_EVENT.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return PriceEvent.PRICE_EVENT.ISIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return PriceEvent.PRICE_EVENT.TIMESTAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return PriceEvent.PRICE_EVENT.YEAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return PriceEvent.PRICE_EVENT.MONTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return PriceEvent.PRICE_EVENT.DAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return PriceEvent.PRICE_EVENT.HOUR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return PriceEvent.PRICE_EVENT.MINUTE;
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
    public Double component2() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getIsin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getMonth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getDay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getHour();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getMinute();
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
    public Double value2() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getIsin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getMonth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getDay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getHour();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getMinute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value2(Double value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value3(String value) {
        setIsin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value4(Timestamp value) {
        setTimestamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value5(Integer value) {
        setYear(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value6(Integer value) {
        setMonth(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value7(Integer value) {
        setDay(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value8(Integer value) {
        setHour(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord value9(Integer value) {
        setMinute(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceEventRecord values(Integer value1, Double value2, String value3, Timestamp value4, Integer value5, Integer value6, Integer value7, Integer value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PriceEventRecord
     */
    public PriceEventRecord() {
        super(PriceEvent.PRICE_EVENT);
    }

    /**
     * Create a detached, initialised PriceEventRecord
     */
    public PriceEventRecord(Integer id, Double price, String isin, Timestamp timestamp, Integer year, Integer month, Integer day, Integer hour, Integer minute) {
        super(PriceEvent.PRICE_EVENT);

        set(0, id);
        set(1, price);
        set(2, isin);
        set(3, timestamp);
        set(4, year);
        set(5, month);
        set(6, day);
        set(7, hour);
        set(8, minute);
    }
}