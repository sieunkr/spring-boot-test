package com.example.demo;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CoffeeServiceUnitTest {

    @Test
    public void 커피이름으로_조회_잘되는지() {

        // setup
        CoffeeRepository repo = Mockito.mock(CoffeeRepository.class);
        Mockito.when(repo.findByName("mocha"))
                .thenReturn(new Coffee("mocha"));
        CoffeeService coffeeService = new CoffeeService(repo);

        // when
        Coffee actualCoffee  =  coffeeService.findByName("mocha");

        // then
        assertEquals("mocha", actualCoffee.getName());
    }
}

