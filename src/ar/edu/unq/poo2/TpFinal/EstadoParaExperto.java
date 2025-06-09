package ar.edu.unq.poo2.TpFinal;

import java.time.LocalDate;

public class EstadoParaExperto extends EstadoDeCategoria {

	@Override
	public void subirCategoria(Participante unParticipante) {
		
		unParticipante.setEstado(new EstadoParaEspecialista());
	}

	@Override
	public void opinar(ITipoDeOpinion tipoDeOpinion, Muestra unaMuestra, Participante unParticipante) {
		
		IOpinion unaOpinion = new Opinion(LocalDate.now(), unParticipante.getId(), Voto.VotoDeExperto, tipoDeOpinion);
		agregar(unaOpinion, unaMuestra, unParticipante);		
	}

	@Override
	protected void bajarCategoria(Participante participante) {
		
		participante.setEstado(new EstadoParaBasico());
	}
}
