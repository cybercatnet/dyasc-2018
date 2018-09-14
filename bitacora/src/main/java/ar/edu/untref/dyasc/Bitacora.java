package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bitacora {
    String rutaArchivo;
    private boolean salidaArchivo;
    public Bitacora(Configuracion configuracion) {
        this.rutaArchivo = configuracion.getDestinoBitacora();
        this.salidaArchivo = rutaArchivo != "";
    }

    public void registrarEvento(String descripcion) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        String fechaFormateada = fecha.format(formateador);
        String detalleRegistro = fechaFormateada + " " + descripcion;
        
        if(salidaArchivo) {
            guardarEnArchivo(detalleRegistro);
        }else {
            generarRegistrosPorPantalla(detalleRegistro);
        }
        
    }

    private void guardarEnArchivo(String detalleRegistro) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.rutaArchivo, true));

            bufferedWriter.append(detalleRegistro + "\n");
            bufferedWriter.close();

        } catch (IOException ex) {
            // System.out.println("Error writing to file '" + this.archivo + "'");
        }

    }

    private void generarRegistrosPorPantalla(String detalleRegistro) {
        System.out.println(detalleRegistro);
    }
}
