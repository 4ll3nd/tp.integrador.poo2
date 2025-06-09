package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;

class EstadoParaBasico implements IEstadoDeCategoria {

	@Override
	public void cambiarCategoria(Participante unParticipante) {
		
		unParticipante.setEstado(new EstadoParaExperto());
		
	}

	@Override
	public void opinar(ITipoDeOpinion tipoDeOpinion, Muestra unaMuestra, Participante unParticipante) {
		
		IOpinion unaOpinion = new Opinion(LocalDate.now(), unParticipante.getId(), Voto.VotoDeBasico, tipoDeOpinion);
		unParticipante.agregarOpinion(unaOpinion);
		unaMuestra.agregarOpinion(unaOpinion);
	}


}
