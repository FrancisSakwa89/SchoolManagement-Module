package com.systechInterns.webservices;

import com.systechInterns.Beans.RetunBeanI;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

import static okhttp3.internal.Internal.logger;

@Path("/returns")
public class ReturnWs {
    private CustomResponse customResponse = new CustomResponse();
    @EJB
    RetunBeanI retunBeanI;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response list() throws SQLException {
        customResponse.setData(retunBeanI.readAll());
        customResponse.setMessage("All Returns made are as follows: ");
        customResponse.setStatus(true);

        logger.info("Message: "+customResponse.getMessage()+" data"+customResponse.getData()+customResponse.isStatus());
        return Response.ok().entity(customResponse).build();
    }
}
