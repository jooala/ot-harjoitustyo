package bugiraportti.domain;

import bugiraportti.dao.DBUserDao;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Luokka toimii alustana kaikille toiminnoille, mitkä liittyvät käyttäjiin.
 */
@Repository
public class UserService {

    @Autowired
    private DBUserDao dao;
    private User loggedIn;

    /**
     * Luokka ei toimi ilman tyhjää konstruktoria.
     */
    public UserService() {
    }

    /**
     * Etsii annetun käyttäjänimen perusteella löytyykö tietokannasta samaista
     * käyttäjänimeä, ja asettaa käyttäjän kirjautuneeksi sekä palauttaa arvon true.
     */
    public boolean login(String username) throws SQLException {
        User user = dao.findByUsername(username);
        if (user == null) {
            return false;
        }

        loggedIn = user;

        return true;
    }

    /**
     * Asettaa käyttäjän kirjautuneeksi ulos.
     */
    public void logout() {
        loggedIn = null;
    }

    /**
     * Palauttaa tällä hetkellä olevan kirjautuneen käyttäjän.
     */
    public User getLoggedUser() {
        return loggedIn;
    }

    /**
     * Tallentaa tietokantaan uuden käyttäjän, mikäli samannimistä käyttäjää ei
     * tietokannassa vielä ole.
     */
    public boolean register(String name, String username) throws SQLException {
        User user = new User(name, username);
        if (dao.findUserIfExists(username) == true) {
            dao.create(user);
            return true;
        } else {
            return false;
        }
    }
}
