package com.hendisantika;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-kafka-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/21/23
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */
@ApplicationScoped
public class QuoteGenerator {

    int counter = 0;

    @ConfigProperty(name = "stock.tickers")
    List<String> stocks;

    @Outgoing("stock-quote")
    public Multi<Quote> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1)).map(n -> generateQuote());
    }

    private Quote generateQuote() {
        Stock stock = null;
        String ticker = stocks.get(getCounter());
        try {
            stock = YahooFinance.get(ticker);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal priceChange = stock.getQuote().getChange();

        Quote q = new Quote();
        q.setCompany(ticker);
        q.setValue(price.doubleValue());
        q.setChange(priceChange.doubleValue());

        return q;
    }
}
