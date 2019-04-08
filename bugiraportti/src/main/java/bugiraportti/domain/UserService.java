package bugiraportti.domain;

import bugiraportti.dao.DBUserDao;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {

    @Autowired
    private DBUserDao dao;
    private User loggedIn;

    public UserService() {
    }

    public boolean login(String username) throws SQLException {
        User user = dao.findByUsername(username);
        if (user == null) {
            return false;
        }

        loggedIn = user;

        return true;
    }

    public void logout() {
        loggedIn = null;
    }

    public User getLoggedUser() {
        return loggedIn;
    }

    public void register(String name, String username) throws SQLException {
        User user = new User(name, username);
        if (dao.findUserIfExists(username) == true) {
            dao.create(user);
        }
    }
}
