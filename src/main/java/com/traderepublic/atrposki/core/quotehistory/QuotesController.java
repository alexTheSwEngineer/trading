package com.traderepublic.atrposki.core.quotehistory;
/*
 * @author aleksandartrposki@gmail.com
 * @since 28.07.19
 *
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traderepublic.atrposki.core.TimeProvider;
import com.traderepublic.atrposki.core.quotehistory.models.Candlestick;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuotesController {
    private TimeProvider timeProvider;
    private QuoteHistoryAggregator historyAggregator;
    private ObjectMapper objectMapper;

    public QuotesController(TimeProvider timeProvider, QuoteHistoryAggregator historyAggregator, ObjectMapper objectMapper) {
        this.timeProvider = timeProvider;
        this.objectMapper = objectMapper;
        this.historyAggregator = historyAggregator;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/chart/{isin}")
    public List<Candlestick> getCandlesticks(@PathVariable("isin") String isin) {
        return historyAggregator.getAggregatedHistory(isin, 30);

    }
}
