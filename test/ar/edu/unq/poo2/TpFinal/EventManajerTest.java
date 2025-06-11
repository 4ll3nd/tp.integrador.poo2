package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventManajerTest {
	private EventManajer event1;
	private IObserver obsMock;
	private Muestra muesMock;

	@BeforeEach
	void setUp() throws Exception {

		event1 = new EventManajer();

		obsMock = mock(IObserver.class);

		// Suscribimos al obs
		event1.suscribir(obsMock);
	}

	@Test
	void NotificaAlobservadorTest() {
		// Este test debe de notificar a los obs que se hayan suscritos al evento.

		event1.notificar(muesMock);

		verify(obsMock, times(1)).agregarMuestra(muesMock);
	}

	@Test
	void NotificarANadieTest() {
		// Desuscribe al obs y luego envia el notificar
		event1.deSuscribir(obsMock);

		event1.notificar(muesMock);

		verify(obsMock, never()).agregarMuestra(muesMock);
	}

}
