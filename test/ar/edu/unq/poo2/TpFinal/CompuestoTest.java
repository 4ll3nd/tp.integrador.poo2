package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompuestoTest {
	private Compuesto filtroMain;
	private Filtro filtroMock1;
	private Filtro filtroMock2;
	private Operador opeMock1;
	private Muestra muesMock1;
	private Muestra muesMock2;
	private Muestra muesMock3;
	private List<Muestra> muestras;

	@BeforeEach
	void setUp() throws Exception {
		// SetUp de mocks
		filtroMock1 = mock(Filtro.class);
		filtroMock2 = mock(Filtro.class);
		opeMock1 = mock(Operador.class);
		muesMock1 = mock(Muestra.class);
		muesMock2 = mock(Muestra.class);
		muesMock3 = mock(Muestra.class);

		// setUp Main
		filtroMain = new Compuesto(filtroMock1, filtroMock2, opeMock1);

		// setUpList

		muestras = List.of(muesMock1, muesMock2, muesMock3);

	}

	@Test
	void filtrartodasValidasTest() {
		when(filtroMock1.filtrar(muestras)).thenReturn(muestras);
		when(filtroMock2.filtrar(muestras)).thenReturn(muestras);
		when(opeMock1.evaluar(muestras, muestras)).thenReturn(muestras);

		List<Muestra> nuevaList = filtroMain.filtrar(muestras);

		//Verify
		verify(filtroMock1).filtrar(muestras);
		verify(filtroMock2).filtrar(muestras);
		verify(opeMock1).evaluar(muestras, muestras);

		
		assertEquals(muestras, nuevaList);
		
	}

	@Test
	void filtrarNingunaValidaTest() {

		when(filtroMock1.filtrar(muestras)).thenReturn(List.of(muesMock1, muesMock2));
		when(filtroMock2.filtrar(muestras)).thenReturn(List.of(muesMock3));
		when(opeMock1.evaluar(List.of(muesMock1, muesMock2), List.of(muesMock3))).thenReturn(List.of());
		
		List<Muestra> nuevaList = filtroMain.filtrar(muestras);
		
		//Verify
		verify(filtroMock1).filtrar(muestras);
		verify(filtroMock2).filtrar(muestras);
		verify(opeMock1).evaluar(List.of(muesMock1, muesMock2), List.of(muesMock3));
		
		assertEquals(List.of(), nuevaList);
		
	}

}