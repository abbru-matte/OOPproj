package service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

import model.Currency;
import Exceptions.ImportoErrato;
import Statistiche.HashMapStats;
import database.DatabaseHistorical;
import database.DatabaseLive;
import model.Bet;
import model.BetList;
import model.Metadati;
import model.ModelloStatistiche;
import model.CurrencyHistorical;

/**
 * 
 * 
 * Il PrincipalService contiene una serie di 
 * metodi che vengono poi richiamati nel controller
 * 
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 *
 */

@org.springframework.stereotype.Service
public class PrincipalService {
	
	HashMap<String,Currency> listc;
	
	public PrincipalService() {
		listc = new HashMap<String,Currency>();
	}
	
	
	public static ArrayList<String> GetValute() throws Exception {
		return DatabaseLive.ValuteLive();
	}
	
	public HashMap<String, String> getMetadati() {
		 return Metadati.mdAll();
		}
	
	public static ArrayList<CurrencyHistorical> GetValoriStorici(String from, String to,String currencies) throws Exception{
		return DatabaseHistorical.GetValuteStoriche(from, to, currencies);
	}
	
	
	public static HashMap<String,ModelloStatistiche> getStatistics(String from, String to,String currencies) throws Exception{
		return HashMapStats.createHashMap(DatabaseHistorical.GetValuteStoriche(from, to, currencies),currencies);
	}
	

	public static void PlaceBet(Bet b) throws Exception {
		if(Bet.Verify(b) == true)
			throw new ImportoErrato();
		BetList.setBetlist(b);
	} 
	
	public static Collection<Bet> getAllBet(){
		Map<Integer, Bet> betlist = BetList.getBetlist();
		return betlist.values();
	}

	public void updateCurrencies(Bet bet) {
		
		
		Currency curr = new Currency();
		sortByValue(listc);
		if(listc.get(bet.getCurrency()) == null) {
			curr.setName(bet.getCurrency());
			curr.setBetAmount(bet.getAmount());
			listc.put(bet.getCurrency(), curr);
		}
		else{
			
			curr = listc.get(bet.getCurrency());
			int somma = curr.getBetAmount() + bet.getAmount();
			curr.setBetAmount(somma);
			listc.remove(bet.getCurrency());
			listc.put(bet.getCurrency(), curr);
		}
		
		
	}
	
	
	
	public void sortByValue(HashMap<String, Currency> hm) 
	{
		List<Map.Entry<String, Currency> > list = new LinkedList<Map.Entry<String, Currency> >(hm.entrySet());
		 Collections.sort(list, new Comparator<Map.Entry<String, Currency>>() { 
	            public int compare(Map.Entry<String, Currency> o1,  
	                               Map.Entry<String, Currency> o2) 
	            { 
	                return (o2.getValue().getBetAmount()).compareTo(o1.getValue().getBetAmount()); 
	            } 
	        }); 
		 
	}
	
	public Map<String, Currency> getAllcurrencies(){
		return listc;
	}
	
	
	
	public static String getMessaggio(String currency) throws Exception {
		return"Quota relativa ad un rialzo della quotazione di " + currency + ": " +algoritmoSale(currency)+"\n"+
		 "Quota relativa ad un ribasso della quotazione di " + currency + ": " +algoritmoScende(currency);
	}
	
	public static double algoritmoScende(String currencies) throws Exception {
		double quote=1.80;
		double valatt = DatabaseLive.ValutaSceltaLive("USD"+currencies);  
		HashMap<String,ModelloStatistiche> modello = HashMapStats.createHashMap(DatabaseHistorical.GetValuteStoriche(DateService.PreviousWeek(), DateService.CurrentDate(), currencies), currencies);
		ModelloStatistiche md = modello.get(ModelloStatistiche.getMedia());
		double m = md.getMedia();
		double diff=m/valatt;
		quote*=diff;
		quote=Math.round(quote*100.0)/100.0;
		if(quote<=1) quote=1.01;
		
		return quote;
	}
	
	public static double algoritmoSale(String currencies) throws Exception {
		double quote=1.80;
		double valatt = DatabaseLive.ValutaSceltaLive("USD"+currencies); 
		HashMap<String,ModelloStatistiche> modello = HashMapStats.createHashMap(DatabaseHistorical.GetValuteStoriche(DateService.PreviousWeek(), DateService.CurrentDate(), currencies), currencies);
		ModelloStatistiche md = modello.get(ModelloStatistiche.getMedia());
		double m = ModelloStatistiche.getMedia();
		double diff=valatt/m;
		quote*=diff;
		quote=Math.round(quote*100.0)/100.0;
		if(quote<=1) quote=1.01;
		
		return quote;
	}

}
	

	


