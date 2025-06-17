package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TipoDeInsectoTest {
	
	private TipoDeInsecto unFiltroPorTipoDeInsecto;
	private ITipoDeOpinion unaOpinionDeInsecto;
	

	@BeforeEach
	void setUp() throws Exception {
		
		unaOpinionDeInsecto = mock(ITipoDeOpinion.class);
		unFiltroPorTipoDeInsecto = new TipoDeInsecto(unaOpinionDeInsecto);
	}

	@Test
	void test_SiUnFiltroRecibeUnaListaVacia_DevuelveUnaListaVacia() {
				
		assertTrue(unFiltroPorTipoDeInsecto.filtrar(new ArrayList<Muestra>()).isEmpty());
	}
	
	@Test
	void test_SiTodasLasMuestraCumplenConLaFechaDeCreacion_NoSeFiltraNingunaMuestra() {
		
		when(unaOpinionDeInsecto.getOpinion()).thenReturn("Chinche Foliada");
		
		List<Muestra> muestras = agregar(2, "Chinche Foliada");
		
		assertEquals(unFiltroPorTipoDeInsecto.filtrar(muestras).size(), muestras.size());
	}
	
	@Test
	void test_SiNingunaMuestraCumplenConLaFechaDeCreacion_SeFiltranTodas() {
		
		when(unaOpinionDeInsecto.getOpinion()).thenReturn("Chinche Foliada");
		
		List<Muestra> muestras = agregar(2, "Phtia Chinche");
		
		assertTrue(unFiltroPorTipoDeInsecto.filtrar(muestras).isEmpty());
	}
	
	@Test
	void test_SiUnaMuestraCumpleConElCriterioDelFiltro_ElFiltroLaAgrega() {
		
		when(unaOpinionDeInsecto.getOpinion()).thenReturn("Phtia Chinche");
		
		List<Muestra> muestras = agregar(2, "Phtia Chinche");
		
		Muestra nuevaMuestra = muestraConOpinion("Phtia Chinche");
		
		muestras.add(nuevaMuestra);
		
		assertTrue(unFiltroPorTipoDeInsecto.filtrar(muestras).contains(nuevaMuestra));
	}
	
	@Test
	void test_SiUnaMuestraNoCumpleConElCriterioDelFiltro_ElFiltroNoLaAgrega() {
		
		when(unaOpinionDeInsecto.getOpinion()).thenReturn("Phtia Chinche");
		
		List<Muestra> muestras = agregar(2, "Phtia Chinche");
		
		Muestra nuevaMuestra = muestraConOpinion("Chinche Foliada");
		
		muestras.add(nuevaMuestra);
		
		assertFalse(unFiltroPorTipoDeInsecto.filtrar(muestras).contains(nuevaMuestra));
	}

	private List<Muestra> agregar(Integer cantidadDeMuestras, String tipoDeInsecto) {
		
		List<Muestra> muestras = new ArrayList<Muestra>();
		
		while(cantidadDeMuestras > 0) {
			
			muestras.add(muestraConOpinion(tipoDeInsecto));
			cantidadDeMuestras--;
		}
		
		return muestras;
	}

	private Muestra muestraConOpinion(String tipoDeInsecto) {
		
		Muestra muestra = mock(Muestra.class);
		when(muestra.resultadoActual()).thenReturn(tipoDeInsecto);
		return muestra;
	}
}
