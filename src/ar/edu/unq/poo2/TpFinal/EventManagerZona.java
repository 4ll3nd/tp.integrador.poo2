package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventManagerZona {
	
	private HashMap<String, List<IObserverOrganizacion>> observers;
	
	public EventManagerZona() {
		
		initializeObservers();
	}
	
	
	private void initializeObservers() {
		
		observers = new HashMap<String, List<IObserverOrganizacion>>();
		observers.put("Verificación", new ArrayList<IObserverOrganizacion>());
		observers.put("Agregado", new ArrayList<IObserverOrganizacion>());
	}


	public void notificar(String event, Muestra muestra, ZonaDeCobertura zona) {
		
		if(event == "Verificación") {
			
			notificarVerificacionDeMuestra(event, muestra, zona);
		}
		else if(event == "Agregado") {
			
			notificarAgregadoDeMuestra(event, muestra, zona);
		}
		
	}

	private void notificarAgregadoDeMuestra(String event, Muestra muestra, ZonaDeCobertura zona) {
		
		getObservers().get(event).stream().forEach(unObserver -> unObserver.updateNuevaMuestra(muestra, zona));
	}


	private void notificarVerificacionDeMuestra(String event, Muestra muestra, ZonaDeCobertura zona) {
		
		getObservers().get(event).stream().forEach(unObserver -> unObserver.updateVerificacionDeMuestra(muestra, zona));
	}


	public void suscribir(String event, IObserverOrganizacion organizacion) {
		
		getObservers().get(event).add(organizacion);
	}


	private HashMap<String, List<IObserverOrganizacion>> getObservers() {
		
		return this.observers;
	}


	public void desuscribir(String event, IObserverOrganizacion organizacion) {
		
		getObservers().get(event).remove(organizacion);
	}

}
