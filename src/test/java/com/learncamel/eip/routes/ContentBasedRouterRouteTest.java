package com.learncamel.eip.routes;

import com.learncamel.eip.routes.contentbased.ContentBasedRouterRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ContentBasedRouterRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder(){

        return new ContentBasedRouterRoute();
    }


    @Test
    public void contentBaseRoutingTest() throws InterruptedException {

        Thread.sleep(7000);

        File fileHTMLDir = new File("data/contentbased/output/html");
        assertTrue(fileHTMLDir.isDirectory());


        File fileTextDir = new File("data/contentbased/output/text");
        assertTrue(fileTextDir.isDirectory());

        File fileJSONDir = new File("data/contentbased/output/json");
        assertTrue(fileJSONDir.isDirectory());

        File fileOtherDir = new File("data/contentbased/output/other");
        assertTrue(fileOtherDir.isDirectory());

        File fileAllDir = new File("data/contentbased/output/allExceptOthers");
        File noXMLFile = new File("data/contentbased/output/allExceptOthers/inputXMLFile.xml");
        assertTrue(fileAllDir.isDirectory());
        assertTrue(!(noXMLFile.exists()));

    }


}
