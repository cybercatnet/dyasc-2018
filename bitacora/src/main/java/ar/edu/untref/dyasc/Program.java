package ar.edu.untref.dyasc;

public class Program {

    public static void main(String[] args) {
        String destinoBitacora = System.getProperty("DESTINO_BITACORA");
        Configuracion configuracion = new Configuracion();
        if(destinoBitacora == null) {
            destinoBitacora = "";
        }
        configuracion.setDestinoBitacora(destinoBitacora);
        Bitacora bitacora = new Bitacora(configuracion);
        
        bitacora.registrarEvento("Iniciando ejecución");
        bitacora.registrarEvento("Continuando ejecución");
    
    }

}
