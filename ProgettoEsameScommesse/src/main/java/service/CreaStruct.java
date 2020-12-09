package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.JSONArray;

import model.currencyExchange;

public class CreaStruct {

	public static ArrayList<currencyExchange> getArrayDati(JSONArray k, ArrayList<currencyExchange> listaDati) throws Exception {
		for (int i = 0; i < k.size(); i++) {
			JSONObject o;
			currencyExchange dati1 = new currencyExchange();
			o = (JSONObject) k.get(i);

			dati1.setSuccess((Boolean) o.get("success"));
			dati1.setTerms((String) o.get("terms"));
			dati1.setPrivacy((String) o.get("privacy"));
			dati1.setHistorical((String) o.get("historical"));
			dati1.setDate((String) o.get("date"));
			dati1.setTimestamp((Integer) o.get("timestamp"));
			dati1.setSource((String) o.get("source"));
			dati1.setQuotes((Map<String, Float>) o.get("quotes"));
			listaDati.add(dati1);
		}
		return listaDati;
	}
	
	
	//Creare un JSONARRAY a partire da un arraylist tipo sendhistoricalrequest
	//
}
