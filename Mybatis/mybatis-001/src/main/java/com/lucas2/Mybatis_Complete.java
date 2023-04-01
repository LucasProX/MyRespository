package com.lucas2;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class Mybatis_Complete {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("Mybatis-config.xml"));

            //开启会话
            sqlSession = sqlSessionFactory.openSession();
            //执行sql语句
            int count = sqlSession.insert("insertCar");
            //手动提交
            sqlSession.commit();

        } catch (IOException e) {
            //如果出问题，就回滚事务
            if (sqlSession != null){
                sqlSession.rollback();
            }
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}
