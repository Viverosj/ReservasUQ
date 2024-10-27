package co.edu.uniquindio.reservasuq.modelo;

import co.edu.uniquindio.reservasuq.modelo.enums.TipoUsuario;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Usuarios {

    private String cedula;
    private String nombre;
    private String correo;
    private TipoUsuario tipoUsuario;
    private String password;

}
