package co.edu.uniquindio.reservasuq.modelo;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Reserva {

    private String id; //codigo de reserva para el correo
    private Instalacion instalacion; // de los enum y de los que crea el administrador en reservasUQ
    private Persona persona; // obtiene la persona mediante su cedula
    private LocalDate diaReserva;
    private LocalTime horaReserva;
    private double costo;

}
