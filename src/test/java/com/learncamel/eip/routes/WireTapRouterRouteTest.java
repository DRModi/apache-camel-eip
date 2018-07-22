package com.learncamel.eip.routes;

import com.learncamel.eip.routes.wiretap.WireTapRouterRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class WireTapRouterRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new WireTapRouterRoute();
    }

    @Test
    public void wireTapTest() throws InterruptedException {

        Thread.sleep(2000);

        File outFile = new File("data/wiretap/output/inputLogFile.log");
        File debugFile = new File("data/wiretap/debug/inputLogFile.log");

        assertTrue(outFile.exists());
        assertTrue(debugFile.exists());

    }



}
