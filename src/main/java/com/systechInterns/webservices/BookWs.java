package com.systechInterns.webservices;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.exceptions.SearchedBookNotFoundException;
import com.systechInterns.library.Book;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Stateless
@Local
@Path("/books")
public class BookWs {

    private CustomResponse customResponse = new CustomResponse();

    @EJB
    BookBeanI bookBeanI;

    @Inject
    private transient Logger logger;

    @POST
    @Path("/add")
    public Response add(String json){
        try {
            Book book = new Gson().fromJson(json,Book.class);
            book = bookBeanI.add(book);
            customResponse.setData(book);
            customResponse.setMessage("Created an Issue");
            customResponse.setStatus(true);
            return Response.ok().entity(customResponse).build();
        }catch (Exception e){
            System.out.println("got an error adding book");
            e.printStackTrace();
        }
        logger.info("Message: "+customResponse.getMessage()+" data"+customResponse.getData()+ " status: "+customResponse.isStatus());
        return Response.ok().entity(customResponse).build();

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response list() throws SQLException {
        customResponse.setData(bookBeanI.readAll());
        customResponse.setMessage("All books in the library");
        customResponse.setStatus(true);

        logger.info("Message: "+customResponse.getMessage()+" data"+customResponse.getData()+customResponse.isStatus());
        return Response.ok().entity(customResponse).build();
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
        customResponse.setData(bookBeanI.getBorrowedBooks());
        customResponse.setMessage("This are the books not available..");
        customResponse.setStatus(true);
        return Response.ok().entity(customResponse).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAvailableBooks")
    public Response getAvailableBooks(){
        customResponse.setData(bookBeanI.getAvailableBooks());
        customResponse.setMessage("This are the available books..");
        customResponse.setStatus(true);
        return Response.ok().entity(customResponse).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sb")
    public Response searchBook(String json) throws SearchedBookNotFoundException {
        JsonParser jp = new JsonParser();
        JsonObject jsonObject = jp.parse(json).getAsJsonObject();
        String bookIsbn = jsonObject.get("isbn").getAsString();
        System.out.println(json);
        Book book = bookBeanI.findBook(bookIsbn);
        System.out.println(book);
        if (book != null) {
            customResponse.setData(book);

        }
        else{
            customResponse.setMessage("not found");
            logger.error("An error was encountered when querying book details..");
        }
        return Response.ok().entity(customResponse).build();
    }

}
