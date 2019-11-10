package com.example.demo;

import com.example.demo.core.Coffee;
import com.example.demo.core.CoffeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeService01Test {

    @Mock
    private CoffeeRepository coffeeRepository;

    @InjectMocks
    private CoffeeService coffeeService;

    @Test
    public void When_Get_Discount_Expect_Minus_100(){

        //given
        String name = "americano";
        int defaultPrice = 1000;
        int expectedPrice = 900;
        when(coffeeRepository.findOne(name))
                .thenReturn(Coffee.builder().name(name).isMilk(false).price(defaultPrice).build());

        //when
        int actualPrice = coffeeService.getDiscountedPrice(name);

        //Then
        assertEquals(expectedPrice, actualPrice);

    }


    @Test
    public void When_Get_Discount_IsMilk_Expect_Minus_300(){

        //given
        String name = "latte";
        int defaultPrice = 1400;
        int expectedPrice = 1100;
        when(coffeeRepository.findOne(name))
                .thenReturn(Coffee.builder().name(name).isMilk(true).price(defaultPrice).build());

        //when
        int actualPrice = coffeeService.getDiscountedPrice(name);

        //Then
        assertEquals(expectedPrice, actualPrice);

    }
}