package ar.edu.unq.poo2.TpFinal;

public class EstadoStandBy implements IEstadoDeMuestra{
	public void agregarOpinion(Muestra muestra, IOpinion unaOpinion) {
	  if(this.existeMismaOpinion(muestra, unaOpinion) && unaOpinion.getVoto() == Voto.VotoDeExperto) {
			muestra.setEstado(new EstadoVerificado());
			muestra.doAgregarOpinion(unaOpinion);
		}
		else {
			if(unaOpinion.getVoto() == Voto.VotoDeExperto) {
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
	private boolean existeMismaOpinion(Muestra muestra, IOpinion unaOpinion) {
		return muestra.getOpiniones().stream().
				anyMatch(o -> o.getOpinion().equalsIgnoreCase(unaOpinion.getOpinion()));
	}
	/*PROPOSITO: obtener el resultado actual de la muestra dada
	 * OBSERVACION: en este caso este estado solo le interesan las opiniones de un experto
	 * entonces solamente las filtro de las de los basico, ademas, en este estado
	 * se que solo hay una opinion de un experto. Si hubiera mas seria otro estado.
	 * */
	@Override
	public String resultadoActual(Muestra muestra) {
		return muestra.getOpiniones().stream()
							         .filter(o -> o.getVoto() == Voto.VotoDeExperto)
							         .toList()
							         .getFirst()
							         .getOpinion();
		
	}

	@Override
	public boolean estaEn(String estadoPosible) {
		return estadoPosible.equalsIgnoreCase("StandBy");
	}
}
