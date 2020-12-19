package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;
import org.example.vo.QueryParam;
import org.example.vo.ViewStudent;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    Student selectStudentById(Integer id);

    List<Student> selectMultiParam(@Param("myname") String name, @Param("myage") Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudent();

    //定义方法返回map
    //key value 建议使用object
    Map<Object,Object> selectMapById(@Param("stuid") Integer id);

    /**
     * 使用resultMap定义映射关系
     * @return
     */
    List<Student> selectAllStudent();
}
