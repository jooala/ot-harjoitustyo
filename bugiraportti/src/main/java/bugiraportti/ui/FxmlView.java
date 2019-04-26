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
    },
    ADDBUG {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("addbug.title");
        }

        @Override
        String getFxmlFile() {
            return "/fxml/AddBugScene.fxml";
        }
    },
    LISTBUGS {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("listbugs.title");
        }

        @Override
        String getFxmlFile() {
            return "/fxml/ListBugsScene.fxml";
        }
    },
    GETBUG {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("getbug.title");
        }

        @Override
        String getFxmlFile() {
            return "/fxml/GetBugScene.fxml";
        }
    };
    abstract String getTitle();

    abstract String getFxmlFile();

    String getStringFromResourceBundle(String key) {
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
