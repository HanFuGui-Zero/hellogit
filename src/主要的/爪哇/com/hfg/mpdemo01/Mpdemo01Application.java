package com.hfg.mpdemo01;

import com.hfg.entiy.User;
import com.hfg.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
*@Description:springboot的启动类
*/
@SpringBootApplication
/**
 *@Description:@MapperSacn表示扫描到那个接口
 */
@Repository
@MapperScan("com.hfg.mapper")
@ComponentScan("com.hfg")
public class Mpdemo01Application {
   private UserMapper userMapper;
    public static void main(String[] args) {
       // SpringApplication.run(Mpdemo01Application.class, args);
        System.out.println("2");
        System.out.println("创建分支");
        System.out.println("分支添加");
        System.out.println("在线更新");
    }
}

