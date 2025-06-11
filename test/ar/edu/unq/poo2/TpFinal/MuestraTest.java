package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {
	Muestra muestra;
	EspecieVinchuca infentans;
	Ubicacion ubicacion;
	LocalDate fechaDeSubida;
	IFoto foto;
	Opinion opinion;
	Opinion otraOpinion;
	Opinion opinionTres;
	ZonaDeCobertura zona;
	@BeforeEach
	void setUp() throws Exception {
		infentans = mock(EspecieVinchuca.class);
		ubicacion = mock(Ubicacion.class);
		fechaDeSubida = LocalDate.of(2002, 3, 12);
		foto = mock(IFoto.class);
		opinion = mock(Opinion.class);
		otraOpinion = mock(Opinion.class);
		opinionTres = mock(Opinion.class);
		muestra = new Muestra(infentans, ubicacion, fechaDeSubida, foto, opinion);
		zona = mock(ZonaDeCobertura.class);
	}

	@Test
	void testInicializacion() {
		when(opinion.getId()).thenReturn(123);
		assertEquals(infentans, muestra.getEspecie());
		assertEquals(ubicacion, muestra.getUbicacion());
		assertEquals(fechaDeSubida, muestra.getFechaDeSubida());
		assertEquals(1, muestra.getOpiniones().size());
		assertEquals(foto, muestra.getFoto());
		assertEquals(123, muestra.getId());
	}
	
	
	@Test
	void testSeAgregaUnaNuevaZonaDeCoberturaALaMuestra() {
		muestra.agregarZona(zona);
		
		assertEquals(1, muestra.getZonasDeCobertura().size());
	}
	
	/*
	 * @Test
	void testSeAgregaUnaNuevaOpinionALaMuestraEnEstadoNoVerificada() {
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		when(opinion.getOpinion()).thenReturn("Infectans");
		
		when(otraOpinion.getVoto()).thenReturn(Voto.VotoBasico);
		when(otraOpinion.getOpinion()).thenReturn("Poco Clara");
		
		muestra.agregarOpinion(otraOpinion);
		
		assertEquals(1, muestra.getOpiniones().size());
	}
	 * */
	
	
	@Test
	void testSeCalculaElResultadoDeUnaMuestraConVariasOpinionesDeUsuariosBasicos() {
		when(opinion.getOpinion()).thenReturn("Poco Clara");
		when(otraOpinion.getOpinion()).thenReturn("Poco Clara");
		when(opinionTres.getOpinion()).thenReturn("Infestans");
		
		muestra.agregarOpinion(opinion);
		muestra.agregarOpinion(otraOpinion);
		muestra.agregarOpinion(opinionTres);
		
		assertEquals("Poco Clara", muestra.resultadoActual());
	}
	
	@Test
	void testSeCalculaElResultadoActualDeUnaMuestraConUnaOpinionExperta() {
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		when(opinion.getOpinion()).thenReturn("Poco Clara");
		
		assertEquals("Poco Clara", muestra.resultadoActual());
	}
	
	@Test
	void testSeCalculaElResultadoActualDeUnaMuestraConTresOpinionesExpertas() {
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		when(opinion.getOpinion()).thenReturn("Infestans");
		
		when(otraOpinion.getVoto()).thenReturn(Voto.VotoExperto);
		when(otraOpinion.getOpinion()).thenReturn("Poco Clara");
		
		when(opinionTres.getOpinion()).thenReturn("Infestans");
		when(opinionTres.getVoto()).thenReturn(Voto.VotoExperto);
		
		muestra.agregarOpinion(otraOpinion);
		muestra.agregarOpinion(opinionTres);
		
		assertEquals("Infestans", muestra.resultadoActual());
	}
	
	@Test void testSeCalculaElResultadoActualDeUnaMuestraConOpinionesMixtas() {
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		when(opinion.getOpinion()).thenReturn("Infestans");
		
		when(otraOpinion.getVoto()).thenReturn(Voto.VotoExperto);
		when(otraOpinion.getOpinion()).thenReturn("Poco Clara");
		
		when(opinionTres.getOpinion()).thenReturn("Chinche Foliada");
		when(opinionTres.getVoto()).thenReturn(Voto.VotoBasico);
		
		muestra.agregarOpinion(otraOpinion);
		muestra.agregarOpinion(opinionTres);
		
		assertEquals("Infestans", muestra.resultadoActual());
	}
	
	/*
	 * @Test
	void testSeAgregaUnaOpinionDeUnExpertoYNoSeAgregaOtraOpinionDeUnBasico() {
		when(opinion.getVoto()).thenReturn(Voto.VotoExperto);
		when(opinion.getOpinion()).thenReturn("Poco Clara");
		
		when(otraOpinion.getVoto()).thenReturn(Voto.VotoBasico);
		when(otraOpinion.getOpinion()).thenReturn("Infectans");
		
		muestra.agregarOpinion(otraOpinion);
		
		assertEquals(1, muestra.getOpiniones().size());
	}
	
	 * */
	
}
