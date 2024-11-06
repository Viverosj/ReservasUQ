package co.edu.uniquindio.reservasuq.modelo;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import co.edu.uniquindio.reservasuq.servicio.ServiciosReservasUQ;
import co.edu.uniquindio.reservasuq.utils.EnvioEmail;
import javafx.scene.control.Alert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class ReservasUQ implements ServiciosReservasUQ {

    private List<Persona> personas;
    private List<Instalacion> instalaciones;
    private List<Reserva> reservas;

    //Primero registra una persona, busca en la lista si hay persona ya registrada con su numero de cedula,
    // si no esta registrada la registra, de lo contrario manda un mensaje de que ya esta registrado el usuario y la añade a la lista de personas (TENER EN CUENTA EN EL REGISTROCONTROLADOR)

    public Persona registrarPersona(String cedula, String nombre, TipoPersona tipoPersona, String correo, String password) throws Exception {
        String mensajesValidacion = "";

        if (cedula == null || cedula.isEmpty()) {
            mensajesValidacion += "Debe ingresar la cédula\n";
        }

        if (nombre == null || nombre.isEmpty()) {
            mensajesValidacion += "Debe ingresar el nombre\n";
        }

        if (correo == null || correo.isEmpty()) {
            mensajesValidacion += "Debe ingresar el correo\n";
        } else {
            // Usar el método esCorreoValido para validar el formato del correo
            if (!esCorreoValido(correo)) {
                mensajesValidacion += "El correo debe ser válido y tener el formato adecuado\n";
            }
        }

        if (tipoPersona == null) {
            mensajesValidacion += "Debe seleccionar un tipo de persona\n";
        }

        if (!mensajesValidacion.isEmpty()) {
            throw new Exception(mensajesValidacion);
        }

        if (obtenerPersona(cedula) != null) {
            throw new Exception("Ya existe un usuario con la identificación ingresada");
        }

        Persona persona = Persona.builder()
                .tipoPersona(tipoPersona)
                .cedula(cedula)
                .nombre(nombre)
                .correo(correo)
                .build();

        personas.add(persona);
        return persona;
    }

    // busca a la persona con la cedula ingresada en la lista de personas
    public Persona obtenerPersona(String cedula) throws Exception {
        for (Persona persona : personas) {
            if (persona.getCedula().equals(cedula)) {
                return persona;
            }
        }
        return null;
    }

    //Metodo para Validar el correo Electronico
    public static boolean esCorreoValido(String correo) {
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (correo==null) {
            return false;
        }

        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    //Este metodo valida que los campos de iniciar sesion
    // no esten vacios y que correo y contraseña esten correctos
    // VALIDA LOS DATOS, Entonces va en el login controlador

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

    // Metodo de crearReserva: valida que todos los datos esten ingresados y seleccionados
    // crea la reserva la añade a una lista de reservas
    // verifica si hay disponibilidad, calcula el costo segun el tipo de persona
    // tambien verifica si se cumple con el aforo de la instalacion
    public Reserva crearReserva(String cedulaPersona, Instalacion instalacion, LocalDate diaReserva, String hora, double costo) throws Exception {

        String mensajesValidacion = "";

        if (cedulaPersona == null || cedulaPersona.isEmpty()) {
            mensajesValidacion += "Debe ingresar la cedula\n";
        }

        if (instalacion == null) {
            mensajesValidacion += "Debe seleccionar una instalacion\n";
        }

        if (diaReserva == null) {
            mensajesValidacion += "Debe seleccionar el día de la reserva\n";
        }

        if (hora == null) {
            mensajesValidacion += "Debe seleccionar la hora de la reserva\n";
        }

        if (!mensajesValidacion.isEmpty()) {
            throw new Exception(mensajesValidacion);
        }

        if (diaReserva.isBefore(LocalDate.now())) {
            throw new Exception("La fecha de la reserva no puede ser anterior a la fecha actual");
        }

        LocalTime horaReserva = LocalTime.parse(hora);

        if (!hayDisponibilidad(diaReserva, horaReserva, instalacion)) {
            throw new Exception("Ya existe una reserva agendada para el día y hora seleccionados");
        }

        // Verificar si la instalación ha alcanzado su capacidad máxima para la fecha y hora especificadas
        int reservasExistentes = contarReservasParaInstalacion(instalacion, diaReserva, horaReserva);
        if (reservasExistentes >= instalacion.getAforo()) {
            throw new Exception("La instalación ha alcanzado su capacidad máxima para el día y hora seleccionados");
        }

        Persona persona = obtenerPersona(cedulaPersona);

        double costoReserva = persona.getTipoPersona() == TipoPersona.EXTERNO ? instalacion.getCosto() : 0.0;


        Reserva reserva = Reserva.builder()
                .persona(persona)
                .id(String.valueOf(UUID.randomUUID()))
                .diaReserva(diaReserva)
                .horaReserva(horaReserva)
                .instalacion(instalacion)
                .costo(costoReserva)
                .build();

        reservas.add(reserva);

        String mensaje = "Reserva confirmada para" + persona.getNombre()
                + "\nServicio: " + instalacion.getNombre()
                + "\nDía: " + reserva.getDiaReserva()
                + "\nHora: " + reserva.getHoraReserva()
                + "\nCosto Total: $" + costo;

        EnvioEmail.enviarNotificacion(persona.getCorreo(), "Confirmacion de reserva", mensaje);
        return reserva;
    }

    //Método para contar las reservas de una instalación en una fecha y hora específicas
    public int contarReservasParaInstalacion(Instalacion instalacion, LocalDate diaReserva, LocalTime horaReserva) {
        int contador = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getInstalacion().equals(instalacion)
                    && reserva.getDiaReserva().equals(diaReserva)
                    && reserva.getHoraReserva().equals(horaReserva)) {
                contador++;
            }
        }
        return contador;
    }

    //Metodo para tener en cuenta si hay disponibilidad
    public boolean hayDisponibilidad(LocalDate diaReserva, LocalTime horaReserva, Instalacion instalacion) {
        for (Reserva reserva : reservas) {
            if (reserva.getDiaReserva().equals(diaReserva) && reserva.getHoraReserva().equals(horaReserva) && reserva.getInstalacion() == instalacion) {
                return false;
            }
        }
        return true;
    }

    //Metodo para listar Todas las reservas realizadas por el Usuario
    // tener en cuenta el metodo de agendarCita de clinica

    public List<Reserva> listarReservasPorPersona(String cedulaPersona) throws Exception {
        if (cedulaPersona == null || cedulaPersona.isEmpty()) {
            throw new Exception("Debe ingresar una cédula válida");
        }
        List<Reserva> reservasPersona = new ArrayList<>();
        // Filtrar las reservas que pertenecen a la persona con la cédula
        for (Reserva reserva : reservas) {
            if (reserva.getPersona().getCedula().equals(cedulaPersona)) {
                reservasPersona.add(reserva);
            }
        }
        if (reservasPersona.isEmpty()) {
            throw new Exception("No se encontraron reservas para la persona con cédula: " + cedulaPersona);
        }
        return reservasPersona;
    }

    //Metodo de cancelar reserva
    public void cancelarReserva(String reservaId) {
        for (Reserva reserva: reservas) {
            if(reserva.getId().equals(reservaId)){
                reservas.remove(reserva);
                break;
            }
        }
    }

    //Metodo de crear Instalacion (ADMINISTRADOR)

    public Instalacion crearInstalacion(String nombre, int aforo, double costoBase, List<Horario> horarios) throws Exception {

        String mensajesValidacion = "";

        // Instalaciones predeterminadas
        if (instalaciones.isEmpty()) {
            // Ejemplo de instalaciones predeterminadas
            Instalacion instalacion1 = Instalacion.builder()
                    .Id(String.valueOf(UUID.randomUUID()))
                    .nombre("Gimnasio principal")
                    .aforo(30)
                    .costo(5.000)
                    .horarios(Arrays.asList(new Horario(LocalTime.of(6, 0), LocalTime.of(10, 0))))
                    .build();

            Instalacion instalacion2 = Instalacion.builder()
                    .Id(String.valueOf(UUID.randomUUID()))
                    .nombre("Sala de yoga")
                    .aforo(20)
                    .costo(4.000)
                    .horarios(Arrays.asList(new Horario(LocalTime.of(8, 0), LocalTime.of(12, 0))))
                    .build();

            Instalacion instalacion3 = Instalacion.builder()
                    .Id(String.valueOf(UUID.randomUUID()))
                    .nombre("Piscina")
                    .aforo(15)
                    .costo(10.000)
                    .horarios(Arrays.asList(new Horario(LocalTime.of(9, 0), LocalTime.of(18, 0))))
                    .build();

            // Agregar las instalaciones predeterminadas a la lista
            instalaciones.add(instalacion1);
            instalaciones.add(instalacion2);
            instalaciones.add(instalacion3);
        }

        if (nombre == null || nombre.isEmpty()) {
            mensajesValidacion += "El nombre de la instalación no puede estar vacío.\n";
        }

        if (aforo <= 0) {
            mensajesValidacion += "El aforo debe ser mayor a 0.\n";
        }

        if (costoBase < 0) {
            mensajesValidacion += "El costo base no puede ser negativo.\n";
        }

        if (horarios == null || horarios.isEmpty()) {
            mensajesValidacion += "Debe proporcionar al menos un horario para la instalación.\n";
        }

        // Validar que los horarios sean válidos (hora fin debe ser posterior a hora inicio)
        for (Horario horario : horarios) {
            if (horario.getHoraFin().isBefore(horario.getHoraInicio())) {
                mensajesValidacion += "La hora de fin debe ser posterior a la hora de inicio para el horario: " + horario + "\n";
            }
        }

        if (!mensajesValidacion.isEmpty()) {
            throw new Exception(mensajesValidacion);
        }

        Instalacion instalacion = Instalacion.builder()
                .Id(String.valueOf(UUID.randomUUID()))
                .nombre(nombre)
                .aforo(aforo)
                .costo(costoBase)
                .horarios(horarios)
                .build();

        instalaciones.add(instalacion);

        return instalacion;
    }

    // Método para listar todas las instalaciones creadas (ADMINISTRADOR)
    public List<Instalacion> listarInstalaciones() throws Exception {
        if (instalaciones.isEmpty()) {
            throw new Exception("No hay instalaciones creadas.");
        }
        return instalaciones;  // Devuelve la lista de instalaciones
    }

    //Metodo de eliminar instalacion (ADMINISTRADOR)
    public void eliminarInstalacion(String instalacionId) {
        for (Instalacion instalacion: instalaciones) {
            if(instalacion.getId().equals(instalacionId)){
                instalaciones.remove(instalacion);
                break;
            }
        }
    }

    // Método para actualizar una instalación por su ID (ADMINISTRADOR)
    public void actualizarInstalacion(String idInstalacion, String nuevoNombre, int nuevoAforo, double nuevoCosto, List<Horario> nuevosHorarios) throws Exception {

        Instalacion instalacionAActualizar = null;

        for (Instalacion instalacion : instalaciones) {
            if (instalacion.getId().equals(idInstalacion)) {
                instalacionAActualizar = instalacion;
                break;
            }
        }

        if (instalacionAActualizar == null) {
            throw new Exception("Instalación no encontrada con ID: " + idInstalacion);
        }

        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            instalacionAActualizar.setNombre(nuevoNombre);
        }
        if (nuevoAforo > 0) {
            instalacionAActualizar.setAforo(nuevoAforo);
        } else {
            throw new Exception("El aforo debe ser mayor que 0");
        }
        if (nuevoCosto >= 0) {
            instalacionAActualizar.setCosto(nuevoCosto);
        } else {
            throw new Exception("El costo debe ser mayor o igual a 0");
        }
        if (nuevosHorarios != null && !nuevosHorarios.isEmpty()) {
            instalacionAActualizar.setHorarios(nuevosHorarios);
        } else {
            throw new Exception("Los horarios no pueden estar vacíos");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Instalación Actualizada");
        alert.setHeaderText("La instalación se ha actualizado correctamente.");
        alert.setContentText("Instalación: " + instalacionAActualizar.getNombre() +
                "\nNuevo Aforo: " + instalacionAActualizar.getAforo() +
                "\nNuevo Costo: $" + instalacionAActualizar.getCosto());
        alert.showAndWait();
    }

}
