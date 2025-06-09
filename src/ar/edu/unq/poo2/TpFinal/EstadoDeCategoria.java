package ar.edu.unq.poo2.TpFinal;


public abstract class EstadoDeCategoria {
	
	public void cambiarCategoria(Participante participante) {
		
		if(participante.esPromocionable()) {
			
			subirCategoria(participante);
		}
		else {
			
			bajarCategoria(participante);
		}
	}
	
	protected void agregar(IOpinion unaOpinion, Muestra unaMuestra, Participante unParticipante) {
		
		unParticipante.agregarOpinion(unaOpinion);
		unaMuestra.agregarOpinion(unaOpinion);
		
	}
	
	protected void bajarCategoria(Participante participante) {
		
	};

	public abstract void subirCategoria(Participante unParticipante);
	public abstract void opinar(ITipoDeOpinion tipoDeOpinion, Muestra unaMuestra, Participante unParticipante);
}
