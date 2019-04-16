package bugiraportti.domain;


import bugiraportti.dao.DBBugDao;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BugService {
    
    @Autowired
    private DBBugDao dao;
    private User loggedIn;
    
    public BugService() {
    }
    
    public void reportBug(String title, String summary, int priority, String steps, String expectedResult, String actualResult) throws SQLException {
        Bug bug = new Bug(title, summary, priority, steps, expectedResult, actualResult);
        dao.create(bug);
    }
    public ObservableList<Bug> listBugs() throws SQLException {
        ObservableList<Bug> items = FXCollections.observableArrayList(dao.list());
        return items;
    }
}
