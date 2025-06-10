package ar.edu.unq.poo2.TpFinal;

public class ConocimientoNulo extends ValidacionDeConocimiento {

	public ConocimientoNulo(String conociminento) {
		
		super(conociminento);
	}

	@Override
	public void validarA(Participante participante) {
		
		participante.comenzarDeCero();
		
	}

}
