package ar.edu.untref.dyasc;

import java.util.List;

public class Libreria {
    private List<CuentaCorriente> cuentas;

    private List<Producto> productos;

    private List<Cliente> clientes;

    public Libreria() {
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void addCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentas.add(cuentaCorriente);
    }

}
