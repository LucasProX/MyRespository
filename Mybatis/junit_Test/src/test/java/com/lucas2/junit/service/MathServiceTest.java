package com.lucas2.junit.service;
import com.lucas2.MathService;
import org.junit.Assert;
import org.junit.Test;

/**
 * 单元测试类
 */
public class MathServiceTest{  //可以点这里执行全部方法的测试
    //一个业务方法对应一个测试方法
    //加了Test注解相当于加了一个psvm，就直接可以执行了
    @Test
    public void testAdd(){
        //单元测试中有两个重要的概念
        //一个是实际值，一个是期望值(期望的执行结果是多少)
        MathService mathService = new MathService();
        //实际值
        int actual = mathService.add(1,99);
        //期望值
        int expect = 100;
        //加断言进行测试
        Assert.assertEquals(expect,actual);

    }

    @Test
    public void testSub(){
        //单元测试中有两个重要的概念
        //一个是实际值，一个是期望值(期望的执行结果是多少)
        MathService mathService = new MathService();
        //实际值
        int actual = mathService.sub(99,99);
        //期望值
        int expect = 0;
        //加断言进行测试
        Assert.assertEquals(expect,actual);

    }


}
