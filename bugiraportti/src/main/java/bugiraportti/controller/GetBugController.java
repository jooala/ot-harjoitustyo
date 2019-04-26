package bugiraportti.controller;

import bugiraportti.Main;
import bugiraportti.domain.Bug;
import bugiraportti.domain.BugService;
import bugiraportti.ui.FxmlView;
import bugiraportti.ui.StageManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Luokka toimii controllerina JavaFX-tapahtumille GetBugScene-näkymässä.
 */
@Component
public class GetBugController implements Initializable {

    private final StageManager stageManager;

    /**
     * Asettaa StageManagerin Controlleriin.
     */
    @Autowired
    @Lazy
    public GetBugController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @Autowired
    private BugService bugService;
    private Main application;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label id;
    @FXML
    private Label title;
    @FXML
    private Label priority;
    @FXML
    private ScrollPane summary;
    @FXML
    private ScrollPane steps;
    @FXML
    private ScrollPane expected;
    @FXML
    private ScrollPane actual;
    @FXML
    private Label summaryText;
    @FXML
    private Label stepsText;
    @FXML
    private Label expectedText;
    @FXML
    private Label actualText;
    @FXML
    private CheckBox solved;

    /**
     * Palauttaa näkymän takaisin MainSceneen.
     */
    @FXML
    private void handleBack(ActionEvent event) throws SQLException, InterruptedException {
        stageManager.switchScene(FxmlView.MAIN);
    }

    /**
     * Hakee listan prioriteetiltään suurimmat listan alussa, ja asettaa JavaFX
     * tekstikenttiin ensimmäisenä olevan bugin listassa olevat tiedot.
     */
    @FXML
    private void handleBugPriority(ActionEvent event) throws SQLException, InterruptedException {
        List<Bug> bugs = bugService.priorityBug();
        if (bugs.isEmpty()) {
            title.setText("No bugs found");
        } else {
            Bug bug = bugs.get(0);
            id.setText("" + bug.getId());
            title.setText(bug.getTitle());
            priority.setText("" + bug.getPriority());
            summaryText.setText(bug.getSummary());
            stepsText.setText(bug.getSteps());
            expectedText.setText(bug.getExpectedResult());
            actualText.setText(bug.getActualResult());
        }
    }

    /**
     * Hakee listan vanhimmista lisätyistä bugeista listan alussa, ja asettaa JavaFX
     * tekstikenttiin ensimmäisenä olevan bugin listassa olevat tiedot.
     */
    @FXML
    private void handleOld(ActionEvent event) throws SQLException, InterruptedException {
        List<Bug> bugs = bugService.oldBug();
        if (bugs.isEmpty()) {
            title.setText("No bugs found");
        } else {
            Bug bug = bugs.get(0);
            id.setText("" + bug.getId());
            title.setText(bug.getTitle());
            priority.setText("" + bug.getPriority());
            summaryText.setText(bug.getSummary());
            stepsText.setText(bug.getSteps());
            expectedText.setText(bug.getExpectedResult());
            actualText.setText(bug.getActualResult());
        }
    }

    /**
     * Ottaa JavaFX-näkymässä olevan bugin id:n talteen ja tallentaa CheckBoxin
     * mukaan bugin solved-booleanin arvon tietokantaan.
     */
    @FXML
    private void handleSave(ActionEvent event) throws SQLException, InterruptedException {
        int idS = Integer.parseInt(id.getText());
        boolean solvedS = false;
        if (idS != 0) {
            solvedS = solved.isSelected();
            bugService.save(idS, solvedS);
            id.setText("");
        } else {
            title.setText("Virhe. Et voi tallentaa.");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
