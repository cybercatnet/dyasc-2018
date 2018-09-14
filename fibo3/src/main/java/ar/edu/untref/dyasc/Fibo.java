package ar.edu.untref.dyasc;

import java.util.ArrayList;

public class Fibo {

	ArrayList<Integer> lista = new ArrayList<Integer>();

	public Fibo(Configuracion configuracion) {
		calcularSerie(configuracion.cantidad());
	}

	public int obtenerSumatoria() {
		int sumatoria = 0;
		for (int item : this.lista) {
			sumatoria += item;
		}
		return sumatoria;
	}

	public ArrayList<Integer> obtenerSerie() {
		return this.lista;
	}

	private void calcularSerie(int cantidad) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(0);
		if (cantidad == 1) {
			this.lista = lista;
		}
		lista.add(1);
		if (cantidad == 2) {
			this.lista = lista;
		}
		for (int i = 2; i < cantidad; i++) {
			lista.add(lista.get(i - 1) + lista.get(i - 2));
		}

		this.lista = lista;
		;
	}
}
