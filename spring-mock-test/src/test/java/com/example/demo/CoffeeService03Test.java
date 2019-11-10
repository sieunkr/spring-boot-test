package com.example.demo;

import com.example.demo.core.Coffee;
import com.example.demo.core.CoffeeRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeService03Test {

    @Test
    public void When_Get_Discount_IsMilk_Expect_Minus_300() {

        CoffeeService coffeeService = new CoffeeService(new MockCoffeeRepository());

        //given
        String name = "latte";
        int expectedPrice = 1100;

        //when
        int actualPrice = coffeeService.getDiscountedPrice(name);

        //Then
        assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void When_Get_Discount_Expect_Minus_100() {

        CoffeeService coffeeService = new CoffeeService(new MockCoffeeRepository());

        //given
        String name = "americano";
        int expectedPrice = 900;

        //when
        int actualPrice = coffeeService.getDiscountedPrice(name);

        //Then
        assertEquals(expectedPrice, actualPrice);

    }


    public class MockCoffeeRepository extends CoffeeRepository {

        //TODO: 깔끔하지 않은 테스트 코드
        @Override
        public Coffee findOne(String name) {
            if (name.equals("latte")) {
                return Coffee.builder().name("latte").price(1400).isMilk(true).build();
            } else if (name.equals("americano")) {
                return Coffee.builder().name("americano").price(1000).isMilk(false).build();
            }
            return null;
        }
    }

}