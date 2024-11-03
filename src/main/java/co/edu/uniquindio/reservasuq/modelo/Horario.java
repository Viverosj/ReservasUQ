package co.edu.uniquindio.reservasuq.modelo;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Horario {

    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

}