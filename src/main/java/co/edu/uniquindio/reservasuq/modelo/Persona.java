package co.edu.uniquindio.reservasuq.modelo;

import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Persona {

    private String cedula;
    private String nombre;
    private String correo;
    private TipoPersona tipoPersona;
    private String password;

}
