package ar.edu.unq.poo2.TpFinal;

import java.util.List;

public class Ubicacion {

	private int latitud;
	private int longitud;

	public Ubicacion(int lat, int lon) {
		this.latitud = lat;
		this.longitud = lon;
	}

	public double distancia(Ubicacion ubi) {
		double calculaX = ubi.getLatitud() - this.getLatitud();// Esto podria ir dentro del return
		double calculaY = ubi.getLongitud() - this.getLongitud(); // Lo hice para la legibilidad.

		double xAlCuadrado = calculaX * calculaX;
		double yAlCuadrado = calculaY * calculaY;

		return Math.sqrt(xAlCuadrado + yAlCuadrado);// x*x = x^2
	}

	// Getters Methods

	public int getLatitud() {
		return latitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public List<Ubicacion> ubicacionesA(double km, List<Ubicacion> list) {
		return list.stream().filter(u -> this.distancia(u) <= km).toList();
	}

}
