package com.example.demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeServiceUnit2Test {

    private SimpleCoffeeRepository simpleCoffeeRepository;

    private CoffeeService coffeeService;

    @Before
    public void setUp(){
        simpleCoffeeRepository = new SimpleCoffeeRepository();
        simpleCoffeeRepository.add(new Coffee("mocha"));
        coffeeService = new CoffeeService(simpleCoffeeRepository);
    }

    @Test
    public void 커피이름으로_조회_잘되는지() {
        Coffee coffee = coffeeService.findByName("mocha");
        assertEquals("mocha", coffee.getName());
    }
}

