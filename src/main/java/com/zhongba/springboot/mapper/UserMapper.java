package com.zhongba.springboot.mapper;

import com.zhongba.springboot.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @uthor: tangjianhua
 * @ate: 2017/12/8.
 */
@Service
@Mapper
public interface UserMapper {
    @Select("SELECT count(1) FROM users ")
    int count();

    @Select("Select id, name, email from users where id = #{id}")
    User getUser(@Param("id") long id);
}
