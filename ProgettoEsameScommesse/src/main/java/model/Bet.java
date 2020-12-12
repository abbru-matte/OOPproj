package model;




import Exceptions.NoValuta;
import database.DatabaseLive;
import service.DateService;
/**
 * 
 * La classe currencyLive serve da modello per la scommessa, la quale 
 * viene effettuata mediante un metodo POST su Postman 
 * 
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 *
 */

public class Bet {
	private String idBet;
	private String value;
	private Double quote;
	private Integer amount;
	private String date;
	
	
	/**
	 * @param value
	 * @param quote
	 * @param amount
	 * @param date
	 */
	public Bet(String idBet, String value, Double quote, Integer amount, String date) {
		super();
		this.idBet = idBet;
		this.value = value;
		try {
			this.quote = DatabaseLive.ValutaSceltaLive(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.amount = amount;
		this.date = DateService.CurrentDate();
	}
	
	
	public String getIdBet() {
		return idBet;
	}
	public void setIdBet(String idBet) {
		this.idBet = idBet;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Double getQuote() {
		return quote;
	}
	public void setQuote(Double quote) {
		this.quote = quote;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public static boolean Verify(Bet bet) throws Exception {
		boolean bool = false;
		if(bet.amount <= 0) {
			bool = true;
		}
		return bool;
	}
	
}
