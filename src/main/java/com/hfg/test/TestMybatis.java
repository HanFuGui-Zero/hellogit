package com.hfg.test;

import com.hfg.entiy.User;
import com.hfg.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Create with Intellij IDEA.
 * Description：
 * User:Zero
 * Date:2021/3/22
 * Time:11:08
 */

public class TestMybatis {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void  addUser(){
        User user = new User();
        user.setName("han");
        user.setAge(23);
        user.setEmail("hhh@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
}
