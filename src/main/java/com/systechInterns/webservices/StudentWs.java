package com.systechInterns.webservices;


import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.systechInterns.Beans.StudentBeanI;
import com.systechInterns.studentmodule.Student;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/students")
public class StudentWs {
    @EJB
    private StudentBeanI studentBeanI;
/*    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(String json) {
        Gson gson = new Gson();
        Student student = gson.fromJson(json, Student.class);
        student=studentBeanI.add(student);
        return Response.ok().entity(student).build();
    }
    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(String json) {
        Gson gson = new Gson();
        Student student = gson.fromJson(json, Student.class);
        student=studentBeanI.update(student);
        return Response.ok().entity(student).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public Response readProductList() throws SQLException {
        List<Student> students = studentBeanI.getStudentList();
        return Response.ok().entity(students).build();

    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateStudent")
    public Response updateProduct(String json) {
        Gson gson=new Gson();
        Student student = gson.fromJson(json,Student.class);
       student= studentBeanI.edit(student);
        return Response.ok().entity(student).build();
    }*/
    /*@GET
    @Path("/findAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(Student student) {
        Gson gson = new Gson();
        Student student = gson.toJson(json, Student.class);
        student=studentBeanI.findAll(student);
        return Response.ok().entity(student).build();
    }*/
    @POST
    @Path("/findByRegistrationNumber")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByRegistrationNumber(String json) {
        System.out.println(json);

        String registrationNumber=new JsonParser()
                .parse(json)
                .getAsJsonObject()
                .get("registrationNumber")
                .getAsString();
        System.out.println(registrationNumber);

        return Response.ok().entity(studentBeanI.findByRegistrationNo(registrationNumber)).build();
    }

}