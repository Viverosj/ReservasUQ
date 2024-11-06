package co.edu.uniquindio.reservasuq.modelo;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Instalacion {

    private String Id;
    private String nombre;
    private int aforo;
    private double costo;
    private List<Horario> horarios;

}
