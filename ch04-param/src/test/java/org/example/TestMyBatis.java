package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
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

}
