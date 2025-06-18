package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.List;

public class EventManajer {

	private List<IObserverNuevaMuestra> observadores;

	public EventManajer() {
		observadores = new ArrayList<IObserverNuevaMuestra>();
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
