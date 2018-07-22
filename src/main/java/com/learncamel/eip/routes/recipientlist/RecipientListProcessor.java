package com.learncamel.eip.routes.recipientlist;

import org.apache.camel.Exchange;

public class RecipientListProcessor implements org.apache.camel.Processor {


    public void process(Exchange exchange) throws Exception {

        String countryName = exchange.getIn().getHeader("country", String.class);

        System.out.println("\n"+ "\n"+ "****  Country Name: "+countryName+"\n"+"\n");

        if(countryName.equals("INDIA")){
            exchange.getIn().setHeader("destFolder", "file:data/recipientlist/output/INDIA");
        }
        else if(countryName.equals("USA")){
            exchange.getIn().setHeader("destFolder", "file:data/recipientlist/output/USA");
        }
        else{
            exchange.getIn().setHeader("destFolder", "file:data/recipientlist/output/General");
        }

    }
}
