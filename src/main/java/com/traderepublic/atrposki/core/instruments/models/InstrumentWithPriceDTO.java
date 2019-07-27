package com.traderepublic.atrposki.core.instruments.models;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jooq.Record3;

@Getter
@Setter
@Accessors(chain = true)
public class InstrumentWithPriceDTO {
    private Integer id;
    private String isin;
    private Double price;

    public static InstrumentWithPriceDTO fromRecord(Record3<Integer, String, Double> record) {
        return new InstrumentWithPriceDTO()
                .setId(record.value1())
                .setIsin(record.value2())
                .setPrice(record.value3());
    }
}
