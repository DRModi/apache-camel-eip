package com.learncamel.eip.routes;

import com.learncamel.eip.routes.aggregator.AggregatorCompletionTimoutRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregatorCompletionTimoutRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder(){
        return new AggregatorCompletionTimoutRoute();
    }

    @Test
    public void TestAggregatoreTimeout() throws InterruptedException {


        MockEndpoint mock = getMockEndpoint("mock:outputMessage");
        mock.expectedBodiesReceived("Hard Work! No other way!!");


        template.sendBodyAndHeader("direct:inputContent","Hard ", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:inputContent","Work! No other way!!", "aggregatorId", 1);

        Thread.sleep(4000);

        template.sendBodyAndHeader("direct:inputContent","No Option!!", "aggregatorId", 1);


        assertMockEndpointsSatisfied();
    }
}
