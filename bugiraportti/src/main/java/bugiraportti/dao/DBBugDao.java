package bugiraportti.dao;
import bugiraportti.domain.Bug;
import bugiraportti.domain.User;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DBBugDao implements BugDao<Bug, Integer>{

    private Bug bug;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void create(Bug bug) throws SQLException {
        jdbcTemplate.update("INSERT INTO Bug" + " (title, summary, priority, steps, expectedResult, actualResult)" + " VALUES (?, ?, ?, ?, ?, ?)", bug.getTitle(),
                bug.getSummary(), bug.getPriority(), bug.getSteps(), bug.getExpectedResult(), bug.getActualResult());
    }

    @Override
    public Bug read(Integer key) throws SQLException {
        Bug bug = jdbcTemplate.queryForObject("SELECT * FROM Bug WHERE id = ?",
                new BeanPropertyRowMapper<>(Bug.class), key);
        return bug;
    }

    @Override
    public Bug update(Bug bug) throws SQLException {
        jdbcTemplate.update("UPDATE Bug SET title = ?, summary = ?, priority = ?, steps = ?, expectedresult = ?, actualresult = ? WHERE id = ?", bug.getTitle(), bug.getSummary(), bug.getPriority(), bug.getSteps(), bug.getExpectedResult(), bug.getActualResult(),
               bug.getId());
        return bug;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        jdbcTemplate.update("DELETE FROM Bug WHERE id = ?", key);
    }

    @Override
    public List<Bug> list() throws SQLException {
        List<Bug> bugs = jdbcTemplate.query("SELECT * FROM Bug",
                (rs, rowNum) -> new Bug(rs.getInt("id"), rs.getString("title"), rs.getString("summary"), rs.getInt("priority"), rs.getString("steps"), rs.getString("expectedresult"), rs.getString("actualresult")));
        return bugs;
    }
    
}
