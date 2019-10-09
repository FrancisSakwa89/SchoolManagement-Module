package com.systechInterns.fees;

import com.systechInterns.studentmodule.Student;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Fee fee;
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    private BigDecimal paymentAmount;
    private String referenceNumber;

}
