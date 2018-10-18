package ar.edu.untref.dyasc;

import org.junit.Assert;
import java.util.concurrent.ThreadLocalRandom;
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
                if (x == 0 && y == 0) {
                    Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                } else {
                    Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                }
            }
        }
    }

    @Test
    public void testCreoUnBoteEnUnaPosicionAleatoriaYVerificoQueEsteEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int ancho = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        int alto = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        Tablero tablero = new Tablero(ancho, alto);
        int posicionXBote = ThreadLocalRandom.current().nextInt(0, ancho + 1);
        int posicionYBote = ThreadLocalRandom.current().nextInt(0, alto + 1);
        Bote bote = new Bote(posicionXBote, posicionYBote);
        tablero.agregarBarco(bote);
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if (x == posicionXBote && y == posicionYBote) {
                    Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                } else {
                    Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                }
            }
        }
    }

    @Test
    public void testCreoUnCruceroHorizontalYVerificoQueEsteEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int ancho = 10;
        int alto = 10;
        Tablero tablero = new Tablero(ancho, alto);
        Crucero crucero = new Crucero(0, 0, TipoDeOrientacion.HORIZONTAL);
        tablero.agregarBarco(crucero);
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if ((y == 0) && (x == 0 || x == 1 || x == 2)) {
                    Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                } else {
                    Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                }
            }
        }
    }
}
