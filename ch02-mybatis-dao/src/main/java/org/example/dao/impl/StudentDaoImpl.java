package org.example.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudent() {
        //获取SqlSession对象
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        String sqlid="org.example.dao.StudentDao.selectStudent";
        //执行sql，使用sqlsession的方法
        List<Student> studentList=sqlSession.selectList(sqlid);
        //关闭
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        String sqlid="org.example.dao.StudentDao.insertStudent";
        //执行sql，使用sqlsession的方法
        int nums=sqlSession.insert(sqlid,student);
        //提交事物
        sqlSession.commit();
        //关闭
        sqlSession.close();
        return nums;
    }
}
