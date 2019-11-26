package com.systechInterns.webservices;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.systechInterns.Beans.BookBeanI;
import com.systechInterns.Beans.IssueI;
import com.systechInterns.cdi.events.IssueQualifier;
import com.systechInterns.cdi.events.Sms;
import com.systechInterns.util.Util;
import com.systechInterns.library.Book;
import com.systechInterns.library.Issue;
import com.systechInterns.studentmodule.Student;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Stateless
@Local
@Path("/issues")
@SuppressWarnings("ALL")
public class IssueWs {
    @EJB
    IssueI issueI;

    @EJB
    BookBeanI bookBeanI;


    @Inject
    @IssueQualifier.issue
    Event<Issue> issueEvent;

    @Inject
    @IssueQualifier.receive
    Event<Issue> returnBook;

    @Inject
    private transient Logger logger;


    private CustomResponse customResponse = new CustomResponse();
    private Sms sms = new Sms();

    @POST
    @Path("/add")
    public Response add(String json) {
        try {
            JsonParser jp = new JsonParser();
            JsonObject jsonObject = jp.parse(json).getAsJsonObject();
            String registrationNumber = jsonObject.get("registrationNumber").getAsString();
            String isbn = jsonObject.get("bookIsbn").getAsString();
            Book book = bookBeanI.searchBookByIsbn(isbn);
            if (book != null && book.isAvailable()) {
                Student student = new Gson().fromJson(new Util().findStudentByRegNo(registrationNumber), Student.class);
                Date dateOfIssue = new Date();
                String returnDate = jsonObject.get("dateOfReturn").getAsString();
                System.out.println(returnDate);
                SimpleDateFormat myFormat = new SimpleDateFormat("yyy-MM-dd");
                Date date2 = myFormat.parse(returnDate);

                int diff = (int) (date2.getTime() - dateOfIssue.getTime());
                int issuePeriod = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+ 1;

                System.out.println("Issue period is: "+ issuePeriod);
                if (student != null) {

                    long studentId = student.getId();
                    System.out.println(student);
                    Issue issue = new Issue();
                    issue.setBook(book);
                    issue.setDateOfIssue(dateOfIssue);
                    issue.setDateOfReturn(date2);
                    issue.setIssuePeriod(issuePeriod);
                    issue.setRenewCount(0);
                    issue.setStudentId(studentId);
                    book.setAvailable(false);
                    issueEvent.fire(issue);
                    sms.setStatus("Book successfully issued to" + student);
                    System.out.println(sms.getStatus());

                    System.out.println("added issue to " + issue);
                    System.out.println(sms);
                    return Response.ok().entity(new Gson().toJson(issueI.add(issue))).build();

                }
            } else {
                System.out.println("Not added issue record...");
            }
        } catch (Exception e) {
            System.out.println("got an error..");
            e.printStackTrace();
        }

        customResponse.setMessage("Was not able to issue book to the provided student number..");
        customResponse.setStatus(false);
        logger.error("Error occurred while issuing book ");
        return Response.ok().entity(customResponse).build();
    }




