package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Muestra> muestras;
	private List<IObserverNuevaMuestra> observadores;

	public Sistema() {
		muestras = new ArrayList<Muestra>();
		observadores = new ArrayList<IObserverNuevaMuestra>();
	}

	public void agregarMuestra(Muestra muestra, Participante participante) {
		muestras.add(muestra);

		this.notificar(muestra);

		participante.agregarMuestra(muestra);
	}

	public void suscribir(IObserverNuevaMuestra observador) {
		observadores.add(observador);

	}

	public void notificar(Muestra muestra) {
		observadores.stream().forEach(obs -> obs.updateMuestra(muestra));

	}

	public void deSuscribir(IObserverNuevaMuestra observador) {
		observadores.remove(observador);

	}

}
