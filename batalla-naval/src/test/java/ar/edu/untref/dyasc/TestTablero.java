package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class TestTablero {

    @Test
    public void testCreoTableroVacioYVerificoQueTodosLasCeldasSonAgua() {
        int ancho = 10;
        int alto = 10;
        Tablero tablero = new Tablero(ancho, alto);
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
            }
        }
    }

    @Test
    public void testCreoUnBoteYVerificoQueEsteEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int ancho = 10;
        int alto = 10;
        Tablero tablero = new Tablero(ancho, alto);
        Bote bote = new Bote(0, 0);
        tablero.agregarBarco(bote);
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if(x==0 && y==0) {
                    Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                }else {
                    Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                }
            }
        }
    }
}
