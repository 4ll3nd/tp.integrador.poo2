package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZonaDeCoberturaTest {
	private ZonaDeCobertura zone0;
	private Ubicacion ubiMock;
	private Ubicacion ubiMock2;
	private Muestra muestraMock;
	private ZonaDeCobertura zoneMock1;
	private EventManagerZona managerMock;
	private IObserverOrganizacion orgaMock;

	@BeforeEach
	void setUp() throws Exception {

		// Seteo de mocks
		muestraMock = mock(Muestra.class);
		zoneMock1 = mock(ZonaDeCobertura.class);

		// Mock de ubicaciones
		ubiMock2 = mock(Ubicacion.class);
		ubiMock = mock(Ubicacion.class);

		// Mock de Manager
		managerMock = mock(EventManagerZona.class);

		// Mock de organizacion
		orgaMock = mock(IObserverOrganizacion.class);

		// SUT Constructor
		zone0 = new ZonaDeCobertura("Quilmes", ubiMock, 700d);
	}

	@Test
	void testGetNombre() {
		assertEquals("Quilmes", zone0.getNombre());
	}

	@Test
	void testGetEpicentro() {
		assertEquals(ubiMock, zone0.getEpicentro());
	}

	@Test
	void testGetRadio() {
		assertEquals(700d, zone0.getRadio());
	}

	@Test
	void testMuestrasEnLaZonaRecienIniciada() {
		assertEquals(List.of(), zone0.getMuestras());
	}

	@Test
	void testAgregoUnaMuestraZonaNoCorrespondiente() {

		// seteo los mocks
		when(muestraMock.getUbicacion()).thenReturn(ubiMock2);
		when(ubiMock.distancia(ubiMock2)).thenReturn(800d);

		// lanzo el mensaje
		zone0.updateMuestra(muestraMock);

		// Verifico si reciben los mensajes
		verify(muestraMock).getUbicacion();
		verify(ubiMock).distancia(ubiMock2);

		// assert para saber si se agrego
		assertEquals(0, zone0.getMuestras().size());

	}

	@Test
	void testAgregoUnaMuestraZonaCorrespondiente() {
		// seteo los mocks
		when(muestraMock.getUbicacion()).thenReturn(ubiMock2);
		when(ubiMock.distancia(ubiMock2)).thenReturn(400d);

		// lanzo el mensaje
		zone0.updateMuestra(muestraMock);

		// Verifico si reciben los mensajes
		verify(muestraMock).getUbicacion();
		verify(ubiMock).distancia(ubiMock2);

		// assert para saber si se agrego
		assertEquals(1, zone0.getMuestras().size());
	}

	@Test
	void testZonasSolapadas0Zonas() {
		// SetUp
		when(zoneMock1.getEpicentro()).thenReturn(ubiMock2);
		when(ubiMock2.distancia(ubiMock)).thenReturn(711d);
		when(zoneMock1.getRadio()).thenReturn(10d);

		// Excercise
		List<ZonaDeCobertura> zonas = zone0.zonasSolapadas(List.of(zoneMock1));

		// Verify

		assertEquals(List.of(), zonas);
	}

	@Test
	void testZonasSolapadas1Zona() {
		// SetUp
		when(zoneMock1.getEpicentro()).thenReturn(ubiMock2);
		when(ubiMock2.distancia(ubiMock)).thenReturn(400d);
		when(zoneMock1.getRadio()).thenReturn(10d);

		// Excercise
		List<ZonaDeCobertura> zonas = zone0.zonasSolapadas(List.of(zoneMock1));

		// Verify

		assertEquals(List.of(zoneMock1), zonas);
	}

	@Test
	void test_cuandoSeAgregaUnaMuestra_SeNotificaALosObservers() {

		when(muestraMock.getUbicacion()).thenReturn(ubiMock2);
		when(ubiMock.distancia(ubiMock2)).thenReturn(400d);

		zone0.updateMuestra(muestraMock);

		verify(muestraMock).agregarZona(zone0);
	}
	
	
	void setearYSuscribirA(String evento, IObserverOrganizacion obs) {
		zone0.setManager(managerMock);
		zone0.suscribir(evento, obs);
	}	
	@Test
	void suscribirEnZonaTest() {
		// Seteo el mock de manager
		
		this.setearYSuscribirA("Verificación", orgaMock);
		verify(managerMock, times(1)).suscribir("Verificación", orgaMock);
	}
	
	@Test
	void deSuscribirEnZonaTest() {
		this.setearYSuscribirA("Verificación", orgaMock);
		
		zone0.desuscribir("Verificación", orgaMock);
		
		verify(managerMock, times(1)).desuscribir("Verificación", orgaMock);
	}
	
	@Test
	void updateMuestraVerificadaTest() {
		this.setearYSuscribirA("Verificación", orgaMock);
		
		zone0.updateMuestraVerificada(muestraMock);
		
		
		verify(managerMock, times(1)).notificar("Verificación", muestraMock, zone0);
	}
}
