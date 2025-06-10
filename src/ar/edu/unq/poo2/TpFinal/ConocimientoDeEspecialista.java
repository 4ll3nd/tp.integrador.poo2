package ar.edu.unq.poo2.TpFinal;

public class ConocimientoDeEspecialista extends ValidacionDeConocimiento {

	public ConocimientoDeEspecialista(String conocimiento) {
		
		super(conocimiento);
	}

	@Override
	public void validarA(Participante unParticipante) {
		
		unParticipante.validarConocimiento();
		
	}

}
