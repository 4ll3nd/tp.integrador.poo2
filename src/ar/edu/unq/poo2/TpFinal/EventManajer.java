package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.List;

public class EventManajer {

	private List<IObserver> observadores;

	public EventManajer() {
		observadores = new ArrayList<IObserver>();
	}

	public void suscribir(IObserver observador) {
		observadores.add(observador);

	}

	public void notificar(Muestra muestra) {
		observadores.stream().forEach(obs -> obs.agregarMuestra(muestra));

	}

	public void deSuscribir(IObserver observador) {
		observadores.remove(observador);

	}

}
