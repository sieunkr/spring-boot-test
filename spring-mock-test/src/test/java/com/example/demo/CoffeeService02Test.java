package com.example.demo;

import com.example.demo.core.Coffee;
import com.example.demo.core.CoffeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeService02Test {

    @Mock
    private CoffeeRepository coffeeRepository;

    //우유가 들어있는 커피, 300원 할인에 대한 검증
    @Test
    public void When_Get_Discount_IsMilk_Expect_Minus_300(){

        //given
        CoffeeService coffeeService = new CoffeeService(coffeeRepository);

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


    @Test
    public void When_Get_Discount_Expect_Minus_100() {

        //given
        CoffeeService coffeeService = new CoffeeService(coffeeRepository);

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

}