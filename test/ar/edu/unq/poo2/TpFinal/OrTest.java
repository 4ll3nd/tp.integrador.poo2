package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OrTest {

	private Or operador;
	private Muestra muesMock1;
	private Muestra muesMock2;
	private Muestra muesMock3;
	private Muestra muesMock4;

	@BeforeEach
	void setUp() throws Exception {
		muesMock1 = mock(Muestra.class);
		muesMock2 = mock(Muestra.class);
		muesMock3 = mock(Muestra.class);
		muesMock4 = mock(Muestra.class);

		operador = new Or();
	}

	@Test
	void evaluarTestDiferentesElementos() {
		List<Muestra> listMerge = operador.evaluar(List.of(muesMock1, muesMock2), List.of(muesMock3, muesMock4));

		assertEquals(List.of(muesMock1, muesMock2, muesMock3, muesMock4), listMerge);
	}

	@Test
	void evaluarTestUnElementoIgual() {
		List<Muestra> listMerge = operador.evaluar(List.of(muesMock1, muesMock2), List.of(muesMock3, muesMock1));

		assertEquals(List.of(muesMock1, muesMock2, muesMock3), listMerge);
	}


}
