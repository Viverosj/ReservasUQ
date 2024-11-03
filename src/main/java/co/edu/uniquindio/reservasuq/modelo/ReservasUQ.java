package co.edu.uniquindio.reservasuq.modelo;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoInstalacion;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import co.edu.uniquindio.reservasuq.servicio.ServiciosReservasUQ;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ReservasUQ implements ServiciosReservasUQ {

    private List<Persona> personas;
    private List<Instalacion> instalaciones;
    private List<Reserva> reservas;

    @Override
    public Persona login(String correo, String password) throws Exception {
        if (correo == null || correo.isEmpty() || password == null || password.isEmpty()) {
            throw new Exception("Correo y contraseña no pueden estar vacíos.");
        }

        for (Persona persona : personas) {
            if (persona.getCorreo().equals(correo) && persona.getPassword().equals(password)) {
                return persona;
            }
        }
        throw new Exception("Correo o contraseña incorrectos.");
    }

    @Override
    public void registrarPersona(String cedula, String nombre, TipoPersona tipoPersona,String correo, String password) throws Exception {
        String mensajesValidacion = "";

        if(cedula == null || cedula.isEmpty()){
            mensajesValidacion += "Debe ingresar la cedula\n";
        }

        if(nombre == null || nombre.isEmpty()){
            mensajesValidacion += "Debe ingresar el nombre\n";
        }

        if(correo == null || correo.isEmpty()){
            mensajesValidacion += "Debe ingresar el correo\n";
        }

        if (tipoPersona == null) {
            mensajesValidacion += "Debe seleccionar un tipo de persona\n";
        }

        if(!mensajesValidacion.isEmpty()){
            throw new Exception(mensajesValidacion);
        }

        if(obtenerPersona(cedula)!=null){
            throw new Exception("Ya existe un paciente con la identificación ingresada");
        }


        Persona persona = Persona.builder()
                .tipoPersona(tipoPersona)
                .cedula(cedula)
                .nombre(nombre)
                .correo(correo)
                .build();

        personas.add(persona);
    }
    @Override
    public Persona obtenerPersona(String cedula) {
        for (Persona paciente: personas) {
            if(paciente.getCedula().equals(cedula)){
                return paciente;
            }
        }
        return null;
    }

    @Override
    public void crearInstalacion(String nombre, int aforo, TipoInstalacion tipoInstalacion, List<Horario> horarios) throws Exception {
        String mensajesValidacion = "";

        // Validar los parámetros de entrada
        if (nombre == null || nombre.isEmpty()) {
            mensajesValidacion += "El nombre de la instalación no puede estar vacío.\n";
        }

        if (aforo <= 0) {
            mensajesValidacion += "La capacidad debe ser un número positivo.\n";
        }

        if (horarios == null || horarios.isEmpty()) {
            mensajesValidacion += "La lista de horarios no puede estar vacía.\n";
        }

        // Lanzar excepción si hay errores de validación
        if (!mensajesValidacion.isEmpty()) {
            throw new Exception(mensajesValidacion);
        }

        // Crear la nueva instalación
        Instalacion nuevaInstalacion = new Instalacion(nombre, aforo, tipoInstalacion, horarios);

        // Agregar la nueva instalación a la lista de instalaciones
        instalaciones.add(nuevaInstalacion);
    }


    @Override
    public Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception {
        return null;
    }
    @Override
    public List<Reserva> listarTodasReservas() {
        return reservas;
    }
    @Override
    public List<Reserva> listarReservasPorPersona(String cedulaPersona) {
        List<Reserva> reservasPersona = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getPersona().getCedula().equals(cedulaPersona)) {
                reservasPersona.add(reserva);
            }
        }
        return reservasPersona;
    }
}
