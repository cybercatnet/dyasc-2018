package ar.edu.untref.dyasc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Salida {
	private Configuracion configuracion;

	public Salida(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	private void imprimirArchivo(String salida) {
		try {
			String rutaArchivo = configuracion.rutaArchivo();
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaArchivo));

			bufferedWriter.write(salida);
			bufferedWriter.close();

			int cantidad = this.configuracion.cantidad();
			System.out.print("fibo<" + cantidad + "> guardado en " + rutaArchivo);
		} catch (IOException ex) {
			// System.out.println("Error writing to file '" + this.archivo + "'");
		}
	}

	public void imprimir(int sumatoria) {
		String salida = "";
		String separador = (configuracion.isOpcionHorizontal()) ? "" : "\n";

		int cantidad = this.configuracion.cantidad();
		salida += "fibo<" + cantidad + ">s: " + sumatoria + separador;

		if (configuracion.isSalidaArchivo()) {
			imprimirArchivo(salida);
		} else {
			System.out.print(salida);
		}
	}

	public void imprimir(ArrayList<Integer> lista) {
		String salida = "";
		String separadorHorizontal = (configuracion.isOpcionHorizontal()) ? " " : "";
		String separadorVertical = (!configuracion.isOpcionHorizontal()) ? "\n" : "";
		if (!configuracion.isOpcionDirecta()) {
			Collections.reverse(lista);
		}

		int cantidad = this.configuracion.cantidad();

		salida += "fibo<" + cantidad + ">:" + separadorVertical;
		for (int i = 0; i < cantidad; i++) {
			salida += separadorHorizontal + lista.get(i) + separadorVertical;
		}

		if (configuracion.isSalidaArchivo()) {
			imprimirArchivo(salida);
		} else {
			System.out.print(salida);
		}
	}

}
