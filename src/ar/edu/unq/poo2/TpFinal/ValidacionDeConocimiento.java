package ar.edu.unq.poo2.TpFinal;

public abstract class ValidacionDeConocimiento {
	
	private String conocimiento;

	public ValidacionDeConocimiento(String conociminento) {
		
		setConocimiento(conociminento);
	}
	
	private void setConocimiento(String conociminento) {
		
		this.conocimiento = conociminento;
		
	}
	
	public abstract void validarA(Participante unParticipante);

}
