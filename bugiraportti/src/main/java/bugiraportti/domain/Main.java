/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugiraportti.domain;

/**
 *
 * @author Joonas
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    
    @Autowired
    Kayttoliittyma ui;
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Override
    public void run(String... args) throws Exception {
        //alustaTietokanta();
        Scanner lukija = new Scanner(System.in);
        ui.start(lukija);
    }
    private static void alustaTietokanta() {
        // mikäli poistat vahingossa tietokannan voit ajaa tämän metodin jolloin 
        // tietokantataulu luodaan uudestaan

        try (Connection conn = DriverManager.getConnection("jdbc:h2:./bugreport", "sa", "")) {
            conn.prepareStatement("DROP TABLE User IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE User (\n"
                    + "    id INTEGER AUTO_INCREMENT PRIMARY KEY,\n"
                    + "    name VARCHAR(255),\n"
                    + "    username VARCHAR(255),\n"     
                    + ");").executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

