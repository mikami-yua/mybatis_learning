package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.example.vo.QueryParam;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudentById(){
        /**
         * 使用mybatis的动态代理的机制，使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象
         */
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
    public void testSelectMultiObject(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam=new QueryParam();
        queryParam.setParamName("土豆");
        queryParam.setParamAge(28);
        List<Student> students = dao.selectMultiObject(queryParam);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("张三");
        student.setAge(28);
        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("张三");
        student.setAge(28);
        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

}
