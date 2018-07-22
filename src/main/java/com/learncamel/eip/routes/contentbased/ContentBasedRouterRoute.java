package com.learncamel.eip.routes.contentbased;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouterRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("file:data/contentbased/input?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .choice()
                    .when(header("CamelFileNameConsumed").endsWith(".html"))
                        .to("file:data/contentbased/output/html")
                    .when(header("CamelFileNameConsumed").endsWith(".txt"))
                        .to("file:data/contentbased/output/text")
                    .when(header("CamelFileNameConsumed").endsWith(".json"))
                        .to("file:data/contentbased/output/json")
                .otherwise()
                    .to("file:data/contentbased/output/other").stop() //it will not copy other files to "all" directory files
                .end()
                    .to("file:data/contentbased/output/allExceptOthers");
    }
}
