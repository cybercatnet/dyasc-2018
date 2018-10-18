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
                try {
                    Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                } catch (coordenadaFueraDelTableroException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCreoUnBoteYVerificoQueEsteEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int ancho = 10;
        int alto = 10;
        Tablero tablero = new Tablero(ancho, alto);
        Bote bote = new Bote(0, 0);
        try {
            tablero.agregarBarco(bote);
        } catch (barcoFueraDelTableroException e) {
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if (x == 0 && y == 0) {
                    try {
                        Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void testCreoUnBoteEnUnaPosicionAleatoriaYVerificoQueEsteEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int anchoMinimo = 3;
        int anchoMaximo = 10;
        int altoMinimo = 3;
        int altoMaximo = 10;
        int ancho = ThreadLocalRandom.current().nextInt(anchoMinimo, anchoMaximo + 1);
        int alto = ThreadLocalRandom.current().nextInt(altoMinimo, altoMaximo + 1);
        Tablero tablero = new Tablero(ancho, alto);
        int posicionXBote = ThreadLocalRandom.current().nextInt(0, ancho - 1 + 1);
        int posicionYBote = ThreadLocalRandom.current().nextInt(0, alto - 1 + 1);
        Bote bote = new Bote(posicionXBote, posicionYBote);

        try {
            tablero.agregarBarco(bote);
        } catch (barcoFueraDelTableroException e) {
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if (x == posicionXBote && y == posicionYBote) {
                    try {
                        Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
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
        try {
            tablero.agregarBarco(crucero);
        } catch (barcoFueraDelTableroException e) {
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if ((y == 0) && (x == 0 || x == 1 || x == 2)) {
                    try {
                        Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void testCreoUnCruceroVerticalYVerificoQueEsteEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int ancho = 10;
        int alto = 10;
        Tablero tablero = new Tablero(ancho, alto);
        Crucero crucero = new Crucero(0, 0, TipoDeOrientacion.VERTICAL);
        try {
            tablero.agregarBarco(crucero);
        } catch (barcoFueraDelTableroException e) {
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if ((x == 0) && (y == 0 || y == 1 || y == 2)) {
                    try {
                        Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void testCreoUnCruceroEnUnaPosicionAleatoriaYVerificoQueEsteEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int anchoMinimo = 3;
        int anchoMaximo = 10;
        int altoMinimo = 3;
        int altoMaximo = 10;
        int ancho = ThreadLocalRandom.current().nextInt(anchoMinimo, anchoMaximo + 1);
        int alto = ThreadLocalRandom.current().nextInt(altoMinimo, altoMaximo + 1);
        Tablero tablero = new Tablero(ancho, alto);
        TipoDeOrientacion orientacion = TipoDeOrientacion.values()[ThreadLocalRandom.current().nextInt(TipoDeOrientacion.values().length)];
        int posicionXCrucero;
        int posicionYCrucero;

        if (orientacion == TipoDeOrientacion.HORIZONTAL) {
            posicionXCrucero = ThreadLocalRandom.current().nextInt(0, ancho - 3 + 1);
            posicionYCrucero = ThreadLocalRandom.current().nextInt(0, alto - 1 + 1);
        } else {
            posicionXCrucero = ThreadLocalRandom.current().nextInt(0, ancho - 1 + 1);
            posicionYCrucero = ThreadLocalRandom.current().nextInt(0, alto - 3 + 1);
        }
        Crucero crucero = new Crucero(posicionXCrucero, posicionYCrucero, orientacion);
        try {
            tablero.agregarBarco(crucero);
        } catch (barcoFueraDelTableroException e) {
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if (orientacion == TipoDeOrientacion.HORIZONTAL) {
                    if ((y == posicionYCrucero) && (x == posicionXCrucero || x == posicionXCrucero + 1 || x == posicionXCrucero + 2)) {
                        try {
                            Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                        } catch (coordenadaFueraDelTableroException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                        } catch (coordenadaFueraDelTableroException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if ((x == posicionXCrucero) && (y == posicionYCrucero || y == posicionYCrucero + 1 || y == posicionYCrucero + 2)) {
                        try {
                            Assert.assertEquals(TipoDeCelda.BARCO, tablero.verCelda(x, y));
                        } catch (coordenadaFueraDelTableroException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                        } catch (coordenadaFueraDelTableroException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }

    @Test
    public void testCreoUnBoteYDisparoEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int ancho = 10;
        int alto = 10;
        Tablero tablero = new Tablero(ancho, alto);
        Bote bote = new Bote(0, 0);
        try {
            tablero.agregarBarco(bote);
        } catch (barcoFueraDelTableroException e) {
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if (x == 0 && y == 0) {
                    try {
                        Assert.assertEquals(TipoDeCelda.HUNDIDO, tablero.dispararCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Assert.assertEquals(TipoDeCelda.AGUA, tablero.dispararCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void testCreoUnBoteEnUnaPosicionAleatoriaYDisparoEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int anchoMinimo = 3;
        int anchoMaximo = 10;
        int altoMinimo = 3;
        int altoMaximo = 10;
        int ancho = ThreadLocalRandom.current().nextInt(anchoMinimo, anchoMaximo + 1);
        int alto = ThreadLocalRandom.current().nextInt(altoMinimo, altoMaximo + 1);
        Tablero tablero = new Tablero(ancho, alto);
        int posicionXBote = ThreadLocalRandom.current().nextInt(0, ancho);
        int posicionYBote = ThreadLocalRandom.current().nextInt(0, alto);
        Bote bote = new Bote(posicionXBote, posicionYBote);
        try {
            tablero.agregarBarco(bote);
        } catch (barcoFueraDelTableroException e) {
            System.out.println("testCreoUnBoteEnUnaPosicionAleatoriaYDisparoEnLaPosicionCreadaYQueTodoLoDemasSeaAgua");
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if (x == posicionXBote && y == posicionYBote) {
                    try {
                        Assert.assertEquals(TipoDeCelda.HUNDIDO, tablero.dispararCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void testCreoUnCruceroHorizontalYDisparoEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int ancho = 10;
        int alto = 10;
        Tablero tablero = new Tablero(ancho, alto);
        Crucero crucero = new Crucero(0, 0, TipoDeOrientacion.HORIZONTAL);
        try {
            tablero.agregarBarco(crucero);
        } catch (barcoFueraDelTableroException e) {
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if ((y == 0) && (x == 0 || x == 1 || x == 2)) {
                    if (x == 2) {
                        try {
                            Assert.assertEquals(TipoDeCelda.HUNDIDO, tablero.dispararCelda(x, y));
                        } catch (coordenadaFueraDelTableroException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            Assert.assertEquals(TipoDeCelda.TOCADO, tablero.dispararCelda(x, y));
                        } catch (coordenadaFueraDelTableroException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        Assert.assertEquals(TipoDeCelda.AGUA, tablero.dispararCelda(x, y));
                    } catch (coordenadaFueraDelTableroException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void testCreoUnCruceroEnUnaPosicionAleatoriaYDisparoEnLaPosicionCreadaYQueTodoLoDemasSeaAgua() {
        int anchoMinimo = 3;
        int anchoMaximo = 3;
        int altoMinimo = 3;
        int altoMaximo = 3;
        int ancho = ThreadLocalRandom.current().nextInt(anchoMinimo, anchoMaximo + 1);
        int alto = ThreadLocalRandom.current().nextInt(altoMinimo, altoMaximo + 1);
        Tablero tablero = new Tablero(ancho, alto);
        TipoDeOrientacion orientacion = TipoDeOrientacion.values()[ThreadLocalRandom.current().nextInt(TipoDeOrientacion.values().length)];
        int posicionXCrucero;
        int posicionYCrucero;

        if (orientacion == TipoDeOrientacion.HORIZONTAL) {
            posicionXCrucero = ThreadLocalRandom.current().nextInt(0, ancho - 3 + 1);
            posicionYCrucero = ThreadLocalRandom.current().nextInt(0, alto - 1 + 1);
        } else {
            posicionXCrucero = ThreadLocalRandom.current().nextInt(0, ancho - 1 + 1);
            posicionYCrucero = ThreadLocalRandom.current().nextInt(0, alto - 3 + 1);
        }
        Crucero crucero = new Crucero(posicionXCrucero, posicionYCrucero, orientacion);
        try {
            tablero.agregarBarco(crucero);
        } catch (barcoFueraDelTableroException e) {
            System.out.println("testCreoUnCruceroEnUnaPosicionAleatoriaYDisparoEnLaPosicionCreadaYQueTodoLoDemasSeaAgua");
            e.printStackTrace();
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                if (orientacion == TipoDeOrientacion.HORIZONTAL) {
                    if ((y == posicionYCrucero) && (x == posicionXCrucero || x == posicionXCrucero + 1 || x == posicionXCrucero + 2)) {
                        if (x == posicionXCrucero + 2) {
                            try {
                                Assert.assertEquals(TipoDeCelda.HUNDIDO, tablero.dispararCelda(x, y));
                            } catch (coordenadaFueraDelTableroException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                Assert.assertEquals(TipoDeCelda.TOCADO, tablero.dispararCelda(x, y));
                            } catch (coordenadaFueraDelTableroException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        try {
                            Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                        } catch (coordenadaFueraDelTableroException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if ((x == posicionXCrucero) && (y == posicionYCrucero || y == posicionYCrucero + 1 || y == posicionYCrucero + 2)) {
                        if (y == posicionYCrucero + 2) {
                            try {
                                Assert.assertEquals(TipoDeCelda.HUNDIDO, tablero.dispararCelda(x, y));
                            } catch (coordenadaFueraDelTableroException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                Assert.assertEquals(TipoDeCelda.TOCADO, tablero.dispararCelda(x, y));
                            } catch (coordenadaFueraDelTableroException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        try {
                            Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
                        } catch (coordenadaFueraDelTableroException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }

    @Test(expected = barcoFueraDelTableroException.class)
    public void testCreoUnBoteFueraDelTableroYEsperoException() throws barcoFueraDelTableroException {
        int ancho = 1;
        int alto = 1;
        int posicionXBote = 1;
        int posicionYBote = 0;
        Tablero tablero = new Tablero(ancho, alto);
        Bote bote = new Bote(posicionXBote, posicionYBote);
        try {
            tablero.agregarBarco(bote);
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = barcoFueraDelTableroException.class)
    public void testCreoUnCruceroHorizontalFueraDelTableroYEsperoException() throws barcoFueraDelTableroException {
        int ancho = 3;
        int alto = 3;
        int posicionXCrucero = 1;
        int posicionYCrucero = 0;
        Tablero tablero = new Tablero(ancho, alto);
        TipoDeOrientacion orientacion = TipoDeOrientacion.HORIZONTAL;
        Crucero crucero = new Crucero(posicionXCrucero, posicionYCrucero, orientacion);
        try {
            tablero.agregarBarco(crucero);
        } catch (barcoSuperpuestoException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = coordenadaFueraDelTableroException.class)
    public void testVeoUnaCeldaFueraDelTableroYEsperoException() throws coordenadaFueraDelTableroException {
        int ancho = 10;
        int alto = 10;
        Tablero tablero = new Tablero(ancho, alto);
        tablero.verCelda(0, 10);
    }
    
    @Test(expected = barcoSuperpuestoException.class)
    public void testCreoDosBotesEnLaMismaCeldaYEsperoException() throws barcoSuperpuestoException {
        int ancho = 10;
        int alto = 10;
        int posicionXBote = 0;
        int posicionYBote = 0;
        Tablero tablero = new Tablero(ancho, alto);
        Bote bote = new Bote(posicionXBote, posicionYBote);
        Bote bote2 = new Bote(posicionXBote, posicionYBote);
        try {
            tablero.agregarBarco(bote);
            tablero.agregarBarco(bote2);
        } catch (barcoFueraDelTableroException e) {
            e.printStackTrace();
        }
        
    }
}
