package com.example.demo;

import com.example.demo.core.Coffee;
import com.example.demo.core.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private static int DISCOUNT_AMOUNT = 100;
    private static int DISCOUNT_AMOUNT_WITH_MILK = 300;


    public int getDiscountedPrice(String name) {

        Assert.notNull(name, "name must not be null");

        Coffee coffee = coffeeRepository.findOne(name);

        if (coffee.isMilk()) {
            return coffee.getPrice() - DISCOUNT_AMOUNT_WITH_MILK;
        } else {
            return coffee.getPrice() - DISCOUNT_AMOUNT;
        }
    }
}