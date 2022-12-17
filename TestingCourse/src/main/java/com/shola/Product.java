package com.shola;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    String brandName;
    String model;
    Integer id;
    Double price;
    String category;

    double increasePrice(Double increment) throws InterruptedException {
        price += increment;
        double newprice  = price + increment;
        Thread.sleep(2000);
        return newprice;
    }
}
