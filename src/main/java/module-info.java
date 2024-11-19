module com.example.dsiinterfaceemjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsiinterfaceemjavafx to javafx.fxml;
    exports com.example.dsiinterfaceemjavafx;
}