package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
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
	Participante participante; 
	ITipoDeOpinion tipoDeOpinion;
	@BeforeEach
	void setUp() throws Exception {
		infentans = mock(EspecieVinchuca.class);
		ubicacion = mock(Ubicacion.class);
		fechaDeSubida = LocalDate.of(2002, 3, 12);
		foto = mock(IFoto.class);
		opinion = mock(Opinion.class);
		otraOpinion = mock(Opinion.class);
		opinionTres = mock(Opinion.class);
		participante = mock(Participante.class);
		tipoDeOpinion = mock(ITipoDeOpinion.class);
		when(participante.getId()).thenReturn(123);
		muestra = new Muestra(infentans, ubicacion, fechaDeSubida, foto, participante);
		zona = mock(ZonaDeCobertura.class);
	}

	@Test
	void testInicializacion() {
		assertEquals(infentans, muestra.getEspecie());
		assertEquals(ubicacion, muestra.getUbicacion());
		assertEquals(fechaDeSubida, muestra.getFechaDeSubida());
		assertEquals(foto, muestra.getFoto());
		assertEquals(123, muestra.getId());	
	}
	
	@Test
	void testSeAgregaUnaNuevaZonaDeCoberturaALaMuestra() {
		muestra.agregarZona(zona);
		
		assertEquals(1, muestra.getObserverVerificacion().size());
	}
	
	@Test
	void testSeAgregaUnaNuevaOpinionALaMuestraEnEstadoNoVerificada() {
		when(opinion.getVoto()).thenReturn(Voto.VotoDeExperto);
		when(opinion.getOpinion()).thenReturn("Infectans");
		
		muestra.agregarOpinion(opinion);
		
		assertEquals(1, muestra.getOpiniones().size());
	}
	
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
	void testSeCalculaElResultadoActualDeUnaMuestraConUnaOpinion() {
		when(infentans.getNombre()).thenReturn("Infestans");
		
		assertEquals("Infestans", muestra.resultadoActual());
	}
	
	@Test
	void testSeCalculaElResultadoActualDeUnaMuestraConTresOpinionesExpertas() {
		when(opinion.getVoto()).thenReturn(Voto.VotoDeExperto);
		when(opinion.getOpinion()).thenReturn("Infestans");
		
		when(otraOpinion.getVoto()).thenReturn(Voto.VotoDeExperto);
		when(otraOpinion.getOpinion()).thenReturn("Poco Clara");
		
		when(opinionTres.getOpinion()).thenReturn("Infestans");
		when(opinionTres.getVoto()).thenReturn(Voto.VotoDeExperto);
		
		muestra.agregarOpinion(opinion);
		muestra.agregarOpinion(otraOpinion);
		muestra.agregarOpinion(opinionTres);
		
		assertEquals("Infestans", muestra.resultadoActual());
	}
	
	@Test void testSeCalculaElResultadoActualDeUnaMuestraConOpinionesMixtas() {
		when(infentans.getNombre()).thenReturn("Infestans");
		when(tipoDeOpinion.getOpinion()).thenReturn("Infestans");
		
		when(opinion.getVoto()).thenReturn(Voto.VotoDeExperto);
		when(opinion.getOpinion()).thenReturn("Infestans");
		
		when(otraOpinion.getVoto()).thenReturn(Voto.VotoDeExperto);
		when(otraOpinion.getOpinion()).thenReturn("Poco Clara");
		
		when(opinionTres.getOpinion()).thenReturn("Chinche Foliada");
		when(opinionTres.getVoto()).thenReturn(Voto.VotoDeBasico);
		
		muestra.agregarOpinion(opinion);
		muestra.agregarOpinion(otraOpinion);
		muestra.agregarOpinion(opinionTres);
		
		assertEquals("Infestans", muestra.resultadoActual());
	}
	
	@Test
	void testSeAgregaUnaOpinionDeUnExpertoYNoSeAgregaOtraOpinionDeUnBasico() {
		when(opinion.tieneVoto(Voto.VotoDeExperto)).thenReturn(true);
		when(opinion.getOpinion()).thenReturn("Poco Clara");
		
		when(otraOpinion.getVoto()).thenReturn(Voto.VotoDeBasico);
		when(otraOpinion.getOpinion()).thenReturn("Infectans");
		
		muestra.agregarOpinion(opinion);
		muestra.agregarOpinion(otraOpinion);
		
		assertEquals(1, muestra.getOpiniones().size());
	}
	
	@Test
	void testSeTesteaQueUnaOpinionPertezcaAUnUsuario() {
		when(otraOpinion.getId()).thenReturn(1);
		when(opinion.getId()).thenReturn(2);
		when(opinionTres.getId()).thenReturn(3);
		when(participante.getId()).thenReturn(3);
		muestra.agregarOpinion(otraOpinion);
		muestra.agregarOpinion(opinion);
		muestra.agregarOpinion(opinionTres);
		
		assertTrue(muestra.tieneOpinionDe(participante));
	}
	
	@Test
	void testSeTesteaQueUnaOpinionNoPertezcaAUnUsuario() {
		when(otraOpinion.getId()).thenReturn(1);
		when(opinion.getId()).thenReturn(2);
		when(opinionTres.getId()).thenReturn(3);
		when(participante.getId()).thenReturn(50);
		muestra.agregarOpinion(otraOpinion);
		muestra.agregarOpinion(opinion);
		muestra.agregarOpinion(opinionTres);
		
		assertFalse(muestra.tieneOpinionDe(participante));
	}
	
	@Test
	void testUnaMuestraNoVerificadaRecibeUnPosibleEstadoActualYRespondeQueEsSuEstadoActual() {
		assertTrue(muestra.estaEn("No Verificado"));
	}
	
	@Test
	void testUnaMuestraNoVerificadaRecibeUnPosibleEstadoActualYRespondeQueEseNoEsSuEstadoActual() {
		assertFalse(muestra.estaEn("Verificado"));
	}
}
