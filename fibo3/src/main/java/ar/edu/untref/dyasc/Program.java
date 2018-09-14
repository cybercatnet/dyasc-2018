package ar.edu.untref.dyasc;

public class Program {

    public static void main(String[] args) {
    	Configuracion configuracion = new Configuracion(args);
        Fibo fibo = new Fibo(configuracion);
        Salida salida = new Salida(configuracion);
        if(configuracion.isModoLista()){
        	salida.imprimir(fibo.obtenerSerie());
        }else {
        	salida.imprimir(fibo.obtenerSumatoria());
    	}
    }
}