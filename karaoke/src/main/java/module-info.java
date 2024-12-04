module com.example.karaoke {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.karaoke to javafx.fxml;
    exports com.karaoke;
}
