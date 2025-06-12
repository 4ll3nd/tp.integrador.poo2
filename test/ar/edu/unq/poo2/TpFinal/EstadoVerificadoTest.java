package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoVerificadoTest {
	EstadoVerificado verificado;
	Muestra muestra;
	Opinion opinion;
	Opinion opinionDos;
	Opinion opinionTres;
	Opinion opinionCuatro;
	@BeforeEach
	void setUp() throws Exception {
		verificado = new EstadoVerificado();
		muestra = mock(Muestra.class);
		opinion = mock(Opinion.class);
		opinionDos = mock(Opinion.class);
		opinionTres = mock(Opinion.class);
		opinionCuatro = mock(Opinion.class);
	}

	@Test
	void testEstadoVerificadoNoAgregaNuevasOpiniones() {
		verificado.agregarOpinion(muestra, opinion);
		
		verify(muestra, never()).doAgregarOpinion(opinion);
	}
	
	@Test
	void testSeCalculaElResultadoActualEnElEstadoVerificado() {
		when(muestra.getOpiniones()).thenReturn(Arrays.asList(opinion, opinionDos, opinionTres, opinionCuatro));
		
		when(opinion.getOpinion()).thenReturn("Chinche Foliada");
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		
		when(opinionTres.getOpinion()).thenReturn("Infestans");
		when(opinionTres.getVoto()).thenReturn(Voto.VotoExperto);
		
		when(opinionDos.getOpinion()).thenReturn("Chinche Foliada");
		when(opinionDos.getVoto()).thenReturn(Voto.VotoExperto);
		
		when(opinionCuatro.getOpinion()).thenReturn("Poco Clara");
		when(opinionCuatro.getVoto()).thenReturn(Voto.VotoBasico);
		
		assertEquals("Chinche Foliada", verificado.resultadoActual(muestra));
	}
}
