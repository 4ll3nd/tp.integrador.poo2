package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	private Sistema sys;
	private Muestra muestraMock1;
	private Participante participanteMock1;
	private IObserverNuevaMuestra obsMock;

	@BeforeEach
	void setUp() throws Exception {
		
		//SUT setUp
		sys= new Sistema();
		
		//Mock setUp
		participanteMock1 = mock(Participante.class);
		muestraMock1 = mock(Muestra.class);
		obsMock = mock(IObserverNuevaMuestra.class);
	}

	@Test
	void agregoMuestraTest() {
		sys.agregarMuestra(muestraMock1,participanteMock1);
		
		verify(participanteMock1).agregarMuestra(muestraMock1);
	}
	
	@Test
	void SuscribirYNotificaAlobservadorTest() {
		// Este test debe de notificar a los obs que se hayan suscritos al evento.
		//Suscribo desde este test al obsMock
		
		sys.suscribir(obsMock);
		

		sys.notificar(muestraMock1);

		verify(obsMock, times(1)).updateMuestra(muestraMock1);
	}

	@Test
	void DesuscribirYNotificarANadieTest() {
		//Sucribir primero al observador
		sys.suscribir(obsMock);
		// Desuscribe al obs y luego envia el notificar
		sys.deSuscribir(obsMock);

		sys.notificar(muestraMock1);

		verify(obsMock, never()).updateMuestra(muestraMock1);
	}

}
