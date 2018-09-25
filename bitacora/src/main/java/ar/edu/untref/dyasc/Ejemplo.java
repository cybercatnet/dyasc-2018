package ar.edu.untref.dyasc;

public class Ejemplo {

    public static void main(String[] args) {

        Configuracion configuracion = new Configuracion();

        Bitacora bitacora = new Bitacora(configuracion);

        bitacora.registrarEvento("Iniciando ejecución");
        bitacora.registrarEvento("Continuando ejecución");

    }

}
