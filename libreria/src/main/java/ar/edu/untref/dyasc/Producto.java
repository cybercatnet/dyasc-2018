package ar.edu.untref.dyasc;

public abstract class Producto {

    protected double precio;
    protected String nombre;

    public Producto(String nombre, double precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getnombre() {
        return this.nombre;
    }

}
