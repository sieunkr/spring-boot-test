package com.example.demo;

import com.example.demo.core.Coffee;
import com.example.demo.core.CoffeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeService04Test {

    @Autowired
    private CoffeeService coffeeService;

    @MockBean
    private CoffeeRepository coffeeRepository;

    @Test
    public void When_Get_Discount_Expect_Minus_100() {

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
    public void When_Get_Discount_IsMilk_Expect_Minus_300() {

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