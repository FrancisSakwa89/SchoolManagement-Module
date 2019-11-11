package com.systechInterns.controllers.login;


import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.UserLogin;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;


@WebServlet(name = "acc", urlPatterns = "/acc")

@MultipartConfig(maxFileSize = 1)
public class AccountServlet extends HttpServlet {
    @EJB
    LoginBeanI loginBeanI;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session != null) {

            UserLogin user = loginBeanI.findUser((String) session.getAttribute("userId"));
            if (user != null) {
                try {
                    if (session.getAttribute("userType").equals("LIBRARIAN")) {
                        req.getRequestDispatcher("/views/userLogin/librarian.jsp").include(req, resp);
                        req.setAttribute("user", user);
                        req.getRequestDispatcher("views/userLogin/profile.jsp").include(req, resp);

                    } else if (session.getAttribute("userType").equals("STUDENT")) {
                        req.getRequestDispatcher("/views/userLogin/student.jsp").include(req, resp);
                        req.setAttribute("user", user);
                        req.getRequestDispatcher("views/userLogin/profile.jsp").include(req, resp);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("login");
                requestDispatcher.forward(req, resp);
                System.out.println("session is null..");
            }

        }
        else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("login");
                requestDispatcher.forward(req, resp);
                System.out.println("session is null..");
            }
        }
    }


