package com.lucas.service.impl;

import com.lucas.mapper.UsersMapper;
import com.lucas.pojo.Users;
import com.lucas.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    //所有的业务逻辑层都有一个Mapper接口对象，向下兼容
    @Autowired
    UsersMapper usersMapper;

    @Override
    public int insert(Users users) {
        int num = 0;
        num = usersMapper.insert(users);
        System.out.println("增加User账户成功");
        return num;
    }
}
