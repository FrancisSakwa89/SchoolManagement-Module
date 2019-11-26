package com.systechInterns.Beans;

import com.systechInterns.library.UserRandomCode;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Stateless
@Local
public class CodeBean extends Bean<UserRandomCode> implements CodeBeanI {
    @PostConstruct
    public void init() {
        this.entityClass = UserRandomCode.class;
    }

    @Override
    public String sendCode(HttpServletRequest req) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890#$@&";
        int length = 10;
        Random random = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }

        String userId = String.valueOf(req.getAttribute("userId"));

        try{
            UserRandomCode userRandomCode = checkUser(userId);
            if (userRandomCode == null){
                UserRandomCode user = new UserRandomCode();
                user.setUserId(userId);
                user.setCode(String.valueOf(text));
                Date date = new Date();
                add(user);
                System.out.println("Created user..");
            }
            else {
                UserRandomCode userCode = checkUser(userId);
                userCode.setCode(String.valueOf(text));
                update(userCode);
                System.out.println("Updated user");
            }
        }catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        System.out.println(text);
        return new String(text);
    }


    @Override
    public UserRandomCode verifyCode(String code, HttpServletRequest req) {
        List<UserRandomCode> userLoginList = this
                .entityManager
                .createNamedQuery("NQ_VERIFY_CODE")
                .setParameter("code", code)

                .getResultList();
        for (UserRandomCode user : userLoginList) {
            String userId = String.valueOf(req.getAttribute("userId"));

            if (user.getCode().equals(code) && user.getUserId().equals(userId)) {
                System.out.println("User found..and your user pass is .." + user.getUserId());
            } else {
                System.out.println("No user found with that code..");
            }
        }
        return userLoginList.size() > 0 ? userLoginList.get(0) : null;
    }

    public UserRandomCode checkUser(String userId){
        List<UserRandomCode> userLoginList = this
                .entityManager
                .createNamedQuery("NQ_USER_CODE")
                .setParameter("userId", userId)

                .getResultList();

        return userLoginList.size() > 0 ? userLoginList.get(0) : null;

    }

//    @Schedule(minute="*/2", hour="*", persistent = false)
//    public void checkCodeValidity(String code){
//        UserRandomCode user = checkUser(code);
//        Date dateSend = user.getDate();
//        Date date = new Date();
//        int diff = (int) (dateSend.getTime() - date.getTime());
//        int sendPeriod = (int) TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
//        if (sendPeriod > 2){
//            delete(user);
//            System.out.println("Performing check...");
//        }
//    }

}
