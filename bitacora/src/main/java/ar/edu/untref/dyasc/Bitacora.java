package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bitacora {
    private Configuracion configuracion;

    public Bitacora(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public void registrarEvento(String descripcion) {
        String detalleRegistro = obtenerDetalleRegistroFormateado(descripcion);

        generarRegistro(detalleRegistro);

    }

    private void generarRegistro(String detalleRegistro) {
        this.configuracion.salidaDestinoCompuesta.registrar(detalleRegistro);

    }

    private String obtenerDetalleRegistroFormateado(String descripcion) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        String fechaFormateada = fecha.format(formateador);
        String detalleRegistro = fechaFormateada + " " + descripcion;
        return detalleRegistro;
    }

}
