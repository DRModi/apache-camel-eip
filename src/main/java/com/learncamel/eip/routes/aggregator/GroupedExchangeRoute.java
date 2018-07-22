package com.learncamel.eip.routes.aggregator;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class GroupedExchangeRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:inputContent")
                .log("Received Input : ${body} and headers are ${headers} and AggregatorID is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new GroupedExchangeAggregationStrategy())
                .completionSize(3)
                .log("Output Message is : ${body}")
                .to("mock:outputEndpoint");
    }
}
