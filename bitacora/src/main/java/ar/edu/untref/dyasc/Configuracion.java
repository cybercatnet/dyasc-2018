package ar.edu.untref.dyasc;

public class Configuracion {
    SalidaDestinoCompuesta salidaDestinoCompuesta = new SalidaDestinoCompuesta();

    public Configuracion() {
        String destinoBitacora = System.getProperty("DESTINO_BITACORA");
        if (destinoBitacora == null) {
            salidaDestinoCompuesta.addDestinoBitacora(new SalidaDestino("CONSOLA"));
        } else {
            String[] destinos = destinoBitacora.split(",");
            for (String destino : destinos) {
                salidaDestinoCompuesta.addDestinoBitacora(new SalidaDestino(destino));
            }
        }
    }

}
