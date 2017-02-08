package org.quickstarts.rest;


import org.quickstarts.service.HelloService;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/")
public class HelloWorld {

    @Inject
    private HelloService helloService;

    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON(@QueryParam("name") @DefaultValue("World") String name) {
        return "{\"result\":\"" + helloService.createHelloMessage(name) + "\"}";
    }

}x