package com.systechInterns.controllers.Publisher;

import com.systechInterns.Beans.PublisherI;
import com.systechInterns.library.Publisher;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addPub", urlPatterns = "/addPub")
public class AddPublisherServlet extends HttpServlet {
    @EJB
    PublisherI publisherI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("views/publishers/addPublisher.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String publisherName = req.getParameter("pubName");
        String publisherCity = req.getParameter("pubCity");
        String publisherCountry = req.getParameter("pubCountry");
        try {
            publisherI.add(new Publisher(publisherName, publisherCity, publisherCountry));
            System.out.println("added pub correctly..");
            resp.sendRedirect("index.jsp");
        }catch (Exception e){
            System.out.println("Got an error adding publisher...");
            e.printStackTrace();
            resp.sendRedirect("addPub");
        }

    }
}
