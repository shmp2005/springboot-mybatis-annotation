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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testInsertMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "糖豆");
        map.put("password", 30);
        map.put("phone", "12345678903");
        userMapper.insertByMap(map);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setName("中巴2");
        user.setPassword("asfas asfas ");
        user.setPhone("098764");
        userMapper.insertByUser(user);
    }

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
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
