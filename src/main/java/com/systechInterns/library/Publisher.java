package com.systechInterns.library;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "NQ_SELECT_PUB", query = "select p from Publisher p where p.publisherName = :publisherName")
})


@Table(name = "tbl_publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String publisherName;
    private String publisherCity;
    private String publisherCountry;

    public Publisher() {
    }

    public Publisher(String publisherName, String publisherCity, String publisherCountry) {
        this.publisherName = publisherName;
        this.publisherCity = publisherCity;
        this.publisherCountry = publisherCountry;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public String getPublisherCountry() {
        return publisherCountry;
    }

    public void setPublisherCountry(String publisherCountry) {
        this.publisherCountry = publisherCountry;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                ", publisherCity='" + publisherCity + '\'' +
                ", publisherCountry='" + publisherCountry + '\'' +
                '}';
    }
}
