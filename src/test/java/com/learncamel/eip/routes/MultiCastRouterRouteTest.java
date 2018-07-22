package com.learncamel.eip.routes;

import com.learncamel.eip.routes.multicast.MultiCastRouterRoute;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class MultiCastRouterRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder(){
        return new MultiCastRouterRoute();
    }


    @Test
    public void MultiCastRouteTest() throws InterruptedException {

        Thread.sleep(5000);

        File fileOutDir1 = new File("data/multicast/output/dir1");
        File fileOutDir2 = new File("data/multicast/output/dir2");
        File fileOutDir3 = new File("data/multicast/output/dir3");


        assertTrue(fileOutDir1.isDirectory());
        assertTrue(fileOutDir2.isDirectory());
        assertTrue(fileOutDir3.isDirectory());
    }



}
