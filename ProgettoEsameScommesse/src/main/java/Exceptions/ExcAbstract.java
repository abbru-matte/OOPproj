package Exceptions;

/**
 * 
 * Classe astratta da cui ereditano le eccezioni del progetto.
 * 
 * @author Murtezi Adrian & Abbruzzetti Matteo
 * 
 */
public abstract class ExcAbstract extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
		/**
		 * Ci da il messaggio di errore
		 *@return String
		 */
		public abstract String getMessage();

}
