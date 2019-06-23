package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    /*
    @Autowired
    private CoffeeRepository coffeeRepository;
    */

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }



    public Coffee findByName(String name){
        return coffeeRepository.findByName(name);
    }
}
