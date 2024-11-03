package co.edu.uniquindio.reservasuq.modelo;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoInstalacion;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import co.edu.uniquindio.reservasuq.servicio.ServiciosReservasUQ;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
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
    public void crearInstalacion(String nombre, int aforo, double costo, List<Horario> horarios, TipoInstalacion tipoInstalacion) throws Exception {

        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("El nombre de la instalación no puede estar vacío.");
        }
        if (aforo <= 0) {
            throw new Exception("El aforo debe ser mayor a cero.");
        }
        if (costo < 0) {
            throw new Exception("El costo no puede ser negativo.");
        }
        if (horarios == null || horarios.isEmpty()) {
            throw new Exception("Debe especificar al menos un horario para la instalación.");
        }
        if (tipoInstalacion == null) {
            throw new Exception("Debe especificar el tipo de instalación.");
        }

        for (Instalacion instalacion : instalaciones) {
            if (instalacion.getNombre().equalsIgnoreCase(nombre)) {
                throw new Exception("Ya existe una instalación con ese nombre.");
            }
        }

        Instalacion nuevaInstalacion = Instalacion.builder()
                .nombre(nombre)
                .aforo(aforo)
                .costo(costo)
                .horarios(horarios)
                .tipoInstalacion(tipoInstalacion)
                .build();

        instalaciones.add(nuevaInstalacion);
    }

    @Override
    public Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception {

        if (idInstalacion == null || idInstalacion.isEmpty()) {
            throw new Exception("El ID de la instalación no puede estar vacío.");
        }
        if (cedulaPersona == null || cedulaPersona.isEmpty()) {
            throw new Exception("La cédula de la persona no puede estar vacía.");
        }
        if (diaReserva == null || diaReserva.isBefore(LocalDate.now().plusDays(2))) {
            throw new Exception("La reserva debe hacerse con al menos 2 días de anticipación.");
        }
        if (horaReserva == null || horaReserva.isEmpty()) {
            throw new Exception("La hora de la reserva no puede estar vacía.");
        }

        Instalacion instalacion = buscarInstalacionPorId(idInstalacion);
        if (instalacion == null) {
            throw new Exception("La instalación especificada no existe.");
        }

        Persona persona = obtenerPersona(cedulaPersona);
        if (persona == null) {
            throw new Exception("La persona especificada no existe.");
        }

        if (!verificarDisponibilidad(instalacion, diaReserva, horaReserva)) {
            throw new Exception("La instalación no está disponible en el horario solicitado.");
        }

        Reserva nuevaReserva = Reserva.builder()
                .idInstalacion(idInstalacion)
                .cedulaPersona(cedulaPersona)
                .diaReserva(diaReserva)
                .horaReserva(horaReserva)
                .build();

        reservas.add(nuevaReserva);

        return nuevaReserva;
    }

    @Override
    public Instalacion buscarInstalacionPorId(String idInstalacion) {
        for (Instalacion instalacion : instalaciones) {
            if (instalacion.getNombre().equalsIgnoreCase(idInstalacion)) {
                return instalacion;
            }
        }
        return null;
    }

    @Override
    public boolean verificarDisponibilidad(Instalacion instalacion, LocalDate diaReserva, String horaReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdInstalacion().equals(instalacion.getNombre()) &&
                    reserva.getDiaReserva().equals(diaReserva) &&
                    reserva.getHoraReserva().equals(horaReserva)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Reserva> listarTodasReservas() {
        return reservas;
    }

    @Override
    public List<Reserva> listarReservasPorPersona(String cedulaUsuario) {
        return null;
    }

    @Override
    public void actualizarDatosPersona(String cedula, String nombre, TipoPersona tipoPersona, String email, String password) throws Exception {

    }

    @Override
    public void eliminarPersona(String cedula) throws Exception {

    }

    @Override
    public List<Reserva> obtenerHistorialReservas(String cedulaPersona) {
        return null;
    }

    @Override
    public List<Horario> obtenerHorariosDisponibles(String idInstalacion, LocalDate diaReserva) {
        return null;
    }

    @Override
    public void cancelarReserva(String idReserva) throws Exception {

    }

    @Override
    public List<Reserva> listarReservasPorInstalacion(String idInstalacion) {
        return null;
    }

    @Override
    public void enviarNotificacionReserva(String email, String mensaje) {

    }

    @Override
    public void enviarRecordatorioReserva(String idReserva) {

    }

    @Override
    public boolean verificarRestriccionUsuario(String cedulaPersona, String idInstalacion) {
        return false;
    }

    @Override
    public void definirRestricciones(String idInstalacion, int aforoMaximo, LocalDate horarioInicio, LocalDate horarioFin) {

    }

    @Override
    public List<Persona> listarUsuariosPorTipo(TipoPersona tipo) {
        return null;
    }

    @Override
    public List<Instalacion> listarInstalaciones() {
        return null;
    }

    @Override
    public void actualizarInstalacion(String idInstalacion, int aforo, float costo, List<Horario> horarios) {

    }

    @Override
    public void gestionarInstalaciones() throws Exception {
    }

    @Override
    public void gestionarUsuarios() throws Exception {
    }
}
