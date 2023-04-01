package com.lucas;


import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class StuTest{
    @Test
    public void StudentTest(){
        Student stu = new Student();
        System.out.println(stu);
    }

    @Test
    public void StuSpringTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu = (Student)ac.getBean("stu");
        System.out.println(stu);
    }

}
