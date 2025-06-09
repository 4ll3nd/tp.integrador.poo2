package ar.edu.unq.poo2.TpFinal;

public class OrganizacionNoGubernamental {

	private int cantidadDeEmpleados;
	private Ubicacion ubicacion;
	private TipoDeOrganizacion tipoDeOrganizacion;

	public OrganizacionNoGubernamental(Ubicacion ubi, TipoDeOrganizacion tipOrga, int empleados) {
		this.cantidadDeEmpleados = empleados;
		this.ubicacion = ubi;
		this.tipoDeOrganizacion = tipOrga;
	}

	public int getCantidadDeEmpleados() {
		return cantidadDeEmpleados;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public TipoDeOrganizacion getTipoDeOrganizacion() {
		return tipoDeOrganizacion;
	}

}
