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

	public void agregarMuestra(Muestra muestraMock1, Participante participanteMock1) {
		muestras.add(muestraMock1);
		
		manejador.notificar(muestraMock1);
		
		participanteMock1.agregarMuestra(muestraMock1);
		
		

	}

}
