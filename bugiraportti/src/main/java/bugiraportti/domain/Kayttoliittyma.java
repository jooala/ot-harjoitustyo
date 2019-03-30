/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugiraportti.domain;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import bugiraportti.domain.User;

@Component
public class Kayttoliittyma {
   
    @Autowired
    private UserService dao;

    public void init() throws Exception {
    }
    
    public void start(Scanner lukija) throws SQLException {
         kirjautuminen(lukija);
        
    }

    private void kirjautuminen(Scanner lukija) throws SQLException {
        while (true) {
        System.out.println("Kirjaudu sisään");
        String userLogin = lukija.nextLine();
        dao.login(userLogin);
            if (dao.login(userLogin) == true) {
                System.out.println("Kirjauduit sisälle");
                break;
            } else {
                System.out.println("Väärä käyttäjänimi.");
            }
        }
    }
}
    

