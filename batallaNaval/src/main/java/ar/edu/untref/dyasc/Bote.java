package ar.edu.untref.dyasc;

public class Bote extends Barco {

    public Bote(int posicionX, int posicionY, TipoDeOrientacion tipoDeOrientacion) {
        super(posicionX, posicionY);
        TipoDeCelda celdasBarco[][];
        if(tipoDeOrientacion == TipoDeOrientacion.HORIZONTAL) {
            TipoDeCelda celdasBarco[][] = new TipoDeCelda[][]= {
                    new TipoDeCelda[] {TipoDeCelda.VEHICUlO,TipoDeCelda.VEHICUlO,TipoDeCelda.VEHICUlO}
            };
            setCeldasOcupadas(celdasBarco);
        }
    }

}
