package co.edu.uniquindio.reservasuq.modelo;

import co.edu.uniquindio.reservasuq.modelo.enums.TipoInstalacion;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Instalacion {

    private String nombre;
    private int aforo;
    private double costo;
    private List<Horario> horarios;
    private TipoInstalacion tipoInstalacion;

}
