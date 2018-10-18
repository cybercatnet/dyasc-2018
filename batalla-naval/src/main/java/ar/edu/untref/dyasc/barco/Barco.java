package ar.edu.untref.dyasc.barco;

import ar.edu.untref.dyasc.tipos.TipoDeCelda;

public class Barco {
    private int posicionX = 0;
    private int posicionY = 0;

    private TipoDeCelda celdasOcupadas[][];

    public Barco(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getAncho() {
        return celdasOcupadas.length;
    }

    public int getAlto() {
        return celdasOcupadas[0].length;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public boolean contiene(int posicionX, int posicionY) {
        int posicionXMin = this.posicionX;
        int posicionYMin = this.posicionY;
        int posicionXMax = posicionXMin + getAncho() - 1;
        int posicionYMax = posicionYMin + getAlto() - 1;
        return ((posicionX >= posicionXMin && posicionY >= posicionYMin) && (posicionX <= posicionXMax && posicionY <= posicionYMax));
    }

    protected void setCeldasOcupadas(TipoDeCelda celdasOcupadas[][]) {
        this.celdasOcupadas = celdasOcupadas;
    }

    public TipoDeCelda verCelda(int x, int y) {
        return this.celdasOcupadas[x - this.posicionX][y - this.posicionY];
    }

    public Object dispararCelda(int x, int y) {
        celdasOcupadas[x - this.posicionX][y - this.posicionY] = TipoDeCelda.TOCADO;
        boolean hundido = true;
        for (TipoDeCelda[] xx : this.celdasOcupadas) {
            for (TipoDeCelda yy : xx) {
                hundido &= (yy == TipoDeCelda.TOCADO);
            }
        }
        return hundido ? TipoDeCelda.HUNDIDO : TipoDeCelda.TOCADO;
    }
}
