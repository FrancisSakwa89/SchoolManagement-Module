package com.systechInterns.library;

import java.sql.Blob;

import javax.persistence.*;


@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@NamedQueries({
        @NamedQuery(name = "NQ_SELECT_USER", query = "select u from UserLogin u where u.password=:password and u.userId=:userId and userType=:userType"),
        @NamedQuery(name = "NQ_SELECT_USER_TYPE", query = "select u from UserLogin u where u.userId=: userId"),
        @NamedQuery(name = "NQ_RESET_PASSWORD", query = "select u from UserLogin u where u.email=: email"),



})

@Table(name = "tbl_login")
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String userId;
    private String email;
    @Column(unique = true, nullable = false)
    private String password;
    @Column(nullable = false)
    private String userType;
    private String userName;

    @Lob
    @Column(nullable=false, columnDefinition="mediumblob")
    private Blob image;

    public UserLogin() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

