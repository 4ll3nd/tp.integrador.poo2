package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClaseMuestraTest {
	Muestra muestra;
	EspecieVinchuca infentans;
	Ubicacion ubicacion;
	LocalDate fechaDeSubida;
	IFoto foto;
	Opinion opinion;
	Opinion otraOpinion;
	ZonaDeCobertura zona;
	@BeforeEach
	void setUp() throws Exception {
		infentans = mock(EspecieVinchuca.class);
		ubicacion = mock(Ubicacion.class);
		fechaDeSubida = LocalDate.of(2002, 3, 12);
		foto = mock(IFoto.class);
		opinion = mock(Opinion.class);
		otraOpinion = mock(Opinion.class);
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
	
	@Test
	void testSeAgregaUnaNuevaOpinionALaMuestraEnEstadoNoVerificada() {
		muestra.agregarOpinion(otraOpinion);
		
		assertEquals(2, muestra.getOpiniones().size());
	}
}
