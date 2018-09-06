package ar.edu.untref.dyasc;

public class Program {

    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        fibo.configurar(args);
        fibo.calcular();
        fibo.imprimirYGuardar();
    }
}