package co.edu.uniquindio.reservasuq.modelo;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Horario {

    private String dia;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;

}