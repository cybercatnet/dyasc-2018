package ar.edu.untref.dyasc;

import java.util.ArrayList;

public class Libreria {
    private ArrayList<CuentaCorriente> cuentas = new ArrayList<CuentaCorriente>();

    private ArrayList<Producto> productos = new ArrayList<Producto>();

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

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
    
    public ArrayList<Producto> getProductos( ) {
        return this.productos;
    }

    public ArrayList<Cliente> getClientes( ) {
        return this.clientes;
    }

    public ArrayList<CuentaCorriente> getCuentasCorrientes( ) {
        return this.cuentas;
    }


    private void imprimirListaProductos(CuentaCorriente cuentaCorriente, int anio, int mes) {
        for (Producto producto : cuentaCorriente.getCompras(anio, mes)) {
            System.out.println(producto.getnombre());
        }
    }

    private void imprimirListaProductos(CuentaCorriente cuentaCorriente, int anio) {
        for (Producto producto : cuentaCorriente.getCompras(anio)) {
            System.out.println(producto.getnombre());
        }
    }
    
    public void cobrarACuentaCorriente(CuentaCorriente cuentaCorriente, int anio, int mes) {
        System.out.println("Cuenta Corriente del Cliente " + cuentaCorriente.getCliente().getNombre());
        System.out.println("Productos:");
        imprimirListaProductos(cuentaCorriente, anio, mes);
        System.out.println();
        System.out.println("Monto a Pagar al anio " + anio + " " + "en el mes de " + mes + " " + cuentaCorriente.montoACobrar(anio, mes));
        System.out.println();
    }

    public void cobrarACuentaCorriente(CuentaCorriente cuentaCorriente, int anio) {
        System.out.println("Cuenta Corriente del Cliente " + cuentaCorriente.getCliente().getNombre());
        System.out.println("Productos:");
        imprimirListaProductos(cuentaCorriente, anio);
        System.out.println();
        System.out.println("Monto a Pagar al anio " + anio + " " + cuentaCorriente.montoACobrar(anio));
        System.out.println();
    }

}
