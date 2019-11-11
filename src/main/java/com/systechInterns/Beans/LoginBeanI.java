package com.systechInterns.Beans;

import com.systechInterns.library.UserLogin;

import javax.ejb.Local;
import javax.servlet.http.Part;
import java.util.List;


@Local
public interface LoginBeanI extends BeanI<UserLogin> {
    List<UserLogin> loginUser(String password, String userId, String userType);
    UserLogin verifyUser(String password, String userId, String userType);
    UserLogin findUser(String userId);
    UserLogin resetPass(String email);
    String extractFileName(Part part);

}
