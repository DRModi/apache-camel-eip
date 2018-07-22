package com.learncamel.eip.routes.multicast;

import org.apache.camel.builder.RouteBuilder;

public class MultiCastRouterRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("file:data/multicast/input?noop=true").multicast().parallelProcessing()
                .log("Received input body is ${body}").stopOnException()
                .to("log:?level=INFO&showBody=true")
                .to("file:data/multicast/output/dir1","file:data/multicast/output/dir2","file:data/multicast/output/dir3");

    }
}
