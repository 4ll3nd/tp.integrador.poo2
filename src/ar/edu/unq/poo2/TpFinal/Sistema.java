package ar.edu.unq.poo2.TpFinal;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Muestra> muestras;
	private EventManajer manejador;

	public Sistema() {
		muestras = new ArrayList<Muestra>();
		manejador= new EventManajer();
	}

	public void agregarMuestra(Muestra muestra, Participante participante) {
		muestras.add(muestra);
		
		manejador.notificar(muestra);
		
		participante.agregarMuestra(muestra);
	}

}
