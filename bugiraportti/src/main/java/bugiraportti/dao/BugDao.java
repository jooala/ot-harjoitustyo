package bugiraportti.dao;

import bugiraportti.domain.Bug;
import java.sql.SQLException;
import java.util.List;

/**
 * Luokka toimii alustana DBBugDaon metodeille.
 */
public interface BugDao<T, K> {

    void create(T object) throws SQLException;

    T read(K key) throws SQLException;

    T update(T object) throws SQLException;

    void delete(K key) throws SQLException;

    List<T> list() throws SQLException;

    List<Bug> findPriority() throws SQLException;

    List<Bug> findOld() throws SQLException;

    void updateSolved(int k, boolean b) throws SQLException;
}
