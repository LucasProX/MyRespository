package com.lucas;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentMapperTest {
    public static SqlSession sqlSession;
    public static StudentMapper studentMapper;

    @Before
    public void before() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream in = Resources.getResourceAsStream("MyBatis-Config.xml");
        SqlSessionFactory sqlSessionFactory =  sqlSessionFactoryBuilder.build(in);
        sqlSession = sqlSessionFactory.openSession();

        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }


    @Test
    public void testSeletByGrade(){
        List<Student> usersList = studentMapper.selectByGrade("888");
        for (Student u : usersList) {
            System.out.println(u);
        }
    }
}
