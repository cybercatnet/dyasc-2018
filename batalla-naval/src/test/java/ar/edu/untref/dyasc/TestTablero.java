package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class TestTablero {

    @Test
	public void testCreoTableroVacioYVerificoQueTodosLasCeldasSonAgua() {
		int ancho = 10;
		int alto = 10;
	    Tablero tablero = new Tablero(ancho,alto);
		for(int x=0;x<ancho;x++) {
		    for(int y=0;y<alto;y++) {
	            Assert.assertEquals(TipoDeCelda.AGUA, tablero.verCelda(x, y));
		    }
		}
	}
}
