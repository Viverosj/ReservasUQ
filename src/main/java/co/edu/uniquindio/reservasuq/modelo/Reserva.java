package co.edu.uniquindio.reservasuq.modelo;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Reserva {

    private String id;
    private String idInstalacion;
    private String cedulaPersona;
    private LocalDate diaReserva;
    private String horaInicio;
    private String horaFin;

    public Reserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, LocalTime horaInicio, LocalTime horaFin) {
        this.id = UUID.randomUUID().toString();
        this.idInstalacion = idInstalacion;
        this.cedulaPersona = cedulaPersona;
        this.diaReserva = diaReserva;
        this.horaInicio = String.valueOf(horaInicio);
        this.horaFin = String.valueOf(horaFin);
    }


}
