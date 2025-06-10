package ar.edu.unq.poo2.TpFinal;

public class ConocimientoNulo {

	private String conocimiento;

	public ConocimientoNulo(String conociminento) {
		
		setConocimiento(conociminento);
	}

	private void setConocimiento(String conociminento) {
		
		this.conocimiento = conociminento;
		
	}

	public void validarA(Participante participante) {
		
		participante.comenzarDeCero();
		
	}

}
