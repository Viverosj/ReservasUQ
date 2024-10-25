module co.edu.uniquindio.reservasuq {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens co.edu.uniquindio.reservasuq to javafx.fxml;
    exports co.edu.uniquindio.reservasuq;
}