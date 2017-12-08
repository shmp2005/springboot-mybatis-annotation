package com.zhongba.springboot;

import com.zhongba.springboot.domain.User;
import com.zhongba.springboot.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisAnnotationApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        String phone = "1234567892";
        String name = System.currentTimeMillis() + "";
        userMapper.insert(name, "1234567890", phone);
        User user = userMapper.findUserByPhone(phone);
        Assert.assertEquals(name, user.getName());
    }

    @Test
//    @Transactional
    public void testTxInsert() {
        userMapper.insert("张三", "1234567890", "18600000000");
        userMapper.insert("李四", "1234556", "13500000000");
        User user = userMapper.findUserByPhone("18600000000");
        Assert.assertEquals("张三", user.getName());
    }
}
