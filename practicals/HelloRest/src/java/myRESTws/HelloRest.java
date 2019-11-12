/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myRESTws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author UBlavins
 */
@Path("hellorest")
public class HelloRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloRest
     */
    public HelloRest() {
    }

    /**
     * Retrieves representation of an instance of myRESTws.HelloRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml(@QueryParam("name")String name) {
        return "<html><body><h1>Hello " + name + ", from RESTful Web Service!!" +
                "</body></h1></html>";
    }

    /**
     * PUT method for updating or creating an instance of HelloRest
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
