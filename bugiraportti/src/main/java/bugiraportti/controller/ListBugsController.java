package bugiraportti.controller;

import bugiraportti.Main;
import bugiraportti.domain.Bug;
import bugiraportti.domain.BugService;
import bugiraportti.ui.FxmlView;
import bugiraportti.ui.StageManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ListBugsController {

    private final StageManager stageManager;
    @Autowired
    private BugService bugService;
    private Main application;

    @FXML
    private ListView list;

    @Autowired
    @Lazy
    public ListBugsController(StageManager stageManager) throws SQLException {
        this.stageManager = stageManager;

    }

    @FXML
    private void handleList(ActionEvent event) throws SQLException {
        ObservableList<Bug> items = bugService.listBugs();
        List<String> strings = new ArrayList();
        for (Bug bug : items) {
            strings.add(bug.getId() + ": " + bug.getTitle() + ", " + bug.getSummary() + ", " + bug.getPriority() + ", " + bug.getSolved());
        }
        ObservableList<String> text = FXCollections.observableArrayList(strings);
        list.setItems(text);
    }

    @FXML
    private void handleBack(ActionEvent event) {
        stageManager.switchScene(FxmlView.MAIN);
    }
}
