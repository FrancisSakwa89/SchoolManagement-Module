package com.systechInterns.controllers.login;

import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.UserLogin;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "newPass", urlPatterns = "/newPass")
public class NewPasswordServlet extends HttpServlet {
    @EJB
    LoginBeanI loginBeanI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String newPass = req.getParameter("newPass");
        try{
            UserLogin userLogin = loginBeanI.findUser(userId);
            if (userLogin != null){
                userLogin.setPassword(newPass);
                loginBeanI.update(userLogin);
                System.out.println("Password change successful.. new pass is:"+ newPass);
                System.out.println("New user "+ userLogin);
                resp.sendRedirect("login");
            }
            else {
                System.out.println("pass not changed..");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/userLogin/newPass.jsp").forward(req,resp);
    }
}
