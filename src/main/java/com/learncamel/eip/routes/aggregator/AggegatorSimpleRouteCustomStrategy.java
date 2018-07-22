package com.learncamel.eip.routes.aggregator;

import org.apache.camel.Exchange;

import java.util.StringTokenizer;

public class AggegatorSimpleRouteCustomStrategy implements org.apache.camel.processor.aggregate.AggregationStrategy {


    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        if(oldExchange==null){
            return newExchange;
        } else {

            String oldBody = oldExchange.getIn().getBody().toString();
            String newBody = newExchange.getIn().getBody().toString();

            newBody = oldBody.concat(newBody);

            newExchange.getIn().setBody(newBody);
        }


        return newExchange;
    }
}
