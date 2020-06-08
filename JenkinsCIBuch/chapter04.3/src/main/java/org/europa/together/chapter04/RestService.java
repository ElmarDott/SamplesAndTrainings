package org.europa.together.chapter04;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sample")
public class RestService {

    @GET
    @Path("/chapter")
    @Produces({MediaType.TEXT_PLAIN})
    public Response foo() {
        return Response.status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON)
                .entity("Lorem ipsum")
                .encoding("UTF-8")
                .build();
    }

}
