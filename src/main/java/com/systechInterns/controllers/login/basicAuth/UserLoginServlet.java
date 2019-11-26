package com.systechInterns.controllers.login.basicAuth;

import com.systechInterns.Beans.CodeBeanI;
import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.EmailFormat;
import com.systechInterns.library.UserLogin;

import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "login", urlPatterns = "/login")
//@ServletSecurity(@HttpConstraint(rolesAllowed = "LIBRARIAN"))
public class UserLoginServlet extends HttpServlet {
    @EJB
    LoginBeanI loginBeanI;

    @EJB
    CodeBeanI codeBeanI;

    @EJB
    EmailFormat emailFormat;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/userLogin/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();



        try {
            UserLogin userLogin = loginBeanI.findUser(userId);
            if (userLogin != null) {
                req.setAttribute("userId", userId);
                session.setAttribute("userId", userId);
                String userType =  userLogin.getUserType();
//                String code = String.valueOf(codeBeanI.sendCode(req));
//
//                String subject = "Your User Code";
//                String content = "Hi, here is your user code kindly use it to login "+" "+ code;
                if (userLogin.getUserType().equalsIgnoreCase(userType) && userLogin.getPassword().equalsIgnoreCase(password) && userLogin.getUserId().equalsIgnoreCase(userId)) {
//                    emailFormat.sendEmail(subject,content,userLogin.getEmail());
                    loginBeanI.verifyUser(password, userId, userType);
                    userLogin.setPassword(password);
                    userLogin.setUserId(userId);
                    loginBeanI.loginUser(password, userId, userType);
                    req.setAttribute("userId", userId);
                    session.setAttribute("userId", userId);
                    String email = userLogin.getEmail();
                    req.setAttribute("email", email);

                    session.setAttribute("userId", userId);
                    session.setAttribute("userType", userType);
                    session.setAttribute("email", userLogin.getEmail());
                    userLogin.setUserType(userType);
                    userLogin.setPassword(password);
                    userLogin.setUserId(userId);
                    System.out.println("Sending msg");
                    req.getRequestDispatcher("code").forward(req, resp);
                }
                else {
                resp.sendRedirect("loginError");
                req.setAttribute("errorMsg", "Invalid credentials provided..");
                System.out.println("User is null..");
            }
            }
            else {
                resp.sendRedirect("loginError");
                System.out.println("user is null..");
            }
        } catch (Exception e) {
            System.out.println("user not found");
            e.printStackTrace();
        }

    }
}