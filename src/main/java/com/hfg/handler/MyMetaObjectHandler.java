package com.hfg.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Create with Intellij IDEA.
 * Description：
 * User:Zero
 * Date:2021/3/21
 * Time:22:31
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
    *@Description:使用MP实现添加操作，这个方法就会执行
    */
    @Override
    public void insertFill(MetaObject metaObject) {

        System.out.println("insertFill执行了吗？？？");
        //metaObject.setValue("createTime",new Date());
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        //给version赋默认的值
        this.setFieldValByName("version",1,metaObject);
    }
    /**
    *@Description:使用MP实现更新操作，这个方法就会执行
    */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
