package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.HashMap;

public class CuentaCorriente {

    private HashMap<Integer, HashMap<Integer, ArrayList<Producto>>> compras = new HashMap<Integer, HashMap<Integer, ArrayList<Producto>>>();
    private Cliente cliente;

    public CuentaCorriente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getCompras(int anio, int mes) {
        return this.compras.get(anio).get(mes);
    }

    public ArrayList<Producto> getCompras(int anio) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        for (Integer mes : this.compras.get(anio).keySet()) {
            for (Producto producto : this.compras.get(anio).get(mes)) {
                listaProductos.add(producto);
            }
        }
        return listaProductos;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void addCompra(Producto producto, int anio, int mes) {
        if (!compras.containsKey(anio)) {
            compras.put(anio, new HashMap<Integer, ArrayList<Producto>>());
        }
        if (!compras.get(anio).containsKey(mes)) {
            compras.get(anio).put(mes, new ArrayList<Producto>());
        }

        compras.get(anio).get(mes).add(producto);
    }

    public double montoACobrar(int anio, int mes) {
        return montoACobrar(getCompras(anio, mes));
    }

    public double montoACobrar(int anio) {
        return montoACobrar(getCompras(anio));
    }

    private double montoACobrar(ArrayList<Producto> listaProductos) {
        double monto = 0;

        for (Producto producto : listaProductos) {
            if (this.cliente.isRegistrado()) {
                if (producto.getTipoDeSuscripcion() == TipoDeSuscripcion.ANUAL) {
                    monto += producto.getPrecio() * 0.8 * 12;
                } else {
                    monto += producto.getPrecio() * 0.95;
                }
            } else {
                if (producto.getTipoDeSuscripcion() == TipoDeSuscripcion.ANUAL) {
                    monto += producto.getPrecio() * 12;
                } else {
                    monto += producto.getPrecio();
                }
            }

        }

        return monto;

    }
}
