package ar.edu.unq.poo2.TpFinal;

import java.util.List;

public class TipoDeInsecto implements Filtro {

	private ITipoDeOpinion opinion;

	public TipoDeInsecto(ITipoDeOpinion unaOpinion) {
		
		setOpinion(unaOpinion);
	}

	private void setOpinion(ITipoDeOpinion unaOpinion) {
		
		this.opinion = unaOpinion;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		
		return muestras.stream().filter(muestra -> hayTipoDeInsecto(muestra)).toList();
	}

	private boolean hayTipoDeInsecto(Muestra muestra) {
		
		return muestra.resultadoActual() == nombreDeInsecto();
	}

	private String nombreDeInsecto() {
		
		return getOpinion().getOpinion();
	}

	private ITipoDeOpinion getOpinion() {
		// TODO Auto-generated method stub
		return this.opinion;
	}

}
