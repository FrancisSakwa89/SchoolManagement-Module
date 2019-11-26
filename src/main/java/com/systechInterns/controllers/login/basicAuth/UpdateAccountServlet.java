package com.systechInterns.controllers.login.basicAuth;

import com.systechInterns.Beans.FileUpload;
import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.UserLogin;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Blob;


@WebServlet(name = "upAcc", urlPatterns = "/upAcc")
@MultipartConfig(maxFileSize = 16177215)
public class UpdateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = -1623656324694499109L;

    @EJB
    LoginBeanI loginBeanI;

    @EJB
    FileUpload fileUpload;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userName = req.getParameter("username");


        try {
            fileUpload.checkFile(req,resp);
            UserLogin userLogin = loginBeanI.findUser(userId);
            userLogin.setUserName(userName);
            loginBeanI.update(userLogin);
            System.out.println("Added successfully..");
            req.setAttribute("user", userLogin);
            resp.sendRedirect("acc");


        } catch (Exception ex) {
            System.out.println("Error occurred..");
            ex.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String userId = String.valueOf(req.getParameter("userId"));
        try {
            UserLogin user = loginBeanI.findUser(userId);
            req.setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/views/userLogin/UpdateProfile.jsp").forward(req, resp);
    }
}
