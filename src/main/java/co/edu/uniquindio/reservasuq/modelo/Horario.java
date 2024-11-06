package co.edu.uniquindio.reservasuq.modelo;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;


@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Horario {

    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(LocalTime horaInicio, LocalTime horaFin) {
        if (horaInicio == null || horaFin == null) {
            throw new IllegalArgumentException("Las horas de inicio y fin no pueden ser nulas.");
        }
        if (horaInicio.isAfter(horaFin) || horaInicio.equals(horaFin)) {
            throw new IllegalArgumentException("La hora de inicio debe ser anterior a la hora de fin.");
        }
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public boolean coincideCon(Horario otroHorario) {
        return (horaInicio.isBefore(otroHorario.horaFin) && horaFin.isAfter(otroHorario.horaInicio));
    }

}