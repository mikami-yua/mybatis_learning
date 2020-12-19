package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.example.vo.QueryParam;
import org.example.vo.ViewStudent;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestMyBatis {

    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        Student student=dao.selectStudentById(1002);
        System.out.println(student);
    }

    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("李四",20);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentReturnViewStudent(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        ViewStudent student=dao.selectStudentReturnViewStudent(1001);
        System.out.println(student);
    }

    @Test
    public void testCountStudent(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);
        int student=dao.countStudent();
        System.out.println(student);
    }

    /**
     * 返回map
     */
    @Test
    public void testSelectMapById(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        Map<Object,Object> map = dao.selectMapById(1003);
        System.out.println(map);//{name=张顺飞, id=1003}  {name=张顺飞, id=1003, email=zhangfei@163.com} 三个key就有三行
    }

    @Test
    public void testSelectAllStudent(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        List<Student> students = dao.selectAllStudent();
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

}
