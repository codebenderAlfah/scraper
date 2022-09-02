package org.example;

public class Test {
    public static void main(String[] args) {
        int min = 50;
        int max = 500;
//Generate random double value from 200 to 400
//Generate random int value from 200 to 400
        System.out.println("Random value of type int between "+min+" to "+max+ ":");
        int b = (int)(Math.random()*(max-min+1)+min);
        System.out.println(b);
    }
}
