package com.systechInterns.Beans;

import com.systechInterns.library.Return;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Local
public interface RetunBeanI extends BeanI<Return> {
    List<Return> readAll();
}
