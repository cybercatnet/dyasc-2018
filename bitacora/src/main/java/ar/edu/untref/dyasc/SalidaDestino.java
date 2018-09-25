package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SalidaDestino {
    private String rutaArchivo;
    private boolean salidaArchivo;

    public SalidaDestino(String destino) {
        if (destino.equals("CONSOLA")) {
            this.salidaArchivo = false;
        } else {
            this.rutaArchivo = destino;
            this.salidaArchivo = true;
        }
    }

    public SalidaDestino() {

    }

    public void registrar(String detalleRegistro) {
        if (this.salidaArchivo) {
            registrarEnArchivo(detalleRegistro);
        } else {
            registrarPorConsola(detalleRegistro);
        }
    }

    private void registrarEnArchivo(String detalleRegistro) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.rutaArchivo, true));

            bufferedWriter.append(detalleRegistro + "\n");
            bufferedWriter.close();

        } catch (IOException ex) {
        }

    }

    private void registrarPorConsola(String detalleRegistro) {
        System.out.println(detalleRegistro);

    }

}
