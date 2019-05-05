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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class RegisterSceneController implements Initializable {

    private final StageManager stageManager;

    @Autowired
    @Lazy
    public RegisterSceneController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @Autowired
    private UserService userService;
    private Main application;

    @FXML
    private TextField name;
    @FXML
    private TextField username;
    @FXML
    private Label error;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleCreate(ActionEvent event) throws SQLException {
        String nameRegister = name.getText();
        String usernameRegister = username.getText();
        if (userService.register(nameRegister, usernameRegister) == true) {
            stageManager.switchScene(FxmlView.LOGIN);
        } else {
            error.setText("Already registered. Try again.");
        }
    }
}
