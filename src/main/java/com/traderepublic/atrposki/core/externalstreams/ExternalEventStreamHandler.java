package com.traderepublic.atrposki.core.externalstreams;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traderepublic.atrposki.core.TimeProvider;
import com.traderepublic.atrposki.core.externalstreams.models.ExternalInstrumentEvent;
import com.traderepublic.atrposki.core.externalstreams.models.ExternalPriceEvent;
import com.traderepublic.atrposki.core.hotstream.HotStreamAggregator;
import com.traderepublic.atrposki.core.instruments.InstrumentAggregator;
import com.traderepublic.atrposki.core.instruments.models.InstrumentEventDto;
import com.traderepublic.atrposki.core.quotehistory.QuoteHistoryAggregator;
import com.traderepublic.atrposki.core.quotehistory.models.PriceEventDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;

/**
 * A class used to hook up our event listeners to the external event publishers
 */
@Service
public class ExternalEventStreamHandler {
    private HotStreamAggregator hotStreamAggregator;
    private final ObjectMapper objectMapper;
    WebSocketClient webSocketClient;
    QuoteHistoryAggregator quoteHistoryAggregator;
    InstrumentAggregator instrumentAggregator;
    TimeProvider timeProvider;
    private String URL_QUOTES = "ws://localhost:8080/quotes";
    private String URL_INSTRUMENTS = "ws://localhost:8080/instruments";

    public ExternalEventStreamHandler(HotStreamAggregator hotStreamAggregator, ObjectMapper objectMapper, WebSocketClient webSocketClient, QuoteHistoryAggregator quoteHistoryAggregator, InstrumentAggregator instrumentAggregator, TimeProvider timeProvider) {
        this.hotStreamAggregator = hotStreamAggregator;
        this.objectMapper = objectMapper;
        this.webSocketClient = webSocketClient;
        this.quoteHistoryAggregator = quoteHistoryAggregator;
        this.instrumentAggregator = instrumentAggregator;
        this.timeProvider = timeProvider;
    }

    @PostConstruct
    public void init() {
        subscribeToQuotesStream();
        subscribeToInstrumentsStream();
    }

    private void subscribeToInstrumentsStream() {
        webSocketClient.execute(
                URI.create(URL_INSTRUMENTS),
                session -> session.receive()
                        .log()
                        .map(WebSocketMessage::getPayloadAsText)
                        .map(this::asInstrumentEventDto)
                        .map(instrumentAggregator::onInstrumentEvent)
                        .onErrorContinue((x, o) -> x.printStackTrace(System.out))
                        .then())
                .subscribe();
    }

    private void subscribeToQuotesStream() {
        webSocketClient.execute(
                URI.create(URL_QUOTES),
                session -> session.receive()
                        .log()
                        .map(WebSocketMessage::getPayloadAsText)
                        .map(this::asPriceEventDTO)
                        .map(quoteHistoryAggregator::onPriceEvent)
                        .map(hotStreamAggregator::onPriceEvent)
                        .onErrorContinue((x, o) -> x.printStackTrace(System.out))
                        .then())
                .subscribe();
    }


    private PriceEventDTO asPriceEventDTO(String dataAsString) {
        try {
            ExternalPriceEvent priceEventWrapperDTO = objectMapper.readValue(dataAsString, ExternalPriceEvent.class);
            return priceEventWrapperDTO.toPriceEventDto(timeProvider.now());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private InstrumentEventDto asInstrumentEventDto(String dataAsString) {
        try {
            ExternalInstrumentEvent priceEventWrapperDTO = objectMapper.readValue(dataAsString, ExternalInstrumentEvent.class);
            return priceEventWrapperDTO.toInstrumentEventDTO();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
