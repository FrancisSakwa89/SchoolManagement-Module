package com.systechInterns.controllers.login.basicAuth;

import com.systechInterns.Beans.CodeBeanI;
import com.systechInterns.library.UserRandomCode;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "code", urlPatterns = "/code")
public class CodeVerificationServlet extends HttpServlet {
    @EJB
    CodeBeanI codeBeanI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String code = req.getParameter("code");
        HttpSession session = req.getSession();

        try {
//            UserRandomCode user = codeBeanI.verifyCode(code, req);
//            if ((user != null && user.getCode().equals(code))) {
                if (session.getAttribute("userType").equals("LIBRARIAN")) {
                    System.out.println("Logged in as Librarian..");
                    session.setAttribute("userId", session.getAttribute("userId"));
                    session.setAttribute("userType", session.getAttribute("userType"));
                    req.setAttribute("password", session.getAttribute("password"));
                    req.setAttribute("userType", session.getAttribute("userType"));
                    req.setAttribute("userId", session.getAttribute("UserId"));
                    req.getRequestDispatcher("/views/userLogin/librarian.jsp").forward(req, resp);
                } else if (session.getAttribute("userType").equals("STUDENT")) {

                    System.out.println("logged in as student...");
                    session.setAttribute("userId", session.getAttribute("userId"));
                    session.setAttribute("userType", session.getAttribute("userType"));
                    req.setAttribute("password", session.getAttribute("password"));
                    req.setAttribute("userType", session.getAttribute("userType"));
                    req.setAttribute("userId", session.getAttribute("UserId"));

                    req.getRequestDispatcher("/views/userLogin/student.jsp").forward(req, resp);


                } else {
                    resp.sendRedirect("login");
                    req.setAttribute("errorMsg", "Invalid credentials provided..");

                }

//            }
//
//            else {
//                resp.sendRedirect("code");
//                req.setAttribute("errorMsg", "Invalid Code provided..");
//                System.out.println("Invalid credentials..");
//            }


        }
        catch(Exception e1){
            e1.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/userLogin/codeverification.jsp").forward(req,resp);
    }
}