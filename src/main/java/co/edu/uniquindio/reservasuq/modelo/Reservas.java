package co.edu.uniquindio.reservasuq.modelo;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Reservas {

    private String ID;
    private LocalDateTime fechaReserva;
    private Usuarios usuarios;
    private Instalaciones instalaciones;
    private double costo;
}
