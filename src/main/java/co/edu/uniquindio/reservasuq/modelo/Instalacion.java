package co.edu.uniquindio.reservasuq.modelo;


import co.edu.uniquindio.reservasuq.modelo.enums.TipoInstalacion;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Instalacion {

    private String ID;
    private String nombre;
    private int capacidad;
    private TipoInstalacion tipoInstalacion;
    private List<Horario> horarios;

}
