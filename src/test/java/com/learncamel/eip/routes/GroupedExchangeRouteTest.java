package com.learncamel.eip.routes;

import com.learncamel.eip.routes.aggregator.GroupedExchangeRoute;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GroupedExchangeRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new GroupedExchangeRoute();
    }

    @Test
    public void GroupedExchangeTest(){

        String outputValue = "";
        String expectedValue = "if you dont prioritize your life, someone else will";
        MockEndpoint mock = getMockEndpoint("mock:outputEndpoint");
        mock.expectedMessageCount(3);


        template.sendBodyAndHeader("direct:inputContent", "if you dont ","aggregatorId","555");
        template.sendBodyAndHeader("direct:inputContent", "prioritize your life,","aggregatorId","555");
        template.sendBodyAndHeader("direct:inputContent", " someone else will","aggregatorId","555");

        //Actaully in this case the exchange which will be return from the route at the
        // mock endpoint will contain List of exchange which further contain 3 elements.
        //In Logs: CamelLogger.java 159 | Output Message is : List<Exchange>(3 elements)
        List<Exchange> exchangeContainsListOfExchanges = mock.getExchanges();
        System.out.println("List Size at : "+exchangeContainsListOfExchanges.size());


        List<Exchange> exchangeList = (List<Exchange>) exchangeContainsListOfExchanges.get(0).getProperty(Exchange.GROUPED_EXCHANGE);
        System.out.println("List Size : "+exchangeList.size());


        for (Exchange ex : exchangeList) {

          outputValue = outputValue.concat(ex.getIn().getBody().toString());
        }

        System.out.println("Output Value : "+outputValue);

        assertEquals(expectedValue,outputValue);

    }
}
