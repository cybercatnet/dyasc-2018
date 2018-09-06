package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fibo {
    private ArrayList<Integer> lista = null;
    private int sumatoria = 0;
    private int cantidad = 0;
    private String opcion = "hd";
    private String modo = "l";
    private String archivo = null;

    public Fibo() {
    }

    public void configurar(String[] args) {
        for (String parametro : args) {
            try {
                if ("-o=".compareTo(parametro.substring(0, 3)) == 0) {
                    this.opcion = parametro.substring(3);
                } else {
                    if ("-m=".compareTo(parametro.substring(0, 3)) == 0) {
                        this.modo = parametro.substring(3);
                    } else {
                        if ("-f=".compareTo(parametro.substring(0, 3)) == 0) {
                            this.archivo = parametro.substring(3);
                        } else {
                            this.cantidad = Integer.parseInt(parametro);
                        }
                    }
                }
            } catch (StringIndexOutOfBoundsException excepcion) {
                this.cantidad = Integer.parseInt(parametro);
            }
        }
    }

    public void imprimirYGuardar() {
        String salida = "";
        salida = "fibo<";
        switch (this.opcion) {
        case "hd":
            switch (this.modo) {
            case "l":
                salida += this.cantidad + ">:";
                for (int i = 0; i < this.cantidad; i++) {
                    salida += " " + this.lista.get(i);
                }
                break;
            case "s":
                salida += this.cantidad + ">s: ";
                salida += this.sumatoria;
                break;
            }
            break;
        case "hi":
            switch (this.modo) {
            case "l":
                salida += this.cantidad + ">:";
                for (int i = this.cantidad - 1; i >= 0; i--) {
                    salida += " " + this.lista.get(i);
                }
                break;
            case "s":
                salida += this.cantidad + ">s: ";
                salida += this.sumatoria;
                break;
            }
            break;
        case "vd":
            switch (this.modo) {
            case "l":
                salida += this.cantidad + ">:";
                for (int i = 0; i < this.cantidad; i++) {
                    salida += this.lista.get(i) + "\n";
                }
                break;
            case "s":
                salida += this.cantidad + ">s: ";
                salida += this.sumatoria + "\n";
                break;
            }
            break;
        case "vi":
            switch (this.modo) {
            case "l":
                salida += this.cantidad + ">:";
                for (int i = this.cantidad - 1; i >= 0; i--) {
                    salida += this.lista.get(i) + "\n";
                }
                break;
            case "s":
                salida += this.cantidad + ">s: ";
                salida += this.sumatoria + "\n";
                break;
            }
            break;
        default:
            System.out.println("Opción no válida");
            System.exit(1);
            break;
        }
        System.out.println(salida);
        if (this.archivo != null) {
            try {

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.archivo));

                bufferedWriter.write(salida);

                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println("Error writing to file '" + this.archivo + "'");
            }
        }

    }

    public void calcular() {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(0);
        if (this.cantidad == 1) {
            this.lista = lista;
        }
        lista.add(1);
        if (this.cantidad == 2) {
            this.lista = lista;
        }
        for (int i = 2; i < this.cantidad; i++) {
            lista.add(lista.get(i - 1) + lista.get(i - 2));
        }
        for (int item : lista) {
            this.sumatoria += item;
        }
        this.lista = lista;
    }
}
