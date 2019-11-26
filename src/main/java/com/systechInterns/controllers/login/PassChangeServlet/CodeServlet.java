package com.systechInterns.controllers.login.PassChangeServlet;

import com.systechInterns.Beans.CodeBeanI;
import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.UserLogin;
import com.systechInterns.library.UserRandomCode;
import com.twilio.sdk.resource.ipmessaging.v1.service.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "passChange", urlPatterns = "/passChange")
public class CodeServlet extends HttpServlet {
    @EJB
    LoginBeanI loginBeanI;

    @EJB
    CodeBeanI codeBeanI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        HttpSession session = req.getSession();

        UserRandomCode user = codeBeanI.verifyCode(code, req);
        try {
            if (user.getCode().equals(code)){
                String userId = user.getUserId();
                String password = String.valueOf(session.getAttribute("password"));
                UserLogin userLogin = loginBeanI.findUser(userId);
                userLogin.setPassword(password);
                loginBeanI.update(userLogin);
                resp.sendRedirect("msgPass");
            }
            else {
                resp.sendRedirect("passChange");
            }
        }catch (Exception e){
            resp.sendRedirect("passChange");

            System.out.println("Got an error");
            e.printStackTrace();
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/userLogin/userPassword/PassChange.jsp").forward(req,resp);

    }
}
