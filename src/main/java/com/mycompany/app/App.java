package com.mycompany.app;

import java.util.Random;
import javax.crypto.Cipher;
    
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

        String cmd = System.getProperty("cmd");
        int length = cmd.trim().length(); 
        System.out.println("Cmd: " + cmd.trim()); 

        Cipher cipher = Cipher.getInstance("DES"); 
    }

    public String getMessage() {
        return MESSAGE;
    }
}
