/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugiraportti.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Joonas
 */
public interface BugDao <T, K>{
    

    void create(T object) throws SQLException;

    T read(K key) throws SQLException;

    T update(T object) throws SQLException;

    void delete(K key) throws SQLException;

    List<T> list() throws SQLException;
    

}
