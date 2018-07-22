package com.learncamel.eip.routes.wiretap;

import org.apache.camel.builder.RouteBuilder;

public class WireTapRouterRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:data/wiretap/input?noop=true")
                .wireTap("file:data/wiretap/debug")
                .to("file:data/wiretap/output?noop=true");
    }

}
