package ar.edu.untref.dyasc;

public class Cliente {

    private String nombre;
    private String direccion;
    private boolean registrado = false;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void registrar() {
        this.registrado = true;
    }

    public boolean isRegistrado() {
        return registrado;
    }

}
