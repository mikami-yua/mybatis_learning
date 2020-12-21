package org.example.dao;


import org.example.domain.Student;

import java.util.List;

public interface OrderDao {

    /**
     * 使用if标签的动态sql
     * 动态sql需要使用java对象作为参数
     * @param student
     * @return
     */
    List<Student> selectStudentIf(Student student);

    /**
     * where标签的使用
     * @param student
     * @return
     */
    List<Student> selectStudentWhere(Student student);

    /**
     * foreach用法1
     * @param
     * @return
     */
    List<Student> selectStudentForeach1(List<Integer> idlist);

    /**
     * foreach用法2 循环list中对象的属性值
     * @param sdlist
     * @return
     */
    List<Student> selectStudentForeach2(List<Student> sdlist);
}
