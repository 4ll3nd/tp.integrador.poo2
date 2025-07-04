package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoNoVerificadoTest {
	EstadoNoVerificado noVerificado;
	Muestra muestra;
	Opinion opinion;
	Opinion opinionDos;
	Opinion opinionTres;
	EspecieVinchuca infestans;
	@BeforeEach
	void setUp() throws Exception {
		muestra = mock(Muestra.class);
		noVerificado = new EstadoNoVerificado();
		opinion = mock(Opinion.class);
		opinionDos = mock(Opinion.class);
		opinionTres = mock(Opinion.class);
		infestans = mock(Infestans.class);
	}

	@Test
	void testSeAgregaUnaOpinionDeUnParticipanteBasico() {
		when(opinion.getVoto()).thenReturn(Voto.VotoDeExperto);
		noVerificado.agregarOpinion(muestra, opinion);
		
		verify(muestra).doAgregarOpinion(opinion);
	}
	
	//duda: se verifica realmente el cambio de estado.
	@Test
	void testSeAgregaUnaOpinionDeUnExpertoYLaMuestraCambiaDeEstadoAStandBy() {
		when(opinion.getVoto()).thenReturn(Voto.VotoDeExperto);
		noVerificado.agregarOpinion(muestra, opinion);
		
		verify(muestra).doAgregarOpinion(opinion);;
	}
	
	@Test
	void testSeCalculaElResultadoActualEnElEstadoNoVerificado() {
		when(muestra.getEspecie()).thenReturn(infestans);
		when(infestans.getNombre()).thenReturn("Infestans");
		when(muestra.getOpiniones()).thenReturn(Arrays.asList(opinion, opinionTres));
		when(opinion.getOpinion()).thenReturn("Poco Clara");
		when(opinionTres.getOpinion()).thenReturn("Infestans");
		
		assertEquals("Infestans", noVerificado.resultadoActual(muestra));
	}
	
	@Test
	void testSeCalculaElResultadoActualYEsUnoNoEsperado() {
		when(muestra.getEspecie()).thenReturn(infestans);
		when(infestans.getNombre()).thenReturn("Infestans");
		
		when(muestra.getOpiniones()).thenReturn(Arrays.asList(opinion, opinionTres));
		when(opinion.getOpinion()).thenReturn("Poco Clara");
		when(opinionTres.getOpinion()).thenReturn("Poco Clara");
		
		assertNotEquals("Infestans", noVerificado.resultadoActual(muestra));
	}
}
