package com.systechInterns.webservices;

import com.google.gson.Gson;
import com.systechInterns.Beans.PublisherI;
import com.systechInterns.library.Publisher;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/pub")
public class PublisherWs {
    @EJB
    PublisherI publisherI;

    @POST
    @Path("/add")
    public Response add(String json){
        Publisher publisher = new Gson().fromJson(json,Publisher.class);
        publisher = publisherI.add(publisher);
        System.out.println("successfully added publisher..."+" "+publisher);
        return Response.ok().entity(publisher).build();

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() throws SQLException {
        return Response.ok().entity(publisherI.readAll()).build();
    }

    @GET
    @Path("/{id}/getById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPubById(@PathParam("id") long id){
//        System.out.println("got this pub ..."+" "+publisherI.read(id).getPublisherName());
        return Response.ok().entity(publisherI.read(id)).build();

    }

    @GET
    @Path("/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePubById(long id, String json){
        Publisher publisher  = new Publisher();
        publisher.setId(id);
        System.out.println("updated successfully"+" name: "+ publisher);
        return Response.ok().entity(publisherI.update(publisher)).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/delete")
    public Response deleteProduct(@PathParam("id") int id){

        Publisher publisher = new Publisher();
        publisher.setId(id);
        System.out.println("deleted successfully"+" id: "+ publisher);
        return Response.ok().entity(publisherI.delete(publisher)).build();
    }
}
