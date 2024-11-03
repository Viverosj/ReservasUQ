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

    private String ID; //se generará automáticamente
    private String nombre;
    private int aforo;
    private TipoInstalacion tipoInstalacion;
    private List<Horario> horarios;

    public Instalacion(String nombre, int aforo, TipoInstalacion tipoInstalacion, List<Horario> horarios) {
        this.ID = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.aforo = aforo;
        this.tipoInstalacion = tipoInstalacion;
        this.horarios = horarios;
    }


}
