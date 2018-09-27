package ar.edu.untref.dyasc;

public abstract class ProductoPeriodico extends Producto {
    protected int periodicidad;

    public ProductoPeriodico(String nombre, double precio, int periodicidad) {
        super(nombre, precio);
        this.periodicidad = periodicidad;

    }

    public double getPrecio() {
        return this.precio * this.periodicidad;
    }

}
