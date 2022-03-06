package com.example.demo;

import com.example.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        System.out.println("test");
        System.out.println("master");
        System.out.println("test-test");
        System.out.println(userService.queryUserByName("admin"));
    }

}
