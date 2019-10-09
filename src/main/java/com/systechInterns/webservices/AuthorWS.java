package com.systechInterns.webservices;


import com.google.gson.Gson;
import com.systechInterns.Beans.AuthorI;
import com.systechInterns.library.Author;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/authors")
public class AuthorWS {
    @EJB
    AuthorI authorI;
    @POST
    @Path("/add")
    public Response add(String json){
        Author author = new Gson().fromJson(json,Author.class);
        author = authorI.add(author);
        return Response.ok().entity(author).build();

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response list() throws SQLException {
        return Response.ok().entity(authorI.readAll()).build();
    }

    @GET
    @Path("{id}/getById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBookById(long id) throws SQLException {
        return Response.ok().entity(authorI.read(id)).build();

    }

    @GET
    @Path("{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookById(long id, String json){
        Author author = new Author();
        author.setId(id);
        System.out.println("updated successfully"+" name: "+ author.getName());
        return Response.ok().entity(authorI.update(author)).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/delete")
    public Response deleteProduct(@PathParam("id") int id){

        Author author = new Author();
        author.setId(id);
        System.out.println("deleted successfully"+" id: "+ author);
        return Response.ok().entity(authorI.delete(author)).build();
    }
}
