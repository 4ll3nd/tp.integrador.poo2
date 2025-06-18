package ar.edu.unq.poo2.TpFinal;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventManagerZonaTest {

	private EventManagerZona eventManager;
	private Muestra muestra;
	private IObserverOrganizacion organizacion;
	private ZonaDeCobertura zona;
	
	@BeforeEach
	void setUp() throws Exception {
		
		eventManager = new EventManagerZona();
		organizacion = mock(IObserverOrganizacion.class);
		muestra = mock(Muestra.class);
		zona = mock(ZonaDeCobertura.class);
	}

	@Test
	void test_unEventManagerDeZonaSuscribeUnObserver() {
		
		eventManager.suscribir("Verificación", organizacion);
		
		verifyNoInteractions(organizacion);
	}
	
	@Test
	void test_unEventManagerDeZonaDesuscribeUnObserver() {
		
		eventManager.desuscribir("Verificación", organizacion);
		
		verifyNoInteractions(organizacion);
	}
	
	@Test
	void test_cuandoSucedeUnaVerificacion_ElEventManagerNotifica() {
				
		eventManager.suscribir("Verificación", organizacion);
		eventManager.suscribir("Verificación", organizacion);
		eventManager.suscribir("Verificación", organizacion);
		
		eventManager.notificar("Verificación", muestra, zona);
		
		verify(organizacion, times(3)).updateVerificacionDeMuestra(muestra, zona);
	}
	
	@Test
	void test_cuandoSucedeUnAgregado_ElEventManagerNotifica() {
				
		eventManager.suscribir("Agregado", organizacion);
		eventManager.suscribir("Agregado", organizacion);
		eventManager.suscribir("Agregado", organizacion);
		
		eventManager.notificar("Agregado", muestra, zona);
		
		verify(organizacion, times(3)).updateNuevaMuestra(muestra, zona);
	}

}
