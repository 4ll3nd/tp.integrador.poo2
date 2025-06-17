package ar.edu.unq.poo2.TpFinal;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NivelDeVerificacionTest {
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	List<Muestra> muestras;
	NivelDeVerificacion busquedaVerificada;
	NivelDeVerificacion busquedaNoVerificada;
	NivelDeVerificacion busquedaStandBy;
	@BeforeEach
	void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);		muestra4 = mock(Muestra.class);
		muestras = new ArrayList<Muestra>();
		muestras = Arrays.asList(muestra1, muestra2, muestra3, muestra4);
		busquedaVerificada = new NivelDeVerificacion("Verificado");
		busquedaNoVerificada = new NivelDeVerificacion("No Verificado");
		busquedaStandBy = new NivelDeVerificacion("StandBy");	}
	@Test
	void testSeFiltraUnaListaDeMuestrasYSeObtieneAquellasVerificadas() {
		when(muestra1.estaEn("Verificado")).thenReturn(true);
		when(muestra2.estaEn("Verificado")).thenReturn(true);
		when(muestra3.estaEn("Verificado")).thenReturn(false);
		when(muestra4.estaEn("Verificado")).thenReturn(false);
				assertEquals(2, busquedaVerificada.filtrar(muestras).size());
		assertEquals(muestra1, busquedaVerificada.filtrar(muestras).getFirst());
		assertEquals(muestra2, busquedaVerificada.filtrar(muestras).getLast());
		assertFalse(busquedaVerificada.filtrar(muestras).contains(muestra3));
		assertFalse(busquedaVerificada.filtrar(muestras).contains(muestra4));
	}
	
	@Test
	void testSeFiltraUnaListaDeMuestrasYSeObtieneAquellasNoVerificadas() {
		when(muestra1.estaEn("No Verificado")).thenReturn(true);
		when(muestra2.estaEn("No Verificado")).thenReturn(true);
		when(muestra3.estaEn("No Verificado")).thenReturn(true);
		when(muestra4.estaEn("No Verificado")).thenReturn(false);
		
		assertEquals(3, busquedaNoVerificada.filtrar(muestras).size());
		assertTrue(busquedaNoVerificada.filtrar(muestras).contains(muestra1));
		assertTrue(busquedaNoVerificada.filtrar(muestras).contains(muestra2));
		assertTrue(busquedaNoVerificada.filtrar(muestras).contains(muestra3));
		assertFalse(busquedaNoVerificada.filtrar(muestras).contains(muestra4));
	}
	
	@Test
	void testSeFiltraUnaListaDeMuestrasYSeOntieneAquellasEnStandBy() {
		when(muestra1.estaEn("StandBy")).thenReturn(false);
		when(muestra2.estaEn("StandBy")).thenReturn(false);
		when(muestra3.estaEn("StandBy")).thenReturn(true);
		when(muestra4.estaEn("StandBy")).thenReturn(false);
		
		assertEquals(1, busquedaStandBy.filtrar(muestras).size());
		assertFalse(busquedaStandBy.filtrar(muestras).contains(muestra1));
		assertFalse(busquedaStandBy.filtrar(muestras).contains(muestra2));
		assertTrue(busquedaStandBy.filtrar(muestras).contains(muestra3));
		assertFalse(busquedaStandBy.filtrar(muestras).contains(muestra4));
	}
}
