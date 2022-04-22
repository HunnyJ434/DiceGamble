module com.example.dicegame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.dicegame to javafx.fxml;
    exports com.example.dicegame;
}