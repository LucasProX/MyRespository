package com.lucas.Test;

import com.lucas.pojo.Users;
import com.lucas.service.UsersService;
import com.lucas.service.impl.UsersServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testUsers(){
        //创建容器并启动
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext_service.xml");
        //取出UsersServiceImpl对象
        UsersService usersService =
                (UsersService)ac.getBean("UsersServiceImpl");
        //测试功能
        int num = usersService.insert(new Users());
        System.out.println(num);
    }
}
