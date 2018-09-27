package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.List;

public class CuentaCorriente {

    private HashMap compras;
    private Cliente cliente;

    public CuentaCorriente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getCompras(int anio, int mes) {
        return null;
    }

    public List<Producto> getCompras(int anio) {
        return null;
    }

    public double getMontoACobrar(int anio, int mes) {
        return 0;
    }

    public double getMontoACobrar(int anio) {
        return 0;
    }

    public String getDatosCliente() {
        return this.cliente.getDireccion();
    }

    public void addCompra(Producto producto, int anio, int mes) {

    }

}
