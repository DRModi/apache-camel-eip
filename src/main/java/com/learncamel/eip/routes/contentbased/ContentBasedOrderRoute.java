package com.learncamel.eip.routes.contentbased;

import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;

public class ContentBasedOrderRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:data/contentbased/orders/input?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
            .choice()
                .when(xpath("/Order/Country='USA'"))
                    .to("file:data/contentbased/orders/output/USA")
                .when(xpath("/Order/Country='INDIA'"))
                    .to("file:data/contentbased/orders/output/INDIA")
                .otherwise()
                    .to("file:data/contentbased/orders/output/General")
                .end();
    }
}
