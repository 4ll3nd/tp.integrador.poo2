package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura implements IObserver {

	private String nombre;
	private Ubicacion epicentro;
	private double radio;
	private List<Muestra> muestras;

	public ZonaDeCobertura(String nombre, Ubicacion epicentro, double radio) {
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestras = new ArrayList<Muestra>();
	}

	public String getNombre() {
		return nombre;
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public double getRadio() {
		return radio;
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void agregarMuestra(Muestra muestra) {
		if (this.estaEnZona(muestra)) {
			muestras.add(muestra);
		}
		
	}

	private boolean estaEnZona(Muestra muestra) {
		
		return epicentro.distancia( muestra.getUbicacion()) <= this.radio;
	}

}
