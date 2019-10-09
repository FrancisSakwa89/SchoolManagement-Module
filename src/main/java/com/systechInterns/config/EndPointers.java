package com.systechInterns.config;

import javax.persistence.*;

@Entity
public class EndPointers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  long id;
    @Enumerated
    EntPoint entPoint;
    public  String url;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EntPoint getEntPoint() {
        return entPoint;
    }

    public void setEntPoint(EntPoint entPoint) {
        this.entPoint = entPoint;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
