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
    @Select("SELECT * FROM T_USER2 WHERE phone= #{phone}")
    User findUserByPhone(@Param("phone") String phone);

    @Insert("insert into t_user2 (name, password, phone) values" +
            "(#{name}, #{password}, #{phone})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

    @Insert("insert into t_user2(name, password, phone) values" +
            "(#{name, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{phone, jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into t_user2(name, password, phone) values" +
            "(#{name}, #{password}, #{phone})")
    int insertByUser(User user);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone")
    })
    @Select("Select id, name, password, phone from t_user2")
    List<User> findAll();
}
