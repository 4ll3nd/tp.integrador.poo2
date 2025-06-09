package ar.edu.unq.poo2.TpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizacionTest {
	private OrganizacionNoGubernamental ioleta;
	private Ubicacion ubiMock;

	@BeforeEach
	void setUp() throws Exception {

		ubiMock = mock(Ubicacion.class);

		TipoDeOrganizacion salud = TipoDeOrganizacion.Salud;

		ioleta = new OrganizacionNoGubernamental(ubiMock, salud, 500);
	}

	// Test de getters

	@Test
	void getUbicacionesTest() {
		assertEquals(ubiMock, ioleta.getUbicacion());

	}

	@Test
	void getTipoDeOrganizacionTest() {
		assertEquals(TipoDeOrganizacion.Salud, ioleta.getTipoDeOrganizacion());
	}

	@Test
	void getCantidadDeEmpleados() {
		assertEquals(500, ioleta.getCantidadDeEmpleados());
	}

}
