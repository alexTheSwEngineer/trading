package com.traderepublic.atrposki.core.externalstreams.models;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traderepublic.atrposki.core.externalstreams.ExternalEventStreamHandler;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ExternalPriceEvent {
    private PriceEventDTO data;
    private String type;

    public PriceEventDTO toPriceEventDto(Timestamp timestamp){
        return this.getData().setTimestamp(timestamp);
    }
}
