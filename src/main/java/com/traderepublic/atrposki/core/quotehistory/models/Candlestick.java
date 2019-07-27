package com.traderepublic.atrposki.core.quotehistory.models;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jooq.Record9;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
public class Candlestick {
    Timestamp openTimestamp;
    Timestamp closeTimestamp;
    double openPrice;
    double closePrice;
    double minPrice;
    double maxPrice;

    @JsonIgnore
    int year;
    @JsonIgnore
    int month;
    @JsonIgnore
    int day;
    @JsonIgnore
    int hour;
    @JsonIgnore
    int minute;

    @JsonIgnore
    int openPriceEventId;
    @JsonIgnore
    int closePriceEventId;

    public static Candlestick fromRecordWithOpenCloseIds(Record9<Integer, Integer, Double, Double, Integer, Integer, Integer, Integer, Integer> record) {
        return new Candlestick().setClosePriceEventId(record.value1())
                .setOpenPriceEventId(record.value2())
                .setMaxPrice(record.value3())
                .setMinPrice(record.value4())
                .setYear(record.value5())
                .setMonth(record.value6())
                .setDay(record.value7())
                .setHour(record.value8())
                .setMinute(record.value9());
    }


    public static Comparator<Candlestick> sortByDate = Comparator.comparing(Candlestick::getYear)
            .thenComparing(Candlestick::getMonth)
            .thenComparing(Candlestick::getDay)
            .thenComparing(Candlestick::getHour)
            .thenComparing(Candlestick::getMinute);

    public boolean belongsToSlot(LocalDateTime dateTime) {
        return dateTime.getYear() == year &&
                dateTime.getMonth().getValue() == month &&
                dateTime.getDayOfMonth() == month &&
                dateTime.getHour() == hour &&
                dateTime.getMinute() == minute;
    }

    public LocalDateTime getDateTime() {
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public int getYear() {
        return getDateTime().getYear();
    }

    public int getMonth() {
        return getDateTime().getMonth().getValue();
    }

    public int getDay() {
        return getDateTime().getDayOfMonth();
    }

    public int getHour() {
        return getDateTime().getHour();
    }

    public int getMinute() {
        return getDateTime().getMinute();
    }
}
