package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Muestra {

	private EspecieVinchuca especie;
	private Ubicacion ubicacion;
	private LocalDate fechaDeSubida;
	private IFoto foto;
	private List<Opinion> opiniones = new ArrayList<Opinion>();
	private IEstadoDeMuestra estado;
	private List<ZonaDeCobertura> zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
	public Muestra(EspecieVinchuca especie, Ubicacion ubicacion, LocalDate fechaDeSubida, IFoto foto,
			Opinion opinion) {
		this.especie = especie;
		if(opinion.getVoto() == Voto.VotoExperto) {
			this.estado = new EstadoStandBy();
		} else {
			this.estado = new EstadoNoVerificado();
		}
		this.opiniones.add(opinion);
		this.ubicacion = ubicacion;
		this.fechaDeSubida = fechaDeSubida;
		this.foto = foto;
		
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

	public List<Opinion> getOpiniones() {
		return opiniones;
	}
	
	public Integer getId() {
		return this.opiniones.getFirst().getId();
	}

	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return zonasDeCobertura;
	}

	public void agregarZona(ZonaDeCobertura zona) {
		this.zonasDeCobertura.add(zona);
	}

	public void agregarOpinion(Opinion unaOpinion) {
		this.estado.agregarOpinion(this, unaOpinion);
	}
	
	public String resultadoActual() {
		return this.estado.resultadoActual(this);
	}
	
	public void setEstado(IEstadoDeMuestra estado) {
		this.estado = estado;
	}
	
	protected void doAgregarOpinion(Opinion unaOpinion) {
		this.opiniones.add(unaOpinion);
	}
	
	public void notificarVerificacion() {
		//en un futuro se le dara un metodo
	}
	
}
