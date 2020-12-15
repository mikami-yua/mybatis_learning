package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudent(){
        /**
         * 使用mybatis的动态代理的机制，使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象
         */
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        //调用dao的方法执行数据库操作
        List<Student> students= dao.selectStudent();
        for (Student stu:students){
            System.out.println(stu);
        }
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setId(1007);
        student.setName("卷毛");
        student.setEmail("juanmao@123.com");
        student.setAge(20);
        int num=dao.insertStudent(student);
        sqlSession.commit();//没有实现类帮忙提交了，需要自己提交
        System.out.println(num);
    }
}
