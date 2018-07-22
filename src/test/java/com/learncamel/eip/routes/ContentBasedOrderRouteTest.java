package com.learncamel.eip.routes;

import com.learncamel.eip.routes.contentbased.ContentBasedOrderRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ContentBasedOrderRouteTest extends CamelTestSupport {


    @Override
    public RouteBuilder createRouteBuilder(){
        return new ContentBasedOrderRoute();
    }



    @Test
    public void contentBasedOrdersTest() throws InterruptedException {

        Thread.sleep(5000);

        File fileUSADir = new File("data/contentbased/orders/output/USA");
        assertTrue(fileUSADir.isDirectory());

        File fileINDIADir = new File("data/contentbased/orders/output/INDIA");
        assertTrue(fileINDIADir.isDirectory());

        File fileGeneralDir = new File("data/contentbased/orders/output/General");
        assertTrue(fileINDIADir.isDirectory());


    }
}
