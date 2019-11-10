package com.example.demo.core;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class BrunchRepository {

    @PostConstruct
    public void init(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