    @POST
    @Path("/renew")
    public Response renewBook(String json) {
        try {
            JsonParser jp = new JsonParser();
            JsonObject jsonObject = jp.parse(json).getAsJsonObject();
            String registrationNumber = jsonObject.get("registrationNumber").getAsString();
            String isbn = jsonObject.get("bookIsbn").getAsString();
            Book book = bookBeanI.searchBookByIsbn(isbn);
                Student student = new Gson().fromJson(new Util().findStudentByRegNo(registrationNumber), Student.class);
                Date dateOfIssue = new Date();
                String returnDate = jsonObject.get("dateOfReturn").getAsString();
                System.out.println(returnDate);
                SimpleDateFormat myFormat = new SimpleDateFormat("yyy-MM-dd");
                Date date2 = myFormat.parse(returnDate);

                int diff = (int) (date2.getTime() - dateOfIssue.getTime());
                int issuePeriod = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+ 1;

                System.out.println("Issue period is: "+ issuePeriod);
                if (student != null) {

                    long studentId = student.getId();
                    System.out.println(student);
                    Issue issue = issueI.StudentLibraryDetails(registrationNumber);
                    issue.setBook(book);
                    issue.setDateOfIssue(dateOfIssue);
                    issue.setDateOfReturn(date2);
                    issue.setIssuePeriod(issuePeriod);
                    issue.setRenewCount(0);
                    issue.setStudentId(studentId);
                    issueEvent.fire(issue);
                    sms.setStatus("Book successfully issued to" + student);
                    System.out.println(sms.getStatus());

                    System.out.println("added issue to " + issue);
                    System.out.println(sms);
                    return Response.ok().entity(new Gson().toJson(issueI.renewBook(studentId,isbn))).build();

                }

        } catch (Exception e) {
            System.out.println("Error renewing book....");
            e.printStackTrace();
        }

        customResponse.setMessage("Was not able to issue book to the provided student number..");
        customResponse.setStatus(false);
        logger.error("Error occurred while renewing book ");
        return Response.ok().entity(customResponse).build();
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
        customResponse.setMessage("No list found for the query of finding all books..");
        return Response.ok().entity(customResponse).build();
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
        String studentjson = new Util().findStudentByRegNo(registrationNumber);
        System.out.println(studentjson);
        Student student = new Gson().fromJson(studentjson, Student.class);
        if (student != null) {
            long studentId = student.getId();
            System.out.println(student);

            return Response.ok().entity(new Gson().toJson(issueI.findIssuesForStudent(studentId))).build();

        }


        customResponse.setMessage("Student with the provided registration number does not exist...");
        logger.error("Student does not exist .." + studentjson);
        return Response.ok().entity(customResponse).build();

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stuDetails")
    public Response getStudentDetails(String json) {
        System.out.println(json);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String registrationNumber = jsonObject.get("registrationNumber").getAsString();
        String studentjson = new Util().findStudentByRegNo(registrationNumber);
        System.out.println(studentjson);
        Student student = new Gson().fromJson(studentjson, Student.class);
        if (student != null) {
            long studentId = student.getId();
            System.out.println(student);

            return Response.ok().entity(new Gson().toJson(student)).build();

        }


        customResponse.setMessage("Student with the provided registration number does not exist...");
        logger.error("Student does not exist .." + studentjson);
        return Response.ok().entity(customResponse).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getStudentId")
    public long getStudentId(String json) {
        JsonParser jp = new JsonParser();
        JsonObject jsonObject = jp.parse(json).getAsJsonObject();
        String registrationNumber = jsonObject.get("registrationNumber").getAsString();
        Student student = new Gson().fromJson(new Util().findStudentByRegNo(registrationNumber), Student.class);
        if (student != null) {
            long studentId = student.getId();
            System.out.println(" Student id is: " + studentId);
        }
        assert student != null;
        return student.getId();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteStudentIssue")
    public Response deleteStudentIssue(String json) {
        System.out.println(json);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String registrationNumber = jsonObject.get("registrationNumber").getAsString();
        String bookIsbn = jsonObject.get("bookIsbn").getAsString();
        String studentjson = new Util().findStudentByRegNo(registrationNumber);
        System.out.println(studentjson);
        Student student = new Gson().fromJson(studentjson, Student.class);
        if (student != null) {
            long studentId = student.getId();

            Issue issue = (Issue) issueI.deleteIssuesForStudent(studentId, bookIsbn);
            sms.setStatus("Student issued with the book deleted..." + student);
            returnBook.fire(issue);
            customResponse.setData(new Gson().toJson(issue));
            customResponse.setMessage("Issue for student successifully");
            customResponse.setStatus(true);
            System.out.println(sms.getStatus());
            return Response.ok().entity(customResponse).build();

        }

        customResponse.setMessage("Did not find issues to delete for student..");
        customResponse.setStatus(false);
        logger.error("Got an error deleting student issue");
        return Response.ok().entity(customResponse).build();

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sid")
    public Response getRegNo(String json) {
        System.out.println(json);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String studentId = jsonObject.get("id").getAsString();
        String studentjson = new Util().findStudentByRegNo(studentId);
        System.out.println(studentjson);
        Student student = new Gson().fromJson(studentjson, Student.class);
        if (student != null) {

            System.out.println(student);

            return Response.ok().entity(new Gson().toJson(studentId)).build();

        }


        customResponse.setMessage("Student with the provided id is:" + student);
        logger.info("Student with the provided id is:" + student);
        return Response.ok().entity(customResponse).build();

    }
}







