package ar.edu.unq.poo2.TpFinal;


public abstract class EstadoDeCategoria {
	
	void agregar(IOpinion unaOpinion, Muestra unaMuestra, Participante unParticipante) {
		
		unParticipante.agregarOpinion(unaOpinion);
		unaMuestra.agregarOpinion(unaOpinion); 
	}
	
	void cambiarCategoria(Participante participante) {
		
		if(participante.esPromocionable()) {
	
			subirCategoria(participante);
		}
		else {
			
			bajarCategoria(participante);
		}
	}
	
	protected void bajarCategoria(Participante participante) {};
	protected void subirCategoria(Participante participante) {};
	protected abstract void opinar(ITipoDeOpinion tipoDeOpinion, Muestra unaMuestra, Participante unParticipante);
}
