# apache-learn-camel-eip (Enterprise Integration Patterns (EIP))
*****************************************************************

(1) Content based routing:
**************************
    -- based on file name
    -- based on file content
    -- important components are:

            .choice()
                .when().to
            .otherwise().stop() //it wont be available at end()
                .to()
            .end()
                .to() //perform general operation..


(2) MultiCast Routing:
**********************
    -- It can be achieved by doing two times .to()
    -- Allows to use parallel processing
    -- Allows to stop processing onExceptions

            from().multicast().parallelProcessing().stopOnException()
                .to("route 1", "route 2" ... "route N")

(3) Recipient List
*******************
-- It is similar to Content based routing, but here you can set and retrieve messages from/using the header/processor etc.

      .setHeader("country", xpath("/Order/Country/text()"))
                    .process(new RecipientListProcessor())
                    .recipientList(header("destFolder"));



(4) WireTap:
*************
It is being used as debugging purpose. it will be used if all input messages need to be saved which are read by input route.

            from("file:data/wiretap/input?noop=true")
                .wireTap("file:data/wiretap/debug")
                .to("file:data/wiretap/output?noop=true");

(5) Aggregator:
**************
-- Using aggregatorId (correlation key in header) and completion size and using the strategy class

        .aggregate(header("aggregatorId"), new AggegatorSimpleRouteCustomStrategy()).completionSize(3)

-- Using aggregatorId and CompletionSize and Completion Timeout, where route will return what ever received messages after timeout without complete the size

        .aggregate(header("aggregatorId"),new AggegatorSimpleRouteCustomStrategy())
                        .completionSize(3).completionTimeout(3000)

-- Using Aggregator Predicate will finish the routes based on the predicate/expected message retrieval.
    Note: whenever completionPredicate being used, eagerCheckCompletion() must be used.

            .aggregate(header("aggregatorId"), new AggegatorSimpleRouteCustomStrategy())
                            .completionPredicate(body().contains("confirm-response")).eagerCheckCompletion()


-- Grouped Exchange Aggregation Strategy: it will allow to aggregate the exchanges where as in previous cases we were aggregating the message body
