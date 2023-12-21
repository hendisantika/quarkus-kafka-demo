package com.hendisantika;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-kafka-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/21/23
 * Time: 14:10
 * To change this template use File | Settings | File Templates.
 */
public class Quote {
    String company;
    Double value;
    Double change;
    String time;

    public Quote(String company) {
        this.company = company;

    }

    public Quote() {
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
