package com.systechInterns.studentmodule;

import javax.persistence.*;

@Entity
@Table(name = "tbl_course_units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String unitCode;
    private String unitName;
    @ManyToOne
    private Course course;


}
