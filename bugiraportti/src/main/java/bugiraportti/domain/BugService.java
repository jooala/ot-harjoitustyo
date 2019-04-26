package bugiraportti.domain;

import bugiraportti.dao.DBBugDao;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Luokka toimii alustana kaikille toiminnoille, mitkä liittyvät bugeihin
 * sovelluksessa.
 */
@Repository
public class BugService {

    @Autowired
    private DBBugDao dao;
    private User loggedIn;

    /**
     * Luokka ei toimi ilman tyhjää konstruktoria.
     */
    public BugService() {
    }

    /**
     * Tallentaa bugin tietokantaan annetuilla tiedoilla.
     */
    public void reportBug(String title, String summary, int priority, String steps, String expectedResult,
            String actualResult) throws SQLException {
        Bug bug = new Bug(title, summary, priority, steps, expectedResult, actualResult, false);
        dao.create(bug);
    }

    /**
     * Palauttaa listan, mitä pystyy käyttämään JavaFX ListView:ssä.
     */
    public ObservableList<Bug> listBugs() throws SQLException {
        ObservableList<Bug> items = FXCollections.observableArrayList(dao.list());
        return items;
    }

    /**
     * Palauttaa listan, missä listan alkupäässä on korkeimmat bugit
     * prioriteetiltaan tietokannassa.
     */
    public List<Bug> priorityBug() throws SQLException {
        List<Bug> bugs = dao.findPriority();
        return bugs;
    }

    /**
     * Palauttaa listan, missä listan alkupäässä ovat vanhimmat bugit tietokannassa.
     */
    public List<Bug> oldBug() throws SQLException {
        List<Bug> bugs = dao.findOld();
        return bugs;
    }

    /**
     * Palauttaa haetun bugin sen annetulla id-arvolla.
     */
    public Bug findBug(int value) throws SQLException {
        Bug bug = dao.read(value);
        return bug;
    }

    /**
     * Tallentaa Bugin boolean-tilan tietokannassa sen id-arvon avulla.
     */
    public void save(int idS, boolean solvedS) {
        dao.updateSolved(idS, solvedS);
    }
}
