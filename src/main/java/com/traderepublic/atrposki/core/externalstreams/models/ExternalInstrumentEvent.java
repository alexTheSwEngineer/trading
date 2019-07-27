package com.traderepublic.atrposki.core.externalstreams.models;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.instruments.models.InstrumentEventDto;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Getter
@Setter
@Accessors(chain = true)
public class ExternalInstrumentEvent {
    private InstrumentEventDto data;
    private String type;
    public InstrumentEventDto toInstrumentEventDTO(){
        return data.setAction(type);
    }
}
