package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {

    Student selectStudentById(Integer id);
}
