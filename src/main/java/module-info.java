@SuppressWarnings("JavaModuleNaming")
module org.example.csd420 {
    requires javafx.graphics;
    requires javafx.controls;

    opens org.example.csd420 to javafx.fxml;
    exports org.example.csd420;
    exports org.example.csd420.module01;
    opens org.example.csd420.module01 to javafx.fxml;
}