package Statistiche;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.Iterator;


import model.ModelloStatistiche;
import model.currencyExchange;
import Statistiche.Statistiche;

public class HashMapStats {
	
	
	public static HashMap<String, ModelloStatistiche> createHashMap(ArrayList<currencyExchange> v) {

		HashMap<String, ModelloStatistiche> hs = new HashMap<String, ModelloStatistiche>();
		ModelloStatistiche m;
		ArrayList<Double> vet;
		currencyExchange e = new currencyExchange();

		for (String s : v.get(0).quotes.keySet()) {
			
			 	vet.add(0, e.quotes.values()); 
			
			m = new ModelloStatistiche(vet, Statistiche.media(vet), Statistiche.varianza(vet),
					Statistiche.DeviazioneStandard(vet));
			hs.put(s, m);

		}
		hs.remove("USDUSD"); // rimuovo questa conversione poichè inutile
		return hs;
	}
}
