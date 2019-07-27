package com.traderepublic.atrposki.core.hotstream.models;
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

import java.math.BigDecimal;

import static java.lang.Math.abs;

@Getter
@Setter
@Accessors(chain = true)
public class PriceAggregatesDTO {
    private double minPrice;
    private double maxPrice;
    private BigDecimal avgPrice;

    public static PriceAggregatesDTO fromRecord(Record3<Double, Double, BigDecimal> r) {
        return new PriceAggregatesDTO()
                .setMaxPrice(r.value1() == null ? 0 : r.value1())
                .setMinPrice(r.value2() == null ? 0 : r.value2())
                .setAvgPrice(r.value3() == null ? BigDecimal.ZERO : r.value3());
    }

    /**
     * @param treshold the treshold of hotness
     * @return true if abs(max-min)/avg > treshold. False if avg is 0 or abs(max-min)/avg < treshold
     */
    public boolean isHotterThen(double treshold) {
        double absoluteDeviation = abs(maxPrice - minPrice);
        if (avgPrice.compareTo(BigDecimal.ZERO) != 0) {
            double avgPriceAsDouble = avgPrice.doubleValue();
            return absoluteDeviation / avgPriceAsDouble > treshold;
        }

        return false;
    }

}
