package com.hendisantika;

import io.smallrye.reactive.messaging.annotations.Channel;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import java.util.ArrayList;
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

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.APPLICATION_JSON)
    public Publisher<Quote> stream() {
        return quotes;
    }

    @GET
    @Path("/init")
    public List<Quote> getList() {
        List<Quote> list = new ArrayList();
        for (String ticker : stocks) {
            list.add(new Quote(ticker));
        }
        return list;
    }
}
