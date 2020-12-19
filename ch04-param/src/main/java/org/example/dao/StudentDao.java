package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;
import org.example.vo.QueryParam;

import java.util.List;

public interface StudentDao {

    /**
     * 一个简单类型的参数：mybatis把java的基本类型和string都叫简单类型
     * mapper文件获取简单类型的一个参数的值，使用 #{任意字符}
     *
     * @param id
     * @return
     */
    Student selectStudentById(Integer id);

    /**
     * 多个参数使用@Param（"参数名"） String name
     * @param name
     * @param age
     * @return
     */
    List<Student> selectMultiParam(@Param("myname") String name, @Param("myage") Integer age);

    /**
     * 多个参数，使用java对象作为接口中的方法的参数
     * @param param
     * @return
     */
    List<Student> selectMultiObject(QueryParam param);

    /**
     *多个参数，使用已有对象作为接口中的方法的参数
     * @param student
     * @return
     */
    List<Student> selectMultiStudent(Student student);

    /**
     * 测试$占位符
     * @param name
     * @return
     */
    List<Student> selectUse$(@Param("myname") String name);

    /**
     * $可以替换表名或者列名
     * @param colName
     * @return
     */
    List<Student> selectUse$OrderBy(@Param("colName") String colName);
}
