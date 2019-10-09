package com.systechInterns.webservices;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.systechInterns.Beans.IssueI;
import com.systechInterns.config.Util;
import com.systechInterns.library.Issue;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/issue")
public class IssueWs {
    @EJB
    IssueI issueI;


    @POST
    @Path("/add")
    public Response add(String json){
        Issue issue = new Gson().fromJson(json,Issue.class);
        issue = issueI.add(issue);
//        JsonParser jp = new JsonParser();
//        jp.parse(json).getAsJsonArray();
        return Response.ok().entity(issue).build();

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response list() throws SQLException {
        return Response.ok().entity(issueI.readAll()).build();
    }

    @GET
    @Path("/getBook/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getIssueById(@PathParam("id") long id) {
        return Response.ok().entity(issueI.findById(id)).build();

    }

    @POST
    @Path("/{id}/issueBook/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response issueBook(@PathParam("id") long id) {
        return Response.ok().entity(issueI.findById(id)).build();

    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateIssueById(long id, String json){
//        String registrationNo = new JsonParser().parse()
       Issue issue = new Issue();
        issue.setId(id);
        //System.out.println("updated successfully"+" id: "+ book.getId()+" "+book.getTitle()+" "+book.getIsbn()+" "+book.getPublisher()+" "+book.getAuthors());
        return Response.ok().entity(issueI.update(issue)).build();

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteIssue(@PathParam("id") int id){

        Issue issue = issueI.read(id);
        issue.setId(id);
        //System.out.println("deleted successfully"+" id: "+ book.getId()+" "+book.getTitle()+" "+book.getIsbn()+" "+book.getPublisher()+" "+book.getAuthors());
        return Response.ok().entity(issueI.delete(issue)).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrationNo/{registrationNo}")
    public Response getIssue(@PathParam("registrationNo") String regNo){
//
//        new Util().findStudentByRegNo(regNo).
//        //System.out.println("deleted successfully"+" id: "+ book.getId()+" "+book.getTitle()+" "+book.getIsbn()+" "+book.getPublisher()+" "+book.getAuthors());
//        return Response.ok().entity(issueI.delete()).build();
        return null;
    }

//
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/getBookBorrowed")
//    public Response getBorrowedBook(){
//        return Response.ok().entity(issueI.getBorrowedBooks()).build();
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/getAvailableBooks")
//    public Response getAvailableBooks(){
//        return Response.ok().entity(bookBeanI.getBorrowedBooks()).build();
//    }

}
