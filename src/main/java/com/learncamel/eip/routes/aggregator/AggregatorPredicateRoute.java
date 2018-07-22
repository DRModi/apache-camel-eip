package com.learncamel.eip.routes.aggregator;

import org.apache.camel.builder.RouteBuilder;

public class AggregatorPredicateRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:inputContent")
                .log("Received input message is ${body} and aggregator key is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggegatorSimpleRouteCustomStrategy())
                .completionPredicate(body().contains("confirm-response")).eagerCheckCompletion()
                .log("Output Message :  ${body}")
                .to("mock:outputMessage");

    }
}
