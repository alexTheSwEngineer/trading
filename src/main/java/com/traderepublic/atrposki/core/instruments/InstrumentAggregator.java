package com.traderepublic.atrposki.core.instruments;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.instruments.models.InstrumentEventDto;
import org.springframework.stereotype.Service;

@Service
public class InstrumentAggregator {
    private InstrumentService service;

    public InstrumentAggregator(InstrumentService service) {
        this.service = service;
    }

    public InstrumentEventDto onInstrumentEvent(InstrumentEventDto instrumentEventDto){
        service.save(instrumentEventDto);
        return instrumentEventDto;
    }
}
