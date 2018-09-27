package ar.edu.untref.dyasc;

public class Ejemplo {

    public static void main(String[] args) {
        Libreria libreria = new Libreria();

        Cliente cliente1 = new Cliente("cliente1", "direccion1");
        libreria.addCliente(cliente1);
        cliente1.registrar();
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(cliente1);
        libreria.addCuentaCorriente(cuentaCorriente1);
        Libro libro1 = new Libro("libro1", 10, TipoDeSuscripcion.UNICA);
        libreria.addProducto(libro1);
        Revista revista1 = new Revista("revista1", 15, 4, TipoDeSuscripcion.MENSUAL);
        libreria.addProducto(revista1);
        ArticuloDeLibreria articuloDeLibreria1 = new ArticuloDeLibreria("articuloDeLibreria1", 20, TipoDeSuscripcion.UNICA);
        libreria.addProducto(articuloDeLibreria1);
        Periodico periodico1 = new Periodico("periodico1", 30, 2, TipoDeSuscripcion.ANUAL);
        libreria.addProducto(articuloDeLibreria1);

        cuentaCorriente1.addCompra(libro1, 2018, 8);
        cuentaCorriente1.addCompra(revista1, 2018, 8);
        cuentaCorriente1.addCompra(periodico1, 2018, 9);
        cuentaCorriente1.addCompra(articuloDeLibreria1, 2018, 10);

        libreria.cobrarACuentaCorriente(cuentaCorriente1, 2018);
        libreria.cobrarACuentaCorriente(cuentaCorriente1, 2018, 8);
    }

}
