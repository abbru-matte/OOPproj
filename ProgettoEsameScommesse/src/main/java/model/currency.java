package model;

public class currency {
	String code;
	String name;
	Double value;
	String data;
	Double betAmount;
	/**
	 * initial constructor
	 */
	public currency() {
		super();
		this.code = null;
		this.name = null;
		this.value = null;
		this.data = null;
		this.betAmount = null;
	}
	
	/**
	 * constructor
	 * @param code
	 * @param name
	 * @param value
	 * @param data
	 * @param betAmount
	 */
	public currency(String code, String name, Double value, String data, Double betAmount) {
		super();
		this.code = code;
		this.name = name;
		this.value = value;
		this.data = data;
		this.betAmount = betAmount;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**
	 * @return the betAmount
	 */
	public Double getBetAmount() {
		return betAmount;
	}
	/**
	 * @param betAmount the betAmount to set
	 */
	public void setBetAmount(Double betAmount) {
		this.betAmount = betAmount;
	}
	
	
	
	

}
