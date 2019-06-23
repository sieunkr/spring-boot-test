package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CoffeeController.class)
public class CoffeeControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getCoffee() {

        System.out.println("테스트");
    }
}