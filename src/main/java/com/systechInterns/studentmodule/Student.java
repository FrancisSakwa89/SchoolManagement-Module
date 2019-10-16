package com.systechInterns.studentmodule;

import javax.persistence.*;
import java.util.Date;

@Entity

@NamedQueries(value = {
        @NamedQuery(
                name = "NQ_FIND_ALL",
                query = "select s from Student s"
        ),

        @NamedQuery(
                name = "NQ_FINDBYNAME",
                query = "SELECT s from Student s where s.name = :name"),


        @NamedQuery(
                name = "NQ_FINDBYREGNO",
                query = "SELECT s from Student s where s.registrationNumber = :registrationNumber")

})
@Table(name = "tbl_students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String registrationNumber;
    @Embedded
    private Name name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;


    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", name=" + name +
                ", course=" + course +
                ", address=" + address +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
