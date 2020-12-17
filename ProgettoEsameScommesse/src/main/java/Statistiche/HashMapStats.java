package Statistiche;

import java.util.*;

import model.ModelloStatistiche;
import model.CurrencyHistorical;
import database.DatabaseLive;

/**
 * Classe che contiene metodi per la gestione delle statistiche
 * 
 *@author Murtezi Adrian & Abbruzzetti Matteo
 *
 */

public class HashMapStats {
	
	/**
	 * Metodo che costruisce una HashMap dove vanno inserite i valori 
	 * e la statistiche richieste, ovvero media, varianza e deviazione standard
	 * 
	 * @param v indica un ArrayList di currencyHistorical che contiene 
	 * 			i valori delle valute in un periodo di tempo
	 * @param currencies 
     * 
	 * @return  ritorna un HashMap che contiene i tassi di cambio e le statistiche richieste,
	 * @throws Exception 
	 * 			
	 */
	public static HashMap<String, ModelloStatistiche> createHashMap(ArrayList<CurrencyHistorical> v, String currencies) throws Exception {
		Double valorelive = DatabaseLive.ValutaSceltaLive("USD"+currencies);
		HashMap<String, ModelloStatistiche> hs = new HashMap<String, ModelloStatistiche>();
		ModelloStatistiche m;
		ArrayList<Double> vet = new ArrayList<Double>();
		CurrencyHistorical e = new CurrencyHistorical();
		String message = null;
		Iterator<CurrencyHistorical> it2 = v.iterator();
		
		for (String valuta : v.get(0).quotes.keySet()) {
			while (it2.hasNext()) {
				e = it2.next();
				vet.add(e.quotes.get(valuta));
			}
			if(valorelive < Statistiche.media(vet)) 
				message = "La quotazione attuale di " + currencies + " è minore della media mensile! ";
			else message = "La quotazione attuale di " + currencies + " è maggiore della media mensile! ";
			m = new ModelloStatistiche(vet, Statistiche.media(vet), Statistiche.varianza(vet),
					Statistiche.DeviazioneStandard(vet), message);
			hs.put(valuta, m);
		}
		return hs;
	}
}
