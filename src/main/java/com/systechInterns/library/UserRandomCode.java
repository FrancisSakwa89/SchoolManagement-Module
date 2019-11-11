package com.systechInterns.library;
import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name = "NQ_SELECT_CODE", query = "select u from UserRandomCode u"),
        @NamedQuery(name = "NQ_VERIFY_CODE", query = "select u from UserRandomCode u where u.code=: code"),
        @NamedQuery(name = "NQ_USER_CODE", query = "select u from UserRandomCode u where u.userId=: userId"),


})

@Table(name = "tbl_code")
public class UserRandomCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private String code;
    private String userId;

    public UserRandomCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
