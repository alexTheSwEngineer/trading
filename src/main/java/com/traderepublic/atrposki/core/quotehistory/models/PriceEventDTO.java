package com.traderepublic.atrposki.core.quotehistory.models;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jooq.Record4;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoField.YEAR_OF_ERA;

@Getter
@Setter
@Accessors(chain = true)
public class PriceEventDTO {
    private int id;
    private Timestamp timestamp;
    private String isin;
    private double price;


    @JsonIgnore
    public LocalDateTime getDateTime() {
        return timestamp.toLocalDateTime();
    }

    @JsonIgnore
    public int getYear() {
        return getDateTime().get(YEAR_OF_ERA);
    }

    @JsonIgnore
    public int getMonth() {
        return getDateTime().getMonth().getValue();
    }

    @JsonIgnore
    public int getDay() {
        return getDateTime().getDayOfMonth();
    }

    @JsonIgnore
    public int getHour() {
        return getDateTime().getHour();
    }

    @JsonIgnore
    public int getMinute() {
        return getDateTime().getMinute();
    }

    public static PriceEventDTO fromRecord(Record4<Integer, Timestamp, Double, String> record) {
        return new PriceEventDTO().setId(record.value1())
                .setTimestamp(record.value2())
                .setPrice(record.value3())
                .setIsin(record.value4());
    }

}
