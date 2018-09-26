package ar.edu.untref.dyasc;

public class Configuracion {
    SalidaDestinoCompuesta salidaDestinoCompuesta = new SalidaDestinoCompuesta();

    public Configuracion() {
        String destinoBitacora = System.getProperty("DESTINO_BITACORA");
        if (destinoBitacora == null) {
            this.salidaDestinoCompuesta.addDestinoBitacora(new SalidaDestino("CONSOLA"));
        } else {
            String[] destinos = destinoBitacora.split(",");
            for (String destino : destinos) {
                this.salidaDestinoCompuesta.addDestinoBitacora(new SalidaDestino(destino));
            }
        }
    }

}
