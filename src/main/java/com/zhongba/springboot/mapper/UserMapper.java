package com.zhongba.springboot.mapper;

import com.zhongba.springboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

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
}
