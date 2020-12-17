package model;
/**
 * <p>
 * <b>Classe</b> per la gestione di una valuta
 * </p>
 * 
 * @author Abbruzzetti Matteo & Murtezi Adrian
 * @version 1.0
 *
 */
public class Currency {
	
	/**
	 * Attributi
	 */
	
	private String name;
	private Integer betAmount;
	
	public Currency() {
		super();
		this.name = null;
		this.betAmount = 0;
	}
	
	/**
	 * costruttore
	 */
	public Currency( String name, Integer betAmount) {
		super();
		this.name = name;
		this.betAmount = betAmount;
	}
	
	//metodi getter e setter
	
	public  String getName() {
		return name;
	}
	
	public  void setName(String name) {
		this.name = name;
	}
		
	public Integer getBetAmount() {
		return betAmount;
	}
	
	public void setBetAmount(Integer betAmount) {
		this.betAmount = betAmount;
	}
	
	public void sommaAmount(Bet b) {
		betAmount += b.getAmount();
	}
	

}
