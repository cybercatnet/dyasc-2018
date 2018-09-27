package ar.edu.untref.dyasc;

public abstract class ProductoPeriodico extends Producto {
    protected int periodicidad;

    public ProductoPeriodico(String nombre, double precio, int periodicidad, TipoDeSuscripcion tipoDeSuscripcion) {

        super(nombre, precio, tipoDeSuscripcion);
        this.periodicidad = periodicidad;

    }

    public double getPrecio() {
        return this.precio * this.periodicidad;
    }

}
