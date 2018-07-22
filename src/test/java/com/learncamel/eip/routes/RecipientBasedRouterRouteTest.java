package com.learncamel.eip.routes;

import com.learncamel.eip.routes.recipientlist.RecipientBasedRouterRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class RecipientBasedRouterRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new RecipientBasedRouterRoute();
    }

    @Test
    public void contentBasedOrdersTest() throws InterruptedException {

        Thread.sleep(5000);

        File fileUSADir = new File("data/recipientlist/output/USA");
        assertTrue(fileUSADir.isDirectory());

        File fileINDIADir = new File("data/recipientlist/output/INDIA");
        assertTrue(fileINDIADir.isDirectory());

        File fileGeneralDir = new File("data/recipientlist/output/General");
        assertTrue(fileINDIADir.isDirectory());


    }
}
