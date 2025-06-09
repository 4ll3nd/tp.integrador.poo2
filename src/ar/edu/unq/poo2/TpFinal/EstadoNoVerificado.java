package ar.edu.unq.poo2.TpFinal;

public class EstadoNoVerificado implements IEstadoDeMuestra {

	@Override
	public void agregarOpinion(Muestra muestra, Opinion unaOpinion) {
		if(unaOpinion.getVoto() == Voto.VotoExperto) {
			muestra.setEstado(new EstadoStandBy());
			muestra.doAgregarOpinion(unaOpinion);
		}
		else {
			muestra.doAgregarOpinion(unaOpinion);
		}
	}
}
