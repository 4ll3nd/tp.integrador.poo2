package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;

class EstadoParaBasico extends EstadoDeCategoria {

	@Override
	public void subirCategoria(Participante unParticipante) {
		
		unParticipante.setEstado(new EstadoParaExperto());
		
	}

	@Override
	public void opinar(ITipoDeOpinion tipoDeOpinion, Muestra unaMuestra, Participante unParticipante) {
		
		IOpinion unaOpinion = new Opinion(LocalDate.now(), unParticipante.getId(), Voto.VotoDeBasico, tipoDeOpinion);
		agregar(unaOpinion, unaMuestra, unParticipante);	
	}
}
