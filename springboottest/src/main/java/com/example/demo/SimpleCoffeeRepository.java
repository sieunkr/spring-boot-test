package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SimpleCoffeeRepository implements CoffeeRepository {

    private Map<String, Coffee> coffeeMap = new HashMap<>();

    @Override
    public Coffee findByName(String name) {
        return coffeeMap.get(name);
    }

    @Override
    public void add(Coffee coffee) {
        coffeeMap.put(coffee.getName(), coffee);
    }


    @PostConstruct
    public void setUp(){
        coffeeMap.put("mocha", new Coffee("mocha"));
        coffeeMap.put("latte", new Coffee("latte"));
    }

}

