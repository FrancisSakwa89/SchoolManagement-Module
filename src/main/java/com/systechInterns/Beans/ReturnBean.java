package com.systechInterns.Beans;

import com.google.gson.Gson;
import com.systechInterns.library.Return;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@Local
public class ReturnBean extends Bean<Return> implements RetunBeanI {
    @Inject
    private transient Logger logger;


    @PostConstruct
    public void init() {
        this.entityClass = Return.class;
    }


    @Override
    public List<Return> readAll() {
        List<Return> returnList = this
                .entityManager
                .createNamedQuery("NQ_SELECT_BOOKS_RETURNED")
                .getResultList();
        logger.info(new Gson().toJson(returnList));
        return returnList;
    }
}
