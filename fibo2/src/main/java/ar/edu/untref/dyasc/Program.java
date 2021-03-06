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
        int cantidad = 0;
        String opcion = "";
        ArrayList<Integer> resultado = null;
        if (args.length == 2) {

            if ("-o=".compareTo(args[0].substring(0, 3)) == 0) {
                cantidad = Integer.parseInt(args[1]);
                opcion = args[0].substring(3, 5);
            } else {
                //System.out.println("Opción no válida");
                System.exit(1);
            }
        }
        if (args.length == 1) {
            cantidad = Integer.parseInt(args[0]);
            opcion = "hd";
        }
        resultado = fibo(cantidad);
        switch (opcion) {
        case "hd":
            System.out.print("fibo<" + cantidad + ">:");
            for (int i = 0; i < cantidad; i++) {
                System.out.print(" " + resultado.get(i));
            }
            break;
        case "hi":
            System.out.print("fibo<" + cantidad + ">:");
            for (int i = cantidad - 1; i >= 0; i--) {
                System.out.print(" " + resultado.get(i));
            }
            break;
        case "vd":
            System.out.println("fibo<" + cantidad + ">:");
            for (int i = 0; i < cantidad; i++) {
                System.out.println(resultado.get(i));
            }
            break;
        case "vi":
            System.out.println("fibo<" + cantidad + ">:");
            for (int i = cantidad - 1; i >= 0; i--) {
                System.out.println(resultado.get(i));
            }
            break;
        default:
            System.out.println("Opción no válida");
            System.exit(1);
            break;
        }
    }
}