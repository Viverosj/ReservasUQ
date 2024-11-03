package co.edu.uniquindio.reservasuq.modelo;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Reserva {

    private String ID;
    private LocalDateTime fechaReserva;
    private Persona usuarios;
    private Instalacion instalaciones;
    private double costo;
}
