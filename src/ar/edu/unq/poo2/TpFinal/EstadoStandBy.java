package ar.edu.unq.poo2.TpFinal;

public class EstadoStandBy implements IEstadoDeMuestra{
	public void agregarOpinion(Muestra muestra, Opinion unaOpinion) {
	  if(this.existeMismaOpinion(muestra, unaOpinion) && unaOpinion.getVoto() == Voto.VotoExperto) {
			muestra.setEstado(new EstadoVerificado());
			muestra.doAgregarOpinion(unaOpinion);
		}
		else {
			if(unaOpinion.getVoto() == Voto.VotoExperto) {
				muestra.doAgregarOpinion(unaOpinion);
			}
		}
	}
	
	/**
	 * 	public void agregarOpinion(Muestra muestra, Opinion unaOpinion) {
		if(unaOpinion.getVoto() == Voto.VotoExperto) {
			this.cambiarEstadoSi(muestra, this.existeMismaOpinion(muestra, unaOpinion));
			muestra.doAgregarOpinion(unaOpinion);
			
		}
	}

	private void cambiarEstadoSi(Muestra muestra, boolean existeMismaOpinion) {
		if(existeMismaOpinion) {
			muestra.setEstado(new EstadoVerificado());
		}
	}
	 * **/
	private boolean existeMismaOpinion(Muestra muestra, Opinion unaOpinion) {
		return muestra.getOpiniones().stream().
				anyMatch(o -> o.getOpinion().equalsIgnoreCase(unaOpinion.getOpinion()));
	}
}
