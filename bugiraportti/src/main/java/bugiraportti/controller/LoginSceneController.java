package bugiraportti.controller;

import bugiraportti.Main;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import bugiraportti.domain.UserService;
import bugiraportti.ui.FxmlView;
import bugiraportti.ui.StageManager;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LoginSceneController implements Initializable {

    private final StageManager stageManager;

    @Autowired
    @Lazy
    public LoginSceneController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @Autowired
    private UserService userService;
    private Main application;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Label display;
    @FXML
    private Label display1;

    @FXML
    private void handleLogin(ActionEvent event) throws SQLException, InterruptedException {
        String username = user.getText();
        if (userService.login(username) == true) {
            stageManager.switchScene(FxmlView.MAIN);

        } else {
            display1.setText("Väärä käyttäjänimi");

        }
    }

    @FXML
    private void handleRegister(ActionEvent event) throws SQLException, IOException {
        stageManager.switchScene(FxmlView.REGISTER);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

}
