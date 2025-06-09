package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadoStandByTest {
	EstadoStandBy standBy;
	Muestra muestra;
	Opinion opinion;
	Opinion opinionVinchuca;
	Opinion opinionPocoClara;
	@BeforeEach
	void setUp() throws Exception {
		muestra = mock(Muestra.class);
		standBy = new EstadoStandBy();
		opinion = mock(Opinion.class);
		opinionVinchuca = mock(Opinion.class);
		opinionPocoClara = mock(Opinion.class);
	}

	@Test
	void testEstadoStandByAgregaUnaOpinionDeUnExpertoQueNoEsIgualANingunaQueTeniaLaMuestrea() {
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		when(muestra.getOpiniones()).thenReturn(Arrays.asList(opinionVinchuca, opinionPocoClara));
		when(opinionVinchuca.getOpinion()).thenReturn("Vinchuca");
		when(opinionPocoClara.getOpinion()).thenReturn("Poco Clara");
		when(opinion.getOpinion()).thenReturn("Infestans");
		
		standBy.agregarOpinion(muestra, opinion);
		
		verify(muestra).doAgregarOpinion(opinion);
	}
	
	@Test
	void testEstadoStandByAgregaUnaOpinionDeUnParticipanteExpertoQueEsIgualAlQueTieneLaMuestraYCambiaAVerificada() {
		when(muestra.getOpiniones()).thenReturn(Arrays.asList(opinionVinchuca, opinionPocoClara));
		when(opinionVinchuca.getOpinion()).thenReturn("Vinchuca");
		when(opinionPocoClara.getOpinion()).thenReturn("Poco Clara");
		when(opinion.getOpinion()).thenReturn("Poco Clara");
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		
		standBy.agregarOpinion(muestra, opinion);
		
		verify(muestra).doAgregarOpinion(opinion);
	}
	
	@Test
	void testEstadoStandByNoAgregaUnaOpiniondeUnBasico() {
		when(opinion.getVoto()).thenReturn(Voto.VotoBasico);
		
		standBy.agregarOpinion(muestra, opinion);
		
		verify(muestra, never()).doAgregarOpinion(opinion);
	}
}
