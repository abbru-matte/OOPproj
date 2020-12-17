package model;

import java.util.Date;
import java.util.HashMap;

import Exceptions.FormatoData;
import Exceptions.NoValuta;
import Statistiche.HashMapStats;
import Statistiche.Statistiche;
import database.DatabaseHistorical;
import database.DatabaseLive;
import service.DateService;
import service.PrincipalService;
/**
 * 
 * La classe Bet serve da modello per la scommessa, la quale 
 * viene effettuata mediante un metodo POST su Postman 
 * 
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 *
 */

public class Bet {
	private Integer idBet;
	private String currency;
	private Integer segno;
	private Double quote;
	private Integer amount;
	private Double prize;
	private String date;
	
	static int ultimoidBet = 0;
	
	/**
	 * @param value
	 * @param quote
	 * @param amount
	 * @param date
	 */
	public Bet(Integer idBet, String currency, Integer segno, Double quote, Integer amount, Double prize, String date) {
		super();
		this.idBet = ultimoidBet + 1;
		ultimoidBet++;
		this.currency = currency;
		try {
			if(segno == 1 || segno == 2)
				this.segno = segno;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(this.segno == 1)
				this.quote = PrincipalService.algoritmoSale(currency);
			else
				this.quote = PrincipalService.algoritmoScende(currency);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.amount = amount;
		this.prize = this.amount*this.quote;
		this.date = DateService.CurrentDate();
	}


	public Double getPrize() {
		return prize;
	}


	public void setPrize(Double prize) {
		this.prize = prize;
	}

	public Integer getIdBet() {
		return idBet;
	}
	public void setIdBet(Integer idBet) {
		this.idBet = idBet;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String value) {
		this.currency = currency;
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
	
	public Integer getSegno() {
		return segno;
	}

	public void setSegno(Integer segno) {
		this.segno = segno;
	}
	
	public static boolean Verify(Bet bet) throws Exception {
		boolean bool = false;
		if(bet.amount <= 0) {
			bool = true;
		}
		return bool;
	}	
	
	
	
}
