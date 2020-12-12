package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * La classe currencyLive serve da modello per le richieste 
 * su Postman creando oggetti di tipo currencyLive
 *
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 *
 */

public class currencyLive {
	public Boolean success;
	public String terms;
	public String privacy;
	public String date;
	public Integer timestamp;
	public String source;
	public Map<String, Double> quotes = new HashMap<String, Double>();
	
	public currencyLive() {
		this.success = true;
		this.terms = null;
		this.privacy = null;
		this.date = null;
		this.timestamp = 0;
		this.source = null;
		this.quotes = null;
	}
	/**
	 * @param success
	 * @param terms
	 * @param privacy
	 * @param date
	 * @param timestamp
	 * @param source
	 * @param quotes
	 */
	public currencyLive(Boolean success, String terms, String privacy, String date,
			Integer timestamp, String source, Map<String, Double> quotes) {
		super();
		this.success = success;
		this.terms = terms;
		this.privacy = privacy;
		this.date = date;
		this.timestamp = timestamp;
		this.source = source;
		this.quotes = quotes;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Map<String, Double> getQuotes() {
		return quotes;
	}
	public void setQuotes(Map<String, Double> quotes) {
		this.quotes = quotes;
	}
	
}
