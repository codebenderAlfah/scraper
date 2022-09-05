package org.example;


import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class bestBuy {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String des = faker.animal().name();
        System.out.println(des);


        }
}