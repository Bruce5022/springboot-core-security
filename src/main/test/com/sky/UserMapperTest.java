package com.sky;


import com.sky.entity.Permission;
import com.sky.entity.User;
import com.sky.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testFindByUsername(){
        User user = userMapper.findByUsername("shizhanwei");
        System.out.println("user:"+user);

    }

    @Test
    public void testFindPermissionByUsername(){
        List<Permission> permissions = userMapper.findPermissionByUsername("shizhanwei");
        permissions.stream().forEach(System.out::println);

    }

    @Test
    public void testUpdatePassword(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername("bruce");
        String pwd = encoder.encode("123456");
        user.setPassword(pwd);
        userMapper.updatePassword(user);
    }
}
