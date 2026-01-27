package com.mycompany.app;

import java.util.Random;
    
/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello github World!";

    public App() {}

    public static void main(String[] args) {
        Random rand = new Random();
        int randomInt = rand.nextInt(10);        
        
        System.out.println(MESSAGE+": "+randomInt);

        String password = "gehtdichnixan";
        System.out.println("User password: " + password); 
    }

    public String getMessage() {
        return MESSAGE;
    }
}
