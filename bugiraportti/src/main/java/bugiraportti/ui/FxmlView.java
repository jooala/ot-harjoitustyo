package bugiraportti.ui;

import java.util.ResourceBundle;

public enum FxmlView {

    REGISTER {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("register.title");
        }

        @Override
        String getFxmlFile() {
            return "/fxml/RegisterScene.fxml";
        }
    },
    LOGIN {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        String getFxmlFile() {
            return "/fxml/LoginScene.fxml";
        }
    },
    MAIN {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("main.title");
        }

        @Override
        String getFxmlFile() {
            return "/fxml/MainScene.fxml";
        }
    };
    abstract String getTitle();

    abstract String getFxmlFile();

    String getStringFromResourceBundle(String key) {
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
