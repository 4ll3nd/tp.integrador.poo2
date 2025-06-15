package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	private Sistema sys;
	private Muestra muestraMock1;
	private Participante participanteMock1;

	@BeforeEach
	void setUp() throws Exception {
		
		//SUT setUp
		sys= new Sistema();
		
		//Mock setUp
		participanteMock1 = mock(Participante.class);
		muestraMock1 = mock(Muestra.class);
	}

	@Test
	void agregoMuestraTest() {
		sys.agregarMuestra(muestraMock1,participanteMock1);
		
		verify(participanteMock1).agregarMuestra(muestraMock1);
	}

}
