package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;

public class Opinion implements IOpinion {
	
	private LocalDate fecha;
	private Integer id;
	private Voto voto;
	private ITipoDeOpinion tipoDeOpinion;

	public Opinion(LocalDate unaFecha, int id, Voto unVoto, ITipoDeOpinion tipoDeOpinion) {
		
		setFecha(unaFecha);
		setId(id);
		setvoto(unVoto);
		setTipoDeOpinion(tipoDeOpinion);
	}

	private void setTipoDeOpinion(ITipoDeOpinion tipoDeOpinion) {
		
		this.tipoDeOpinion = tipoDeOpinion;
		
	}

	private void setvoto(Voto unVoto) {
		
		this.voto = unVoto;
		
	}

	private void setId(int id) {
		
		this.id = id;
	}

	private void setFecha(LocalDate unaFecha) {
		
		this.fecha = unaFecha;
	}

	@Override
	public String getOpinion() {
		
		return getTipoDeOpinion().getOpinion();
	}

	private ITipoDeOpinion getTipoDeOpinion() {
		
		return this.tipoDeOpinion;
	}

	@Override
	public Integer getId() {
		
		return this.id;
	}

	@Override
	public Voto getVoto() {
		
		return this.voto;
	}

	public LocalDate getFecha() {
		
		return this.fecha;
	}

}
