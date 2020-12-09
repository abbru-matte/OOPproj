package model;

import java.util.HashMap;
import java.util.Map;

public class currencyExchange {
	
	public Boolean success;
	public String terms;
	public String privacy;
	public String historical;
	public String date;
	public Integer timestamp;
	public String source;
	public Map<String, Float> quotes = new HashMap<String, Float>();
			
	
	public currencyExchange() {
		this.success = false;
		this.terms = null;
		this.privacy = null;
		this.historical = null;
		this.date = null;
		this.timestamp = 0;
		this.source = null;
		this.quotes = null;
	}
	/**
	 * @param success
	 * @param terms
	 * @param privacy
	 * @param historical
	 * @param date
	 * @param timestamp
	 * @param source
	 * @param quotes
	 */
	public currencyExchange(Boolean success, String terms, String privacy, String historical, String date,
			Integer timestamp, String source, Map<String, Float> quotes) {
		super();
		this.success = success;
		this.terms = terms;
		this.privacy = privacy;
		this.historical = historical;
		this.date = date;
		this.timestamp = timestamp;
		this.source = source;
		this.quotes = quotes;
	}
	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	/**
	 * @return the terms
	 */
	public String getTerms() {
		return terms;
	}
	/**
	 * @param terms the terms to set
	 */
	public void setTerms(String terms) {
		this.terms = terms;
	}
	/**
	 * @return the privacy
	 */
	public String getPrivacy() {
		return privacy;
	}
	/**
	 * @param privacy the privacy to set
	 */
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	/**
	 * @return the historical
	 */
	public String getHistorical() {
		return historical;
	}
	/**
	 * @param historical the historical to set
	 */
	public void setHistorical(String historical) {
		this.historical = historical;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the timestamp
	 */
	public Integer getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the quotes
	 */
	public Map<String, Float> getQuotes() {
		return quotes;
	}
	/**
	 * @param quotes the quotes to set
	 */
	public void setQuotes(Map<String, Float> quotes) {
		this.quotes = quotes;
	}
	
	

}
