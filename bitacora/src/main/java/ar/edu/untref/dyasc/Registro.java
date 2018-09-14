package ar.edu.untref.dyasc;

import java.time.LocalDateTime;

public class Registro {
    
    private String detalle;
    private LocalDateTime fecha;

    public Registro(String detalle, LocalDateTime fecha) {
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    
}
