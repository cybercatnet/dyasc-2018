package ar.edu.untref.dyasc.barco;

import ar.edu.untref.dyasc.tipos.TipoDeCelda;

public class Bote extends Barco {

    public Bote(int posicionX, int posicionY) {
        super(posicionX, posicionY);
        TipoDeCelda celdasBarco[][];
        celdasBarco = new TipoDeCelda[][] { new TipoDeCelda[] { TipoDeCelda.BARCO } };

        setCeldasOcupadas(celdasBarco);

    }

}
