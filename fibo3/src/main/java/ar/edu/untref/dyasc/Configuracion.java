package ar.edu.untref.dyasc;

import java.util.Arrays;
import java.util.List;

public class Configuracion {
	private String rutaArchivo = null;
	private int cantidad = 0;
	private boolean modoLista = true;
	private boolean opcionHorizontal = true;
	private boolean opcionDirecta = true;
	private boolean salidaArchivo = false;
	private static List<String> valoresPosiblesOpcion = Arrays.asList("hd", "hi", "vd", "vi");
	private static List<String> valoresPosiblesModo = Arrays.asList("l", "s");

	public Configuracion(String[] args) {
		try {
			for (String argumento : args) {
				if (argumento.substring(0, 1).equals("-")) {
					String[] partes = argumento.split("=");
					String parametro = partes[0].substring(1);
					String valor = partes[1];
					switch (parametro) {
					case "o":
						if (!configuracionAprobada(valor, valoresPosiblesOpcion)) {
							throw new OpcionNoValidaException("Opción no válida");
						}
						this.opcionHorizontal = valor.substring(0, 1).equals("h");
						this.opcionDirecta = valor.substring(1).equals("d");
						break;
					case "m":
						if (!configuracionAprobada(valor, valoresPosiblesModo)) {
							throw new OpcionNoValidaException("Opción no válida");
						}
						this.modoLista = valor.equals("l");
						break;
					case "f":
						this.rutaArchivo = valor;
						this.salidaArchivo = true;
						break;
					default:
						throw new OpcionNoValidaException("Opción no válida");
					}
				} else {
					this.cantidad = Integer.parseInt(argumento);
				}
			}
		} catch (OpcionNoValidaException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	private boolean configuracionAprobada(String valor, List<String> parametrosCorrectos) {
		for (String parametro : parametrosCorrectos) {
			if (parametro.contains(valor)) {
				return true;
			}
		}
		return false;
	}

	public String rutaArchivo() {
		return rutaArchivo;
	}

	public int cantidad() {
		return cantidad;
	}

	public boolean isModoLista() {
		return modoLista;
	}

	public boolean isOpcionHorizontal() {
		return opcionHorizontal;
	}

	public boolean isOpcionDirecta() {
		return opcionDirecta;
	}

	public boolean isSalidaArchivo() {
		return salidaArchivo;
	}

}
