package com.hfg.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hfg.entiy.User;
import org.springframework.stereotype.Repository;

/**
 * Create with Intellij IDEA.
 * Description：
 * User:Zero
 * Date:2021/3/21
 * Time:19:41
 */
/**
*@Description:@Repository加注解表示把他的对象交给spring管理
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}
