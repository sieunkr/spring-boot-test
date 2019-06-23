package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {

    @Autowired
    private CoffeeService coffeeService;

    @Test
    public void 커피이름으로_조회_잘되는지(){

        Coffee coffee = coffeeService.findByName("mocha");
        assertEquals("mocha", coffee.getName());
    }
}


