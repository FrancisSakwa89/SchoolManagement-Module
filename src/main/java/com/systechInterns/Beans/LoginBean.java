package com.systechInterns.Beans;

import com.systechInterns.library.UserLogin;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.servlet.http.Part;
import java.util.List;

@Stateless
@Local
public class LoginBean extends Bean<UserLogin> implements LoginBeanI {

    @PostConstruct
    public void init() {
        this.entityClass = UserLogin.class;
    }


    @Override
    public List<UserLogin> loginUser(String password, String userId, String userType) {
        List<UserLogin> userLoginList = this
                .entityManager
                .createNamedQuery("NQ_SELECT_USER")
                .setParameter("password", password)
                .setParameter("userId", userId)
                .setParameter("userType", userType)
                .getResultList();
        for (UserLogin userLogin : userLoginList) {
            if (userLogin.getUserType().equals(userType) && userLogin.getPassword().equals(password) && userLogin.getUserId().equals(userId)) {
                userLogin.setPassword(password);
                userLogin.setUserId(userId);
                userLogin.setUserType(userType);
                System.out.println("Credentials found..." + userLogin);
            } else {
                System.out.println("Credentials not found...");
            }

        }
        return userLoginList;

    }

    @Override
    public UserLogin verifyUser(String password, String userId, String userType) {
        return (UserLogin) this
                .entityManager
                .createNamedQuery("NQ_SELECT_USER")
                .setParameter("password", password)
                .setParameter("userId", userId)
                .setParameter("userType", userType)
                .getSingleResult();

    }

    @Override
    public UserLogin findUser(String userId) {
        List<UserLogin> userLoginList = this
                .entityManager
                .createNamedQuery("NQ_SELECT_USER_TYPE")
                .setParameter("userId", userId)

                .getResultList();
        for (UserLogin user : userLoginList) {
            if (user.getUserId().equalsIgnoreCase(userId)) {
                System.out.println("User found.." + user);
            } else {
                System.out.println("User not found..");
            }
        }
        return userLoginList.size() > 0 ? userLoginList.get(0) : null;
    }

    @Override
    public UserLogin resetPass(String email) {
        List<UserLogin> userLoginList = this
                .entityManager
                .createNamedQuery("NQ_RESET_PASSWORD")
                .setParameter("email", email)

                .getResultList();
        for (UserLogin user : userLoginList) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                user.setPassword(user.getPassword());
                System.out.println("User found..and your password is .." + user.getPassword());
            } else {
                System.out.println("No user found with that email..");
            }
        }
        return userLoginList.size() > 0 ? userLoginList.get(0) : null;
    }

    @Override
    public String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }


}









