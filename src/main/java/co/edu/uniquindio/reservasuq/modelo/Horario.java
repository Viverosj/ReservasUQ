package co.edu.uniquindio.reservasuq.modelo;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;


@AllArgsConstructor
@Getter
@Setter
public class Horario {

    private LocalTime horaInicio;
    private LocalTime horaFin;


}