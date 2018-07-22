package com.learncamel.eip.routes;

import com.learncamel.eip.routes.aggregator.SimpleAggregatorRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleAggregatorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new SimpleAggregatorRoute();
    }

    @Test
    public void TestAggregatore() throws InterruptedException {


        MockEndpoint mock = getMockEndpoint("mock:outputAggregateMessage");
        mock.expectedBodiesReceived("Hard Work! No Option!!");


        template.sendBodyAndHeader("direct:inputContent","Hard ", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:inputContent","Work! ", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:inputContent","No Option!!", "aggregatorId", 1);

        template.sendBodyAndHeader("direct:inputContent","Hard ", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:inputContent","Hard ", "aggregatorId", 3);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void TestAggregator_MultipleMessages() throws InterruptedException {


        MockEndpoint mock = getMockEndpoint("mock:outputAggregateMessage");

        List<String> expectedBodyList = new ArrayList();
        expectedBodyList.add("Hard Work! No Option!!");
        expectedBodyList.add("Hard Work Works!! But Working really hard takes you Far!!");
        mock.expectedBodiesReceived(expectedBodyList);



        template.sendBodyAndHeader("direct:inputContent","Hard ", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:inputContent","Work! ", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:inputContent","No Option!!", "aggregatorId", 1);

        template.sendBodyAndHeader("direct:inputContent","Hard Work Works!!", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:inputContent"," But Working really hard", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:inputContent"," takes you Far!!", "aggregatorId", 2);

        assertMockEndpointsSatisfied();
    }



}
