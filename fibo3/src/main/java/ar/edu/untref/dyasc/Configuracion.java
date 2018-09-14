package ar.edu.untref.dyasc;

import java.util.Arrays;
import java.util.List;

public class Configuracion {
	private String rutaArchivo = null;
	private int cantidad = 0;
	private String opcion = "hd";
	private String modo = "l";
	private static List<String> valoresPosiblesOpcion = Arrays.asList("hd", "hi", "vd", "vi");
	private static List<String> valoresPosiblesModo = Arrays.asList("l", "s");

	public Configuracion(String[] args) {
		try {
			for (String argumento : args) {
				if (argumento.contains("-")) {
					String[] partes = argumento.split("=");
					String parametro = partes[0].substring(1);
					String valor = partes[1];
					switch (parametro) {
					case "o":
						if (!configuracionAprobada(valor, valoresPosiblesOpcion)) {
							throw new OpcionNoValidaException("Opción no válida");
						}
						this.opcion = valor;
						break;
					case "m":
						if (!configuracionAprobada(valor, valoresPosiblesModo)) {
							throw new OpcionNoValidaException("Opción no válida");
						}
						this.modo = valor;
						break;
					case "f":
						this.rutaArchivo = valor;
						break;
					default:
						break;
					}
				} else {
					this.cantidad = Integer.parseInt(argumento);
				}
			}
		} catch (OpcionNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}


	private boolean configuracionAprobada(String parametro, List<String> parametrosCorrectos) {
		return false;
	}

	public String rutaArchivo() {
		return rutaArchivo;
	}

	public int cantidad() {
		return cantidad;
	}

	public String opcion() {
		return opcion;
	}

	public String modo() {
		return modo;
	}
}
