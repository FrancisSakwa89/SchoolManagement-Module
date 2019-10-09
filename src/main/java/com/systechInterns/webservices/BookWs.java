package com.systechInterns.webservices;


import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.library.Book;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/books")
public class BookWs {

    @EJB
    BookBeanI bookBeanI;


    @POST
    @Path("/add")
    public Response add(String json){
        Book book = new Gson().fromJson(json,Book.class);
        book = bookBeanI.add(book);
        JsonParser jp = new JsonParser();
        jp.parse(json).getAsJsonArray();
        return Response.ok().entity(book).build();

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response list() throws SQLException {
        return Response.ok().entity(bookBeanI.readAll()).build();
    }

    @GET
    @Path("/{id}/getBook")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBookById(@PathParam("id") long id) {
            return Response.ok().entity(bookBeanI.findById(id)).build();

    }
    @PUT
    @Path("/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookById(long id, String json){
        Book book = new Book();
        book.setId(id);
        System.out.println("updated successfully"+" id: "+ book.getId()+" "+book.getTitle()+" "+book.getIsbn()+" "+book.getPublisher()+" "+book.getAuthors());
        return Response.ok().entity(bookBeanI.update(book)).build();

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/delete")
    public Response deleteBook(@PathParam("id") int id){

        Book book = bookBeanI.read(id);
        book.setId(id);
        System.out.println("deleted successfully"+" id: "+ book.getId()+" "+book.getTitle()+" "+book.getIsbn()+" "+book.getPublisher()+" "+book.getAuthors());
        return Response.ok().entity(bookBeanI.delete(book)).build();
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getBookBorrowed")
    public Response getBorrowedBook(){
        return Response.ok().entity(bookBeanI.getBorrowedBooks()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAvailableBooks")
    public Response getAvailableBooks(){
        return Response.ok().entity(bookBeanI.getAvailableBooks()).build();
    }


}
