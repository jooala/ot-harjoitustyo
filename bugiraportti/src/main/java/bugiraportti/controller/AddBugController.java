package bugiraportti.controller;

import bugiraportti.Main;
import bugiraportti.domain.BugService;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import bugiraportti.ui.FxmlView;
import bugiraportti.ui.StageManager;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AddBugController implements Initializable {

    private final StageManager stageManager;

    @Autowired
    @Lazy
    public AddBugController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @Autowired
    private BugService bugService;
    private Main application;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField title;
    @FXML
    private TextArea summary;
    @FXML
    private TextArea steps;
    @FXML
    private TextArea expectedResult;
    @FXML
    private TextArea actualResult;
    @FXML
    private Slider priority;

    @FXML
    private void handleBack(ActionEvent event) throws SQLException, InterruptedException {
        stageManager.switchScene(FxmlView.MAIN);
    }

    @FXML
    private void handleReportbug(ActionEvent event) throws SQLException, InterruptedException {
        String titleR = title.getText();
        String summaryR = summary.getText();
        String stepsR = steps.getText();
        int priorityR = (int) priority.getValue();
        String expectedResultR = expectedResult.getText();
        String actualResultR = actualResult.getText();
        bugService.reportBug(titleR, summaryR, priorityR, stepsR, expectedResultR, actualResultR);
        stageManager.switchScene(FxmlView.MAIN);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }
}
