package com.systechInterns.controllers.login.basicAuth;

import com.systechInterns.Beans.FileUpload;
import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.UserLogin;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;


@WebServlet(name = "register", urlPatterns = "/register")
@MultipartConfig
public class RegisterAccountServlet extends HttpServlet {
    @EJB
    LoginBeanI loginBeanI;
    @EJB
    FileUpload fileUpload;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String pass2 = req.getParameter("pass2");
        String userType = req.getParameter("user");
        String email = req.getParameter("email");
        String username = req.getParameter("username");


        UserLogin user = loginBeanI.findUser(userId);
        if (password.equals(pass2)) {
            ServletContext context = req.getSession().getServletContext();
            String scheme_doc_folder = null;
            File f = new File(context.getRealPath("/"));

            if (scheme_doc_folder == null) {
                scheme_doc_folder = f.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getPath() + "/" + "Documents";
            }
            for (Part part : req.getParts()) {
                String fileName = loginBeanI.extractFileName(part);
                if (!fileName.equals("")) {
                    String savePath = scheme_doc_folder;
                    File fileSaveDir = new File(savePath);
                    if (!fileSaveDir.exists()) {
                        fileSaveDir.mkdir();
                    }
                    savePath = scheme_doc_folder + File.separator + fileName;
                    part.write(savePath);

                    File file = new File(savePath);
                    byte[] bFile = new byte[(int) file.length()];

                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);

                        //Convert file into array of bytes
                        fileInputStream.read(bFile);
                        fileInputStream.close();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }


                    try {
                        if (user != null) {
                            req.setAttribute("dMsg", "User with the Credentials already exist. Retry Again..");
                            req.getRequestDispatcher("/views/userLogin/register.jsp").forward(req, resp);

                        } else {
                            Blob fileBlob;
                            try {

                                fileBlob = new javax.sql.rowset.serial.SerialBlob(bFile);
                                UserLogin userLogin = new UserLogin();
                                userLogin.setUserType(userType);
                                userLogin.setUserId(userId);
                                userLogin.setPassword(password);
                                userLogin.setEmail(email);
                                userLogin.setUserName(username);
                                userLogin.setImage(fileBlob);

                                try {
                                    loginBeanI.add(userLogin);
                                    resp.sendRedirect("login");
                                } catch (Exception e) {
                                    System.out.println("Error creating your account...");
                                    e.printStackTrace();
                                }


                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        else {
            System.out.println("password not same..");
            resp.sendRedirect("register");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/userLogin/register.jsp").forward(req, resp);
    }


}

