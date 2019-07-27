package com.traderepublic.atrposki.core.hotstream;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class HotInstrumentController implements  HotInstrumentPublisher{
    @Override
    @SendTo("/topic/hotinstruments")
    public String publishHotIsin(String isin) {
        System.out.println("Hot instrument published, pls avert yout eyes to the log "+isin);
        return isin;
    }

}
