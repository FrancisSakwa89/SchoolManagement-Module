package com.systechInterns.Beans;

import com.systechInterns.library.UserRandomCode;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface CodeBeanI extends BeanI<UserRandomCode>  {
    String sendCode(HttpServletRequest req);
    UserRandomCode verifyCode(String code, HttpServletRequest req);
}
