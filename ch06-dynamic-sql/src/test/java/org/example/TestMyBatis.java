package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudentIf(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        Student student=new Student();
        //student.setName("李");
        student.setAge(18);
        List<Student> students=dao.selectStudentIf(student);
        for (Student stu:students){
            System.out.println(stu);
        }

    }

    @Test
    public void testSelectStudentWhere(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        Student student=new Student();
        //student.setName("李四");
        student.setAge(18);
        List<Student> students=dao.selectStudentWhere(student);
        for (Student stu:students){
            System.out.println(stu);
        }

    }

    /**
     * java中for的循环实现
     */
    @Test
    public void testFor(){
        List<Integer> list=new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        //String sql="select * from student where id in (1001,1002,1003)";//最终拼接的结果
        String sql="select * from student where id in";
        StringBuilder builder=new StringBuilder("");
        int init=0;
        int len=list.size();

        //添加开始的（
        builder.append("(");
        for (Integer i:list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);//删掉最后一个多余的，
        builder.append(")");
        sql=sql+builder.toString();
        System.out.println(sql);
    }

    @Test
    public void testSelectStudentForeach1(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        List<Integer> list=new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students=dao.selectStudentForeach1(list);
        for (Student stu:students){
            System.out.println(stu);
        }

    }

    @Test
    public void testSelectStudentForeach2(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);//就这一句就可以创建接口的实现对象
        List<Student> students=new ArrayList<>();
        Student s1=new Student();
        s1.setId(1002);
        students.add(s1);
        s1=new Student();
        s1.setId(1003);
        students.add(s1);
        s1=new Student();
        s1.setId(1004);
        students.add(s1);

        List<Student> slist=dao.selectStudentForeach2(students);
        for (Student stu:slist){
            System.out.println(stu);
        }

    }
}
