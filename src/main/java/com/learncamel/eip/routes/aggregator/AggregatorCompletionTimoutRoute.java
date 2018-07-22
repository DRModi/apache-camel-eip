package com.learncamel.eip.routes.aggregator;

import org.apache.camel.builder.RouteBuilder;

public class AggregatorCompletionTimoutRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("direct:inputContent")
                .log("Received input message is ${body} and the Aggregator Header Key is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"),new AggegatorSimpleRouteCustomStrategy())
                .completionSize(3).completionTimeout(3000)
                .log("After timeout aggregated message is ${body}")
                .to("mock:outputMessage");
    }
}
