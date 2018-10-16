package ar.edu.untref.dyasc;

import java.util.ArrayList;

public class Tablero {
	ArrayList<Barco> barcos = new ArrayList<Barco>();
	int ancho = 0;
	int alto = 0;
	public Tablero(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public TipoDeCelda verCelda(int x, int y) {
	    for (Barco barco : this.barcos) {
	        if(barco.contiene(x,y)){
	            
	        }
	    }
	    return TipoDeCelda.AGUA;
	    
	}
}
