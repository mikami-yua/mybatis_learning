package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {

        //获取SqlSession对象【重要】
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        //指定要执行的sql语句的标识。 sql映射文件的namespace+“.”+标签的id值【重要】
        String sqlid="org.example.dao.StudentDao"+"."+"selectStudents";
        //执行sql语句通过sqlid找到语句
        List<Student> studentList = sqlSession.selectList(sqlid);
        //输出结果
        studentList.forEach(stu-> System.out.println(stu));
        //关闭sqlSession对象
        sqlSession.close();
    }
}
