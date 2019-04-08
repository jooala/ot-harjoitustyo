package bugiraportti.controller;

import bugiraportti.Main;
import bugiraportti.domain.UserService;
import bugiraportti.ui.FxmlView;
import bugiraportti.ui.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MainSceneController implements Initializable {

    private final StageManager stageManager;

    @Autowired
    @Lazy
    public MainSceneController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @Autowired
    private UserService userService;
    private Main application;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        userService.logout();
        stageManager.switchScene(FxmlView.LOGIN);
    }

    @FXML
    private void handleReportbug(ActionEvent event) {

    }

    @FXML
    private void handleListBugs(ActionEvent event) {

    }

    @FXML
    private void handleSolveBugs(ActionEvent event) {

    }
}
