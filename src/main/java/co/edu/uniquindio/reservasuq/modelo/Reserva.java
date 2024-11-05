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
    private String correoPersona;
    private LocalDate diaReserva;
    private String horaInicio;
    private String horaFin;

    public Reserva(String idInstalacion, String correoPersona, LocalDate diaReserva, LocalTime horaInicio, LocalTime horaFin) {
        this.id = UUID.randomUUID().toString();
        this.idInstalacion = idInstalacion;
        this.correoPersona = correoPersona;
        this.diaReserva = diaReserva;
        this.horaInicio = String.valueOf(horaInicio);
        this.horaFin = String.valueOf(horaFin);
    }


}
