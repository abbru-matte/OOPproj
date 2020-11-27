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
public class currency {
	
	/**
	 * Attributi
	 */
	
	private String code;
	private String name;
	private Double value;
	private String data;
	private Double betAmount;
	
	/**
	 * costruttore di default
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
	 * costruttore
	 */
	public currency(String code, String name, Double value, String data, Double betAmount) {
		super();
		this.code = code;
		this.name = name;
		this.value = value;
		this.data = data;
		this.betAmount = betAmount;
	}
	
	//metodi getter e setter
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public Double getBetAmount() {
		return betAmount;
	}
	
	public void setBetAmount(Double betAmount) {
		this.betAmount = betAmount;
	}

	
	@Override
	public String toString() {
		return "currency [code=" + code + ", name=" + name + ", value=" + value + ", data=" + data + ", betAmount="
				+ betAmount + "]";
	}
	

}
