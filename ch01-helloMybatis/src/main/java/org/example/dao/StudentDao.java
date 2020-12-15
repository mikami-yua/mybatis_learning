package org.example.dao;

import org.example.domain.Student;

import java.util.List;

/**第二步，写接口
 * 接口操作student表
 */
public interface StudentDao {

    //查询student表的所有数据
    public List<Student> selectStudents();

    /**
     * 插入方法
     * @param student 要插入的数据
     * @return 执行后影响数据库的行数
     */
    public int insertStudent(Student student);
}
