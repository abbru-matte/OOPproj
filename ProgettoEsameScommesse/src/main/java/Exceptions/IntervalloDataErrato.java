package Exceptions;

/**
 * Eccezione lanciata quando l'utente non inserisce 
 * la data nel modo corretto
 * 
 * @author Murtezi Adrian & Abbruzzetti Matteo
 *
 */



public class IntervalloDataErrato extends ExcAbstract{
	
private static final long serialVersionUID = 1L; 
	
	/**
	 * Ottiene il messaggio da stampare
	 *
	 * @return String
	 */
	@Override
	public String getMessage() 
	{
		
		return "La data non è inserita nel modo corretto (la data di fine è antecedente alla data d'inizio) ";
	}

}
