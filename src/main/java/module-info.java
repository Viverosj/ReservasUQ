module co.edu.uniquindio.reservasuq {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires static lombok;
    requires org.simplejavamail.core;
    requires org.simplejavamail;


    opens co.edu.uniquindio.reservasuq to javafx.fxml;
    exports co.edu.uniquindio.reservasuq;
    exports co.edu.uniquindio.reservasuq.modelo;
    exports co.edu.uniquindio.reservasuq.controlador;
    opens co.edu.uniquindio.reservasuq.controlador to javafx.fxml;
    exports co.edu.uniquindio.reservasuq.modelo.enums;
}