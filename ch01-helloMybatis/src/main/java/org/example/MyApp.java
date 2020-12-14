package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //访问mybatis，读取student数据
        //1.定义mybatis主配置文件的名称,(从类路径的根开始，target/classes)
        String config="mybatis.xml";
        //2.读取config表示的文件
        InputStream in= Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //5.获取SqlSession对象【重要】
        SqlSession sqlSession=factory.openSession();
        //6.指定要执行的sql语句的标识。 sql映射文件的namespace+“.”+标签的id值【重要】
        String sqlid="org.example.dao.StudentDao"+"."+"selectStudents";
        //7.执行sql语句通过sqlid找到语句
        List<Student> studentList = sqlSession.selectList(sqlid);
        //8.输出结果
        studentList.forEach(stu-> System.out.println(stu));
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
