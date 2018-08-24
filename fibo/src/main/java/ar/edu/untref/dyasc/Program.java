package ar.edu.untref.dyasc;

import java.util.ArrayList;

public class Program {

    public static ArrayList<Integer> fibo(int cantidad) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(0);
        if (cantidad == 1) {
            return lista;
        }
        lista.add(1);
        if (cantidad == 2) {
            return lista;
        }
        for (int i = 2; i < cantidad; i++) {
            lista.add(lista.get(i - 1) + lista.get(i - 2));
        }
        return lista;
    }

    public static void main(String[] args) {

        int cantidad = Integer.parseInt(args[0]);
        ArrayList<Integer> resultado = fibo(cantidad);
        System.out.print("fibo<" + cantidad + ">:");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(" " + resultado.get(i));
        }
    }

}
