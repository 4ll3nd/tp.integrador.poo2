package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UbicacionTest {
	private Ubicacion ubiMain;
	private Ubicacion ubiMock1;
	private Ubicacion ubiMock2;
	private Ubicacion ubiMock3;
	private List<Ubicacion> listaDeUbi;

	@BeforeEach
	void setUp() throws Exception {

		// SUT
		ubiMain = new Ubicacion(133, 400);

		// MOCK SET
		ubiMock1 = mock(Ubicacion.class);
		ubiMock2 = mock(Ubicacion.class);
		ubiMock3 = mock(Ubicacion.class);
	}

	@Test
	void distanciaEntreDosUbicacionesTest() {

		// Configure Mock
		when(this.ubiMock1.getLatitud()).thenReturn(200);
		when(this.ubiMock1.getLongitud()).thenReturn(1000);

		// Exercise
		double distanciaTotal = ubiMain.distancia(ubiMock1);

		//
		double distanciaRedondeada = Math.round(distanciaTotal);

		// Verify
		verify(ubiMock1).getLongitud();
		verify(ubiMock1).getLatitud();
		assertEquals(604d, distanciaRedondeada);
	}

	@Test
	void getterLatitudTest() {
		assertEquals(133, ubiMain.getLatitud());
	}

	@Test
	void getterLongitudTest() {
		assertEquals(400, ubiMain.getLongitud());
	}

	@Test
	void ubicacionesADistancia0UbicacionesTest() {
		this.setearMetodosMock();

		List<Ubicacion> listaDeUbi = List.of(ubiMock1, ubiMock2, ubiMock3);

		List<Ubicacion> result = ubiMain.ubicacionesA(300d, listaDeUbi);

		assertEquals(List.of(), result);
	}

	void setearMetodosMock() {
		when(this.ubiMock1.getLatitud()).thenReturn(200);
		when(this.ubiMock1.getLongitud()).thenReturn(1000);

		when(this.ubiMock2.getLatitud()).thenReturn(225);
		when(this.ubiMock2.getLongitud()).thenReturn(1000);

		when(this.ubiMock3.getLatitud()).thenReturn(215);
		when(this.ubiMock3.getLongitud()).thenReturn(1000);
	}

	@Test
	void ubicacionesADistanciaTodasLasUbicacionesTest() {
		this.setearMetodosMock();
		
		List<Ubicacion> listaDeUbi = List.of(ubiMock1, ubiMock2, ubiMock3);

		List<Ubicacion> result = ubiMain.ubicacionesA(1000d, listaDeUbi);
		
		assertEquals(List.of(ubiMock1, ubiMock2, ubiMock3), result);
	}

}
