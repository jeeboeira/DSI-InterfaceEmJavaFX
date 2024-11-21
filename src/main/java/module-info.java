module com.dsiinterfaceemjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dsiinterfaceemjavafx.view to javafx.fxml;
    exports com.dsiinterfaceemjavafx.view;
    exports com.dsiinterfaceemjavafx;
}
