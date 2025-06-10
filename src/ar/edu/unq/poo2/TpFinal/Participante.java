package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Participante {
	
	private List<Muestra> muestras;
	private List<IOpinion> opiniones;
	private Integer id;
	private EstadoDeCategoria estado;
	
	
	public Participante(Integer id) {
		
		initializeMuestras();
		initializeOpiniones();
		setEstado(new EstadoParaBasico());
		this.id = id;
	}

	void agregarOpinion(IOpinion unaOpinion) {
		
		getOpiniones().add(unaOpinion);
	}

	public int getId() {
		
		return this.id;
	}

	public void agregarMuestra(Muestra muestra) {
		
		getMuestras().add(muestra);
		
	}
	
	private List<Muestra> getMuestras() {
		
		return this.muestras;
	}

	private void initializeMuestras() {
		
		this.muestras = new ArrayList<Muestra>();
	}
	
	private List<IOpinion> getOpiniones() {
		
		return this.opiniones;
	}
	
	void setEstado(EstadoDeCategoria unEstado) {
		
		this.estado = unEstado;
	}

	public void opinar(ITipoDeOpinion tipoDeOpinion, Muestra muestra) throws Exception {
		
		if(esInvalida(muestra)) {
			
			throw new Exception("El participante no puede opinar sobre la muestra que envió y la muestra que ya opino");
		}
		
		getEstado().opinar(tipoDeOpinion, muestra, this);
	}

	private Boolean esInvalida(Muestra muestra) {
		
		return fueEnviada(muestra) || muestra.tieneOpinionDe(this);
	}

	private Boolean fueEnviada(Muestra muestra) {
		
		return getMuestras().contains(muestra);
	}

	private EstadoDeCategoria getEstado() {
		
		return this.estado;
	}
	
	private void initializeOpiniones() {
		
		this.opiniones = new ArrayList<IOpinion>();
	}

	Boolean esPromocionable() {
		
		return hayCantidadDeMuestras(10) && hayCantidadDeOpiniones(20);
	}

	private Boolean hayCantidadDeOpiniones(Integer cantidad) {
		
		return opinionesHace30Dias() == cantidad;
	}

	private Integer opinionesHace30Dias() {
		
		return getOpiniones().stream().filter(opinion -> esAntesDe30Dias(opinion.getFecha())).toList().size();
	}


	private Boolean esAntesDe30Dias(LocalDate fecha) {
		
		LocalDate fechaHace30Dias = LocalDate.now().minusDays(30);
		return !fecha.isAfter(LocalDate.now()) && !fecha.isBefore(fechaHace30Dias);
	}

	private Boolean hayCantidadDeMuestras(Integer cantidad) {
		
		return  muestrasHace30Dias() == cantidad;
	}
	
	private Integer muestrasHace30Dias() {
		
		return getMuestras().stream().filter(muestra -> esAntesDe30Dias(muestra.getFecha())).toList().size();
	}

	public void cambiarCategoria() {
		
		getEstado().cambiarCategoria(this);
	}

	void comenzarDeCero() {
		
		setEstado(new EstadoParaBasico());
	}

	void validarConocimiento() {
		
		setEstado(new EstadoParaEspecialista());
		
	}


}
