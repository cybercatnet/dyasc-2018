package ar.edu.untref.dyasc;

import java.util.ArrayList;

public class SalidaDestinoCompuesta extends SalidaDestino{
    public SalidaDestinoCompuesta() {
        super();
    }

    private ArrayList<SalidaDestino> destinoBitacora = new ArrayList<SalidaDestino>();

    public void addDestinoBitacora(SalidaDestino destinoBitacora) {
        this.destinoBitacora.add(destinoBitacora);
    }

    public ArrayList<SalidaDestino> getDestinoBitacora() {
        return this.destinoBitacora;
    }

    public void registrar(String detalleRegistro) {
        for (SalidaDestino SalidaDestino : this.destinoBitacora) {
            SalidaDestino.registrar(detalleRegistro);
        }

    }
}
