package tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.glassfish.grizzly.utils.Pair;

import Barco.Barco;
import Tipos.TipoDeCelda;

public class Tablero {
    private ArrayList<Barco> barcos = new ArrayList<Barco>();
    private int ancho = 0;
    private int alto = 0;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    private void verificarBarcoDentroDelTablero(Barco barco) throws barcoFueraDelTableroException {
        if ((barco.getPosicionX() < 0) || (barco.getPosicionY() < 0) || ((barco.getPosicionX() + barco.getAncho()) > this.ancho) || ((barco.getPosicionY() + barco.getAlto()) > this.alto)) {
            throw new barcoFueraDelTableroException();
        }
    }

    private void verificarBarcoNoSuperpuesto(Barco barco) throws barcoSuperpuestoException {
        List<Pair<Integer, Integer>> celdasOcupadasBarco = getCeldasOcupadas(barco);

        for (Pair<Integer, Integer> par : celdasOcupadasBarco) {
            for (Barco barcoo : this.barcos) {
                if (barcoo.contiene(par.getFirst(), par.getSecond())) {
                    throw new barcoSuperpuestoException();
                }
            }
        }
    }

    private void verificarCoordenadaDentroDelTablero(int x, int y) throws coordenadaFueraDelTableroException {
        if ((x < 0) || (y < 0) || (x > this.ancho - 1) || (y > this.alto - 1)) {
            throw new coordenadaFueraDelTableroException();
        }
    }

    public List<Pair<Integer, Integer>> getCeldasOcupadas(Barco barco) {
        List<Pair<Integer, Integer>> celdasOcupadasBarco = new ArrayList<Pair<Integer, Integer>>();

        IntStream.range(barco.getPosicionX(), barco.getAncho()).forEach(x -> {
            IntStream.range(barco.getPosicionY(), barco.getAlto()).forEach(y -> {
                celdasOcupadasBarco.add(new Pair<Integer, Integer>(x, y));
            });
        });
        return celdasOcupadasBarco;
    }

    public void agregarBarco(Barco barco) throws barcoFueraDelTableroException, barcoSuperpuestoException {

        verificarBarcoDentroDelTablero(barco);

        verificarBarcoNoSuperpuesto(barco);

        this.barcos.add(barco);

    }

    public TipoDeCelda verCelda(int x, int y) throws coordenadaFueraDelTableroException {
        verificarCoordenadaDentroDelTablero(x, y);

        for (Barco barco : this.barcos) {
            if (barco.contiene(x, y)) {
                return barco.verCelda(x, y);
            }
        }
        return TipoDeCelda.AGUA;
    }

    public Object dispararCelda(int x, int y) throws coordenadaFueraDelTableroException {
        verificarCoordenadaDentroDelTablero(x, y);

        for (Barco barco : this.barcos) {
            if (barco.contiene(x, y)) {
                return barco.dispararCelda(x, y);
            }
        }
        return TipoDeCelda.AGUA;
    }
}
