package org.quickstarts.rest;


import org.quickstarts.service.HelloProxyService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.logging.Logger;

@Path("/")
public class HelloWorld {

    private static final Logger LOGGER = Logger.getLogger(HelloWorld.class.getName());

    @Inject
    private HelloProxyService helloProxyService;

    @GET
    @Path("/json")
    @Produces({"application/json"})
    public String getHelloWorldJSON(@QueryParam("name") @DefaultValue("World") String name) {
        return getHelloWorldJSON("common-service", "8080", name);
    }

    @GET
    @Path("/json/{service}")
    @Produces({"application/json"})
    public String getHelloWorldJSON(@PathParam("service") String service, @QueryParam("name") @DefaultValue("World") String name) {
        try {
            return "{\"result\":\"" + helloProxyService.proxyHelloMessage(service, "80", name) + "\"}";
        } catch (Exception e) {
            LOGGER.severe("Exception: [" + e.getMessage() + "]");
            return "{\"result\":\"Exception: [" + e.getMessage() + "]\"}";
        }
    }

    @GET
    @Path("/json/{service}/{port}")
    @Produces({"application/json"})
    public String getHelloWorldJSON(@PathParam("service") String service, @PathParam("port") String port, @QueryParam("name") @DefaultValue("World") String name) {
        try {
            return "{\"result\":\"" + helloProxyService.proxyHelloMessage(service, port, name) + "\"}";
        } catch (Exception e) {
            LOGGER.severe("Exception: [" + e.getMessage() + "]");
            return "{\"result\":\"Exception: [" + e.getMessage() + "]\"}";
        }
    }

    @GET
    @Path("/simple")
    @Produces({"application/json"})
    public String getHelloWorldSimple() {
        return "{\"result\":\"Hello Simple!\"}";
    }

}