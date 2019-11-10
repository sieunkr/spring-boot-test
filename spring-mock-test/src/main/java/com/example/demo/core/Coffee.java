package com.example.demo.core;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coffee {

    private String name;
    private int price;
    private boolean isMilk;
}