package com.traderepublic.atrposki.core.instruments;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.traderepublic.atrposki.core.instruments.models.InstrumentWithPriceDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class InstrumentsController {


    InstrumentService instrumentService;

    public InstrumentsController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @RequestMapping(value = "/instruments", method = GET)
    public List<InstrumentWithPriceDTO> getAll() {
        return instrumentService.getAllInstruments();
    }
}
