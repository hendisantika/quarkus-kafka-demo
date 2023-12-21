package com.hendisantika;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
public class QuoteConverter {

    DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    @Incoming("stocks")
    @Outgoing("in-memory-stream")
    @Broadcast
    public Quote newQuote(Quote quote) throws Exception {

        Date date = Calendar.getInstance().getTime();
        String strDate = dateFormat.format(date);
        quote.setTime(strDate);

        return quote;
    }
}
