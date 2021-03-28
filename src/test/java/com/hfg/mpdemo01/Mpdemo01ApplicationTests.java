package com.hfg.mpdemo01;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hfg.entiy.User;
import com.hfg.handler.MyMetaObjectHandler;
import com.hfg.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.*;

/**
*@description:
*@author:Zero
*@date:2021/3/21 23:16
*@param:
*@return:
**/
@SpringBootTest
@Slf4j
public class Mpdemo01ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    /**
    *@Description:User表中的所有数据
    */
    @Test
    public void contextLoads() {
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    /**
    *@Description:insert往数据库添加数据
    */
    @Test
    public void addUser(){
        User user = new User();
        user.setName("令狐冲");
        user.setAge(23);
        user.setEmail("1841814080@qq.com");
        
        //原始方式
       // user.setCreateTime(new Date());
       // user.setUpdateTime(new Date());
         int insert =userMapper.insert(user);
    }
    /**
    *@Description:update,通过id修改User
    */
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(17l);
        user.setAge(1222);
        //user.setUpdateTime(new Date());
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    /**
    *@Description:select
    */
    @Test
    public void queryUserById(){
        User user = userMapper.selectById(22l);
        System.out.println(user);
    }
    /**
    *@Description：根据用户表的Id删除一条记录
    */
    @Test
    public void deleteUser(){
        userMapper.deleteById(10l);
    }
    /**
     *@Description:测试乐观锁--
     */
    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById(20l);
        user.setAge(122);
        //user.setUpdateTime(new Date());
        int i = userMapper.updateById(user);
    }
    /**
    *@Description:多个id的批量查询
    */
    @Test
    public void queryUser(){
         List <User> users = userMapper.selectBatchIds(Arrays.asList(1l,2l,3l));
         System.out.println(users);
    }
    /**
    *@Description:根据条件查询---满足该条件才会输出
    */
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age",28);
        List<User> users = userMapper.selectByMap(map);
        System.out.println("********");
        users.forEach(System.out::println);
        System.out.println("********");
    }
    /**
    *@Description:根据条件进行分页查询
    */
    @Test
    public void testSelectPage(){
        //1创建page对象
        //传入2个参数：当前页 和 每页显示记录数
        Page <User> page = new Page<>(1,3);
        //调用mp分页查询的方法
        //调用mp分页查询的过程中  底层是封装
        //把分页所有数据封装到page对象里面
        userMapper.selectPage(page,null);

        //通过page对象获取分页数据
        System.out.println(page.getCurrent());    //当前页
        System.out.println(page.getRecords());   //每页数据的list集合
        System.out.println(page.getSize());   //没页显示记录数
        System.out.println(page.getTotal()); // 总页数
        System.out.println(page.hasNext());  //是否有下一页
        System.out.println(page.hasPrevious());  //是否有上一页
    }

    /**
    *@Description:物理删除
    */
    @Test
    public void testDeleteById(){
        userMapper.deleteById(22l);
    }
    /**
    *@Description:物理删除之批量删除
    */
    @Test
    public void testDeleteById1(){
      userMapper.deleteBatchIds(Arrays.asList(9l,10l,11l,12l));
    }
    /**
    *@Description:MP实现复杂操作
    */
    @Test
    public void testSelectQuery(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //ge gt le lt  》 > 《 <
        //查询age>30
       // userQueryWrapper.ge("age",30);

        //eq ne   == !=
//        userQueryWrapper.eq("name","Tom");
//        userQueryWrapper.ne("name","Jack");

        //like
        userQueryWrapper.like("name","J");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }

    }
}
