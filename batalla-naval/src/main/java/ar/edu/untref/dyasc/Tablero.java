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

    public void agregarBarco(Barco barco) throws barcoFueraDelTableroException, barcoSuperpuestoException {
        if (barco.getPosicionX() < 0) {
            throw new barcoFueraDelTableroException();
        }
        if (barco.getPosicionY() < 0) {
            throw new barcoFueraDelTableroException();
        }
        if ((barco.getPosicionX() + barco.getAncho()) > this.ancho) {
            throw new barcoFueraDelTableroException();
        }
        if ((barco.getPosicionY() + barco.getAlto()) > this.alto) {
            throw new barcoFueraDelTableroException();
        }

        for (Barco barcoo : this.barcos) {
            if (barcoo.contiene(barco.getPosicionX(), barco.getPosicionY())) {
                throw new barcoSuperpuestoException();
            }
        }

        this.barcos.add(barco);

    }

    public TipoDeCelda verCelda(int x, int y) throws coordenadaFueraDelTableroException {
        if (x < 0) {
            throw new coordenadaFueraDelTableroException();
        }
        if (y < 0) {
            throw new coordenadaFueraDelTableroException();
        }
        if (x > this.ancho - 1) {
            throw new coordenadaFueraDelTableroException();
        }
        if (y > this.alto - 1) {
            throw new coordenadaFueraDelTableroException();
        }
        for (Barco barco : this.barcos) {
            if (barco.contiene(x, y)) {
                return barco.verCelda(x, y);
            }
        }
        return TipoDeCelda.AGUA;
    }

    public Object dispararCelda(int x, int y) throws coordenadaFueraDelTableroException {
        if (x < 0) {
            throw new coordenadaFueraDelTableroException();
        }
        if (y < 0) {
            throw new coordenadaFueraDelTableroException();
        }
        if (x > this.ancho - 1) {
            throw new coordenadaFueraDelTableroException();
        }
        if (y > this.alto - 1) {
            throw new coordenadaFueraDelTableroException();
        }
        for (Barco barco : this.barcos) {
            if (barco.contiene(x, y)) {
                return barco.dispararCelda(x, y);
            }
        }
        return TipoDeCelda.AGUA;
    }
}
