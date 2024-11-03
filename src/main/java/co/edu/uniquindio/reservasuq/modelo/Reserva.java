package co.edu.uniquindio.reservasuq.modelo;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Reserva {

    private String idInstalacion;
    private String cedulaPersona;
    private LocalDate diaReserva;
    private String horaReserva;

}
