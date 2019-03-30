/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugiraportti.domain;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Joonas
 */
@Component
public class UserService {
    
    @Autowired
    private DBUserDao dao;
    private User loggedIn;
    
    public boolean login(String username) throws SQLException {
        User user = dao.findByUsername(username);
        if (user == null) {
            return false;
        }
        
        loggedIn = user;
        
        return true;
    }
}
