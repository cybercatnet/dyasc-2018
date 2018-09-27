package ar.edu.untref.dyasc;

public class ArticuloDeLibreria extends Producto {

    private static double IVA = 21;

    public ArticuloDeLibreria(String nombre, double precio, TipoDeSuscripcion tipoDeSuscripcion) {
        super(nombre, precio, tipoDeSuscripcion);
    }

    public double getPrecio() {
        return this.precio * (1 + ArticuloDeLibreria.IVA / 100);
    }

}
