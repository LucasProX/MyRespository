package com.lucas2;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisIntroductionTest {
    public static void main(String[] args){
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象(一个数据库对应一个SqlSessionFactory对象)
            //读取mybatis核心配置文件
        InputStream is = null;
        try {
            //Mybatis中提供的工具类Resources
            is = Resources.getResourceAsStream("mybatis-config.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //opensession后面的括号可以用true开启自动提交
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql语句
        int count = sqlSession.insert("insertCar");
        List list = sqlSession.selectList("selectCar");

        //mybatis不会自动提交，需要手动提交
        sqlSession.commit();

        System.out.println("插入记录总共" + count + "条！！！");


    }
}