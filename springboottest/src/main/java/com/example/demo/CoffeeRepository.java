package com.example.demo;

public interface CoffeeRepository {
    Coffee findByName(String name);
    void add(Coffee coffee);
}
