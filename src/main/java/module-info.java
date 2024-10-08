@SuppressWarnings("JavaModuleNaming")
module org.example.csd420 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;
    requires java.sql;
    requires mysql.connector.j;

    opens org.example.csd420 to javafx.fxml;
    exports org.example.csd420;
    exports org.example.csd420.Module01;
    exports org.example.csd420.Module07 to javafx.graphics;
    exports org.example.csd420.Module10 to javafx.graphics;
    opens org.example.csd420.Module01 to javafx.fxml;
    opens org.example.csd420.Module10 to javafx.fxml;
}