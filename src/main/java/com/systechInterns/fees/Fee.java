package com.systechInterns.fees;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_fees")
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateDue;
    @Enumerated(EnumType.STRING)
    private FeeType feeType;
    private BigDecimal feeAmount;
    private boolean isFullPaid;


}
