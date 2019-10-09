package com.systechInterns.examsmodule;


import com.systechInterns.studentmodule.Student;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_exam_results")
public class ExamResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Student student;
    @OneToOne
    private Exam exam;
    private BigDecimal marks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }


    public BigDecimal getMarks() {
        return marks;
    }

    public void setMarks(BigDecimal marks) {
        this.marks = marks;
    }
}
