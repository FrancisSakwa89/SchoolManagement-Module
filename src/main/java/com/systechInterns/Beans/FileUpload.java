package com.systechInterns.Beans;

import com.systechInterns.library.UserLogin;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

@Local
@Stateless
public class FileUpload {
    @EJB
    LoginBeanI loginBeanI;

    public void checkFile(HttpServletRequest req, HttpServletResponse resp) {
        try {
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

                    Blob fileBlob;
                    try {

                        fileBlob = new javax.sql.rowset.serial.SerialBlob(bFile);
                        HttpSession session = req.getSession();
                        UserLogin userLogin = loginBeanI.findUser(String.valueOf(session.getAttribute("userId")));
                        if ((userLogin) != null) {
                            System.out.println("User details are: " + userLogin);
                            userLogin.setImage(fileBlob);
                        }
                        else {
                            UserLogin user = new UserLogin();
                            System.out.println("User details are: " + user);

                            user.setImage(fileBlob);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
