package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura implements IObserverNuevaMuestra, IObserverMuestraVerificada {

	private String nombre;
	private Ubicacion epicentro;
	private double radio;
	private List<Muestra> muestras;
	private EventManagerZona eventManagerZona;

	public ZonaDeCobertura(String nombre, Ubicacion epicentro, double radio) {
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestras = new ArrayList<Muestra>();
		this.eventManagerZona = new EventManagerZona();
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

	@Override
	public void updateMuestra(Muestra muestra) {
		
		if (this.estaEnZona(muestra)) {
			
			muestras.add(muestra);
			notificarAgregadoDe(muestra);
			muestra.agregarZona(this);
		}
		
	}

	private void notificarAgregadoDe(Muestra muestra) {
		
		this.eventManagerZona.notificar("Agregado", muestra, this);
	}
	
	@Override
	public void updateMuestraVerificada(Muestra muestra) {
		
		this.eventManagerZona.notificar("Verificación", muestra, this);
	}

	
	private boolean estaEnZona(Muestra muestra) {
		
		return epicentro.distancia( muestra.getUbicacion()) <= this.radio;
	}

	public List<ZonaDeCobertura> zonasSolapadas(List<ZonaDeCobertura> listaDeZonas) {
		
		return listaDeZonas.stream().filter(z -> this.estaSolapada(z)).toList();
	}

	private boolean estaSolapada(ZonaDeCobertura z) {
		
		return z.getEpicentro().distancia(this.epicentro) <= this.radio + z.getRadio();
	}

	public void suscribir(String event, IObserverOrganizacion organizacion) {
		
		this.eventManagerZona.suscribir(event, organizacion);
	}
	
	public void desuscribir(String event, IObserverOrganizacion organizacion) {
		
		this.eventManagerZona.desuscribir(event, organizacion);
	}
}
