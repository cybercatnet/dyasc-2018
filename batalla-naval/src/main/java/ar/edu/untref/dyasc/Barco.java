package ar.edu.untref.dyasc;

public class Barco {
    private int posicionX = 0;
    private int posicionY = 0;
    private TipoDeCelda celdasOcupadas[][];

    public Barco(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public boolean contiene(int posicionX, int posicionY) {
        int posicionXMax = celdasOcupadas.length;
        int posicionYMax = celdasOcupadas[0].length;
        return ((posicionX > this.posicionX && posicionY > this.posicionY)
                && (posicionX < posicionXMax && posicionY < posicionYMax));
    }
    
    protected void setCeldasOcupadas(TipoDeCelda celdasOcupadas[][]) {
        this.celdasOcupadas = celdasOcupadas;
    }
}
