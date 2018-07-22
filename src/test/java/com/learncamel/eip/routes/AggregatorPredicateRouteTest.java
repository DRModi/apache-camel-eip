package com.learncamel.eip.routes;

import com.learncamel.eip.routes.aggregator.AggregatorPredicateRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregatorPredicateRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new AggregatorPredicateRoute();
    }


    @Test
    public void predicateRouteTest() throws InterruptedException {

        String requestStr = "Received the request order -";
        String responseStr = " confirm-response sent back!!";
        String expectedValue = requestStr + responseStr;

        MockEndpoint mock = getMockEndpoint("mock:outputMessage");
        mock.expectedBodiesReceived(expectedValue);

        template.sendBodyAndHeader("direct:inputContent",requestStr,"aggregatorId","123");
        template.sendBodyAndHeader("direct:inputContent",responseStr,"aggregatorId","123");

        assertMockEndpointsSatisfied();


    }

}
