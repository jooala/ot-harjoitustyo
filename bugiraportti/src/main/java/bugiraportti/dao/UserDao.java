package bugiraportti.dao;

import java.sql.*;
import java.util.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import bugiraportti.domain.User;
import bugiraportti.domain.User;

/**
 * Luokka toimii alustana DBUserDaon metodeille.
 */
public interface UserDao<T, K> {
    void create(T object) throws SQLException;

    T read(K key) throws SQLException;

    T update(T object) throws SQLException;

    void delete(K key) throws SQLException;

    List<T> list() throws SQLException;

    User findByUsername(String username) throws SQLException;

    boolean findUserIfExists(String username) throws SQLException;
}