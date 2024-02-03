module com.example.prodigy_sd_01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prodigy_sd_01 to javafx.fxml;
    exports com.example.prodigy_sd_01;
}