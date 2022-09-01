module shape.fala.pormim {
    requires javafx.controls;
    requires javafx.fxml;

    opens shape.fala.pormim to javafx.fxml;
    exports shape.fala.pormim;
}
