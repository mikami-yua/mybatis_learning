package org.example;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImpl;
import org.example.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudent(){
        //org.example.dao.StudentDao
        StudentDao dao=new StudentDaoImpl();
        /*
        分析List<Student> studentList=dao.selectStudent();调用
        1.dao对象，类型是StudentDao，全限定名称org.example.dao.StudentDao
            和namespace一样
        2.调用的方法名称，selectStudent，是mapper文件中的id
        3.通过dao方法中的返回值，也可以确定MyBatis要调用的SqlSession的返回值方法
            返回值是list，调用SqlSession.selectList（）
            返回值是int或是非list，看mapper文件中的标签是<insert>/<update>就会调用SqlSession的对应方法

        mybatis的动态代理：mybatis根据dao方法的调用，获取执行sql语句的信息。
            mybatis根据dao接口，创建出一个dao接口的实现类，并创建这个类的对象
            完成SqlSession调用方法，访问数据库
         */
        List<Student> studentList=dao.selectStudent();
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }

    @Test
    public void testInsertStudent(){
        StudentDao dao=new StudentDaoImpl();
        Student student=new Student();
        student.setId(1006);
        student.setName("李赣");
        student.setEmail("xianyuwg@123.com");
        student.setAge(30);
        int num=dao.insertStudent(student);
        System.out.println(num);
    }
}
