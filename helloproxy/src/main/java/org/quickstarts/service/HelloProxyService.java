package org.quickstarts.service;

import org.jboss.resteasy.client.ClientRequest;

public class HelloProxyService {

    public String proxyHelloMessage(String name) throws Exception {
//    public String proxyHelloMessage(String service, String port, String name) throws Exception {
//        ClientRequest request = new ClientRequest("http://" + service + ":" + port + "/rest/json");
        ClientRequest request = new ClientRequest("http://common-service/rest/json");
        return request.queryParameter("name", name).get(String.class).getEntity();
    }
}
