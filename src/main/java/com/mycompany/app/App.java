package com.mycompany.app;

import java.util.Random;
import javax.crypto.Cipher;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final String MESSAGE = "Hello github World!";

    public App() {}

    public static void main(String[] args) {
        //should be detected as an insecure random - spotbugs can detect this
        Random rand = new Random();
        int randomInt = rand.nextInt(10);        
        log.info(MESSAGE+": "+randomInt);

        //should trigger data leakage
        String password = "gehtdichnixan";
        log.info("User password: " + password); 

        //should trigger null pointer
        try {
            String cmd = System.getProperty("cmd");
            int length = cmd.trim().length(); 
            log.info("Cmd: " + cmd.trim()); 
        }
        catch (Exception e) {log.error("Some error: ", e)}

        //should trigger unsecure cipher
        Cipher cipher = Cipher.getInstance("DES"); 

        // should trigger a GitHub Personal Access Token alert
        String githubToken = "ghp_n0tArEaLtOkEnThAtTrIgGeRsScAnNeR1234";
        log.info("Connecting with token: " + githubToken);        
    }

    public String getMessage() {
        return MESSAGE;
    }

    public void executeQuery(HttpServletRequest request, Connection conn) throws SQLException {
        // TRIGGER: Directly concatenating unsanitized 'id' parameter into SQL
        String id = request.getParameter("id");
        String query = "SELECT * FROM users WHERE id = " + id;
        
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
    }    
}
