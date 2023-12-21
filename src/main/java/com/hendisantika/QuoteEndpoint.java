package com.hendisantika;

import io.smallrye.reactive.messaging.annotations.Channel;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.reactivestreams.Publisher;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-kafka-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/21/23
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
@Path("/quotes")
public class QuoteEndpoint {

    @Channel("in-memory-stream")
    Publisher<Quote> quotes;

    @ConfigProperty(name = "stock.tickers")
    List<String> stocks;
}
