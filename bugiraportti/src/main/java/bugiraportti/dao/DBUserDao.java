package bugiraportti.dao;

import bugiraportti.dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import bugiraportti.domain.User;
import bugiraportti.domain.User;
import java.util.*;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DBUserDao implements UserDao<User, Integer> {

    private User loggedIn;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void create(User user) throws SQLException {
        jdbcTemplate.update("INSERT INTO USER" + " (name, username)" + " VALUES (?, ?)", user.getName(),
                user.getUsername());
    }

    @Override
    public User read(Integer key) throws SQLException {
        User user = jdbcTemplate.queryForObject("SELECT * FROM User WHERE id = ?",
                new BeanPropertyRowMapper<>(User.class), key);
        return user;
    }

    @Override
    public User update(User user) throws SQLException {
        jdbcTemplate.update("UPDATE User SET name = ?, username = ? WHERE id = ?", user.getName(), user.getUsername(),
                user.getId());
        return user;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        jdbcTemplate.update("DELETE FROM User WHERE id = ?", key);
    }

    @Override
    public List<User> list() throws SQLException {
        List<User> users = jdbcTemplate.query("SELECT * FROM User",
            (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("name"), rs.getString("username")));
        return users;
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM User WHERE username = ?",
                    new BeanPropertyRowMapper<>(User.class), username);
            return user;

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public boolean findUserIfExists(String username) throws SQLException {
        List<User> users = jdbcTemplate.query("SELECT * FROM User WHERE username = ?",
            (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("name"), rs.getString("username")), username);
        if (users.isEmpty()) {
            return true;
        }
        return false;
    }
}
