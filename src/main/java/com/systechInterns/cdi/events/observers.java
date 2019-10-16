package com.systechInterns.cdi.events;


import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;

public class observers {
    @PostConstruct
    public void issueBookObserveEvent(@Observes @IssueQualifier.issue Sms sms) {
        String message = sms.setStatus("Issue method is being observed");
        System.out.println(message);
    }

    @PostConstruct
    public void returnBookIssued(@Observes @IssueQualifier.receive Sms sms) {
        String message = sms.setStatus("Receive book method is being observed");
        System.out.println(message);

    }
}
