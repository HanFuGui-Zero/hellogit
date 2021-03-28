package com.hfg.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Create with Intellij IDEA.
 * Description：
 * User:Zero
 * Date:2021/3/21
 * Time:19:36
 */
/**
*@Description:lombok插件在类上添加@Data注解__可以自动生成set()_get()方法_全部构造方法
*/
@Data
@Repository
public class User {
    /**
    *@Description:表示使用自动增长，不使用MP的自带的雪花算法
    */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;
    //逻辑删除  1表示逻辑删除
    @TableLogic
    private Integer deleted;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;  //版本号

    //自动填充
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
