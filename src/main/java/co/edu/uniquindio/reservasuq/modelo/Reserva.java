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
    private String horaReserva;

    public Reserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) {
        this.id = UUID.randomUUID().toString();
        this.idInstalacion = idInstalacion;
        this.cedulaPersona = cedulaPersona;
        this.diaReserva = diaReserva;
        this.horaReserva = String.valueOf(horaReserva);
    }


}
