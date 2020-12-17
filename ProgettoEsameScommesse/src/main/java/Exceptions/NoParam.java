package Exceptions;

/**
 * Eccezione lanciata per il mancato inserimento di un parametro sul Client.
 * 
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 * 
 */

public class NoParam extends ExcAbstract {
	private static final long serialVersionUID = 1L; 

	/**
	 * Ottiene il messaggio da stampare
	 * @return String
	 */
	@Override
	public String getMessage() {
		
		return "Parametro errato!";
	}

}
