package Exceptions;

/**
 * Eccezione lanciata se la valuta che si vuole inserire non è corretta o
 * non esiste.
 * 
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 * 
 */

public class NoValuta extends ExcAbstract {
	private static final long serialVersionUID = 1L; 

	/**
	 * Ottiene il messaggio da stampare
	 * @return String
	 */
	@Override
	public String getMessage() {
	
		return "Questa valuta non esiste";
	}

}
