package ar.edu.untref.dyasc;

public abstract class Producto {

    protected double precio;
    protected String nombre;
    private TipoDeSuscripcion tipoDeSuscripcion;

    public Producto(String nombre, double precio, TipoDeSuscripcion tipoDeSuscripcion) {
        this.precio = precio;
        this.nombre = nombre;
        this.tipoDeSuscripcion = tipoDeSuscripcion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getnombre() {
        return this.nombre;
    }

    public TipoDeSuscripcion getTipoDeSuscripcion() {
        return tipoDeSuscripcion;
    }
}
