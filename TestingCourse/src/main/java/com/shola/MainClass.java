package com.shola;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String [] args) throws InterruptedException {
        Product tv = new Product("LifeImage", "Alpha", 1111, 63.5, "Electronics");

        System.out.println(tv.increasePrice(20.0));
        System.err.println(tv.getPrice());

    }
}
