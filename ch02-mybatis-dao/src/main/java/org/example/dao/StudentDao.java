package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询
     * @return
     */
    List<Student> selectStudent();

    /**
     * 插入
     * @param student
     * @return
     */
    int insertStudent(Student student);
}
