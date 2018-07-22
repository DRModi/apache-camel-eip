package com.learncamel.eip.routes.aggregator;

import org.apache.camel.builder.RouteBuilder;

public class SimpleAggregatorRoute extends RouteBuilder{

    public void configure() throws Exception {

        from("direct:inputContent")
                .log("Received Input content is ${body}. and Aggregator Id in header is key{header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggegatorSimpleRouteCustomStrategy()).completionSize(3)
                .log("Aggregated Output content is ${body}. and Aggregator Id in header is key{header.aggregatorId}")
                .to("mock:outputAggregateMessage");


    }
}
