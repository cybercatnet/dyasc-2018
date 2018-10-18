package ar.edu.untref.dyasc;

public class Bote extends Barco {

    public Bote(int posicionX, int posicionY) {
        super(posicionX, posicionY);
        TipoDeCelda celdasBarco[][];
        celdasBarco = new TipoDeCelda[][] { new TipoDeCelda[] { TipoDeCelda.BARCO } };

        setCeldasOcupadas(celdasBarco);

    }

}
