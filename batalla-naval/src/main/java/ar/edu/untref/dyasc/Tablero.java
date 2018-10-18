package ar.edu.untref.dyasc;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Barco> barcos = new ArrayList<Barco>();
    private int ancho = 0;
    private int alto = 0;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void agregarBarco(Barco barco) {
        this.barcos.add(barco);
    }

    public TipoDeCelda verCelda(int x, int y) {
        for (Barco barco : this.barcos) {
            if (barco.contiene(x, y)) {
                return barco.verCelda(x, y);
            }
        }
        return TipoDeCelda.AGUA;

    }
}
