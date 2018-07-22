package com.learncamel.eip.routes.recipientlist;

import org.apache.camel.builder.RouteBuilder;

public class RecipientBasedRouterRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:data/recipientlist/input?noop=true")
                .setHeader("country", xpath("/Order/Country/text()"))
                .process(new RecipientListProcessor())
                .recipientList(header("destFolder"));
    }
}


