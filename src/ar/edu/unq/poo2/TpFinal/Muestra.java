package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Muestra {

	private EspecieVinchuca especie;
	private Ubicacion ubicacion;
	private LocalDate fechaDeSubida;
	private IFoto foto;
	private List<IOpinion> opiniones = new ArrayList<IOpinion>();
	private IEstadoDeMuestra estado;
	private List<ZonaDeCobertura> zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
	private Integer creador;
	public Muestra(EspecieVinchuca especie, Ubicacion ubicacion, LocalDate fechaDeSubida, IFoto foto, 
			Participante creador) {
		this.especie = especie;
		this.estado = new EstadoNoVerificado();
		this.ubicacion = ubicacion;
		this.fechaDeSubida = fechaDeSubida;
		this.foto = foto;
		this.creador = creador.getId();
	}

	public EspecieVinchuca getEspecie() {
		return especie;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public LocalDate getFechaDeSubida() {
		return fechaDeSubida;
	}

	public IFoto getFoto() {
		return foto;
	}

	public List<IOpinion> getOpiniones() {
		return this.opiniones;
	}
	
	public Integer getId() {
		return this.creador;
	}

	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return zonasDeCobertura;
	}

	public void agregarZona(ZonaDeCobertura zona) {
		this.zonasDeCobertura.add(zona);
	}

	public void agregarOpinion(IOpinion unaOpinion) {
		this.estado.agregarOpinion(this, unaOpinion);
	}
	
	public String resultadoActual() {
		return this.opiniones.size() == 0 ? this.especie.getNombre() : this.estado.resultadoActual(this); 
	}
	
	public void setEstado(IEstadoDeMuestra estado) {
		this.estado = estado;
	}
	
	public boolean tieneOpinionDe(Participante participante) {
		return this.opiniones.stream().
				              anyMatch(o -> o.getId() == participante.getId());	
	}
	
	protected void doAgregarOpinion(IOpinion unaOpinion) {
		this.opiniones.add(unaOpinion);
	}
	
	public void notificarVerificacion() {
		//en un futuro se le dara un metodo
	}

	public boolean estaEn(String estadoPosible) {
		return this.estado.estaEn(estadoPosible);
	}
}
