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
public class Horario {

    private LocalTime horaInicio; // Hora en la que empieza el horario (ej. 10:00)
    private LocalTime horaFin;    // Hora en la que termina el horario (ej. 11:00)

    // Constructor
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

    // Método para verificar si un horario se solapa con otro
    public boolean coincideCon(Horario otroHorario) {
        return (horaInicio.isBefore(otroHorario.horaFin) && horaFin.isAfter(otroHorario.horaInicio));
    }

    // Métodos equals y hashCode para comparación en colecciones
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario horario = (Horario) o;
        return horaInicio.equals(horario.horaInicio) && horaFin.equals(horario.horaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horaInicio, horaFin);
    }
}