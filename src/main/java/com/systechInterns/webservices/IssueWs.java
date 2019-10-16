package com.systechInterns.webservices;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.Beans.IssueI;
import com.systechInterns.config.Util;
import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;
import com.systechInterns.studentmodule.Student;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Stateless
@Local
@Path("/issues")
public class IssueWs {
    @EJB
    IssueI issueI;
    
    @EJB
    BookBeanI bookBeanI;


    @POST
    @Path("/add")
    public Response add(String json) {
        try {
            JsonParser jp = new JsonParser();
            JsonObject jsonObject = jp.parse(json).getAsJsonObject();
            String registrationNumber = jsonObject.get("registrationNumber").getAsString();
            String isbn = jsonObject.get("bookIsbn").getAsString();
            Book book = bookBeanI.searchBookByIsbn(isbn);
            if (book.isAvailable()) {
                Student student = new Gson().fromJson(new Util().findStudentByRegNo(registrationNumber), Student.class);
                Date dateOfIssue = new Date();
                String returnDate = jsonObject.get("dateOfReturn").getAsString();
                System.out.println(returnDate);
                Date dt= null;
                try {
                    dt = new SimpleDateFormat("yyyy-mm-dd").parse(returnDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (student != null) {

                    int issuePeriod = dt.getDay() - dateOfIssue.getDay();
                    long studentId = student.getId();
                    System.out.println(student);
                    Issue issue = new Issue();
                    issue.setBook(book);
                    issue.setDateOfIssue(dateOfIssue);
                    issue.setDateOfReturn(dt);
                    issue.setIssuePeriod(issuePeriod);
                    issue.setRenewCount(0);
                    issue.setStudentId(studentId);
                    book.setAvailable(false);

                    System.out.println("added issue to "+student);
                    return Response.ok().entity(new Gson().toJson(issueI.add(issue))).build();

                }
            }
            else {
                System.out.println("Not added issue record...");
            }
            } catch(Exception e){
                System.out.println("got an error..");
                e.printStackTrace();
            }

        return null;
    }


    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        try {
            return Response.ok().entity(new Gson().toJson(issueI.readAll())).build();
        } catch (SQLException e) {
            System.out.println("Error getting issues list..");
            e.printStackTrace();
        }
        return null;
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
    public Response updateIssueById(long id, String json) {
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
    public Response deleteIssue(@PathParam("id") int id) {

        Issue issue = issueI.read(id);
        issue.setId(id);
        //System.out.println("deleted successfully"+" id: "+ book.getId()+" "+book.getTitle()+" "+book.getIsbn()+" "+book.getPublisher()+" "+book.getAuthors());
        return Response.ok().entity(issueI.delete(issue)).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/is")
    public Response getIssueByRegNo(String json) {
        System.out.println(json);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String registrationNumber = jsonObject.get("registrationNumber").getAsString();
        String studentjson= new Util().findStudentByRegNo(registrationNumber);
        System.out.println(studentjson);
        Student student = new Gson().fromJson(studentjson, Student.class);
        if (student != null) {
            long studentId = student.getId();
            System.out.println(student);
            return Response.ok().entity( new Gson().toJson(issueI.findIssuesForStudent(studentId))).build();

        }


        return null;

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getStudentId")
    public long getStudentId(String json) {
        JsonParser jp = new JsonParser();
        JsonObject jsonObject = jp.parse(json).getAsJsonObject();
        String registrationNumber = jsonObject.get("registrationNumber").getAsString();
        Student student = new Gson().fromJson(new Util().findStudentByRegNo(registrationNumber), Student.class);
        if (student != null){
            long studentId = student.getId();
            System.out.println(" Student id is: "+studentId);
        }
        return student.getId();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteStudentIssue")
    public Response deleteStudentIssue(String json) {
        System.out.println(json);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String registrationNumber = jsonObject.get("registrationNumber").getAsString();
        String studentjson= new Util().findStudentByRegNo(registrationNumber);
        System.out.println(studentjson);
        Student student = new Gson().fromJson(studentjson, Student.class);
        if (student != null) {
            long studentId = student.getId();
            System.out.println(student);
            return Response.ok().entity( new Gson().toJson(issueI.deleteIssuesForStudent(studentId))).build();

        }

        return null;

    }

}





