package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class CurrencyList {
	
	public static Map<String, Currency> currencylist= new LinkedHashMap<>();

	public static Map<String, Currency> getCurrencylist() {
		return currencylist;
	}

	public static void setCurrencylist(Currency c) {
		currencylist.put(c.getName(), c);
	}

}
