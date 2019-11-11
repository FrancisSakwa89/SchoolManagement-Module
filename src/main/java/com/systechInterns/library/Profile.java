package com.systechInterns.library;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "NQ_PHOTOS", query = "select p from Profile p"),
        @NamedQuery(name = "NQ_PHOTOS_USER", query = "select p from Profile p where p.userId=:userId"),


})


@Table(name = "tbl_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String photo;
    private String userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
