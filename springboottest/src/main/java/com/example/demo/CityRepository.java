package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class CityRepository {

    public CityRepository(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
