package ar.edu.untref.dyasc;

public class ArticuloDeLibreria extends Producto {

    private static double IVA = 21;

    public ArticuloDeLibreria(String nombre,double precio) {
        super(nombre, precio);
    }

    public double getPrecio() {
        return this.precio * (1 + ArticuloDeLibreria.IVA / 100);
    }

}
