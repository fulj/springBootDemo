package com.example.demo;

import com.example.demo.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

}
