package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoVerificadoTest {
	EstadoVerificado verificado;
	Muestra muestra;
	Opinion opinion;
	@BeforeEach
	void setUp() throws Exception {
		verificado = new EstadoVerificado();
		muestra = mock(Muestra.class);
		opinion = mock(Opinion.class);
	}

	@Test
	void testEstadoVerificadoNoAgregaNuevasOpiniones() {
		verificado.agregarOpinion(muestra, opinion);
		
		verify(muestra, never()).doAgregarOpinion(opinion);
	}

}
