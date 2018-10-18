package ar.edu.untref.dyasc;

public class Crucero extends Barco {

    public Crucero(int posicionX, int posicionY, TipoDeOrientacion tipoDeOrientacion) {
        super(posicionX, posicionY);
        TipoDeCelda celdasBarco[][];

        if (tipoDeOrientacion == TipoDeOrientacion.VERTICAL) {
            celdasBarco = new TipoDeCelda[][] { new TipoDeCelda[] { TipoDeCelda.BARCO, TipoDeCelda.BARCO, TipoDeCelda.BARCO } };
        } else {
            celdasBarco = new TipoDeCelda[][] { new TipoDeCelda[] { TipoDeCelda.BARCO }, new TipoDeCelda[] { TipoDeCelda.BARCO }, new TipoDeCelda[] { TipoDeCelda.BARCO } };
        }

        setCeldasOcupadas(celdasBarco);
    }

}
