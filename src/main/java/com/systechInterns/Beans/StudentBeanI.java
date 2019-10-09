package com.systechInterns.Beans;

import com.systechInterns.studentmodule.Student;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface StudentBeanI extends BeanI<Student> {
    List<Student> findAll();
    List<Student> findByRegistrationNo(String registrationNumber);

    List<Student> getStudentList() throws SQLException;
}
