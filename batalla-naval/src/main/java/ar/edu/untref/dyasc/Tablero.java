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

    public void agregarBarco(Barco barco) throws barcoFueraDelTableroException {
        if (barco.getPosicionX() < 0) {
            System.out.println("barco.getPosicionX " + barco.getPosicionX());
            throw new barcoFueraDelTableroException();
        }
        if (barco.getPosicionY() < 0) {
            System.out.println("barco.getPosicionY " + barco.getPosicionY());
            throw new barcoFueraDelTableroException();
        }
        if ((barco.getPosicionX() + barco.getAncho() - 1) > this.ancho) {
            System.out.println("(barco.getPosicionX() + barco.getAncho() - 1) " + (barco.getPosicionX() + barco.getAncho() - 1));
            System.out.println("this.ancho " + this.ancho);
            throw new barcoFueraDelTableroException();
        }
        if ((barco.getPosicionY() + barco.getAlto() - 1) > this.alto) {
            System.out.println("(barco.getPosicionY() + barco.getAlto() - 1) " + (barco.getPosicionY() + barco.getAlto() - 1));
            System.out.println("this.alto " + this.alto);
            throw new barcoFueraDelTableroException();
        }

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

    public Object dispararCelda(int x, int y) {
        for (Barco barco : this.barcos) {
            if (barco.contiene(x, y)) {
                return barco.dispararCelda(x, y);
            }
        }
        return TipoDeCelda.AGUA;
    }
}
