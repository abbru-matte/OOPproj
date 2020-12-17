package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Exceptions.ImportoErrato;
import Exceptions.NoParam;
import Statistiche.HashMapStats;
import database.DatabaseHistorical;
import database.DatabaseLive;
import model.Bet;
import model.BetList;
import model.ModelloStatistiche;
import model.Utente;
import model.currencyHistorical;
/**
 * Il PrincipalService contiene una serie di 
 * metodi che vengono poi richiamati nel controller
 * 
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 *
 */

@org.springframework.stereotype.Service
public class PrincipalService {
	
	public static double TassoCambio;
	public static String valuta1;
	public static String valuta2;
	public static Utente utente = new Utente();
	
	public HashMap<String, String> getMetadati(String classe) {
		if(classe == "bet") return Metadati.mdBet;
		else if(classe == "currencies") return Metadati.mdCurr;
		else if(classe == "statistics") return Metadati.mdStats;
		else throw new NoParam();
	}

	
	public static ArrayList<String> GetValute() throws Exception {
		return DatabaseLive.ValuteLive();
	}
	/*
	public static currencyHistorical GetValorelive() throws Exception{
		return DatabaseLive.ValuteLive();
	}*/
	
	public static ArrayList<currencyHistorical> GetValoriStorici(String from, String to,String currencies) throws Exception{
		return DatabaseHistorical.GetValuteStoriche(from, to, currencies);
	}
	
	
	
	public static HashMap<String,ModelloStatistiche> getStatistics(String from, String to,String currencies) throws Exception{
		return HashMapStats.createHashMap(DatabaseHistorical.GetValuteStoriche(from, to, currencies), currencies);
	}
	
	public static void CreateUtente(Utente user) throws Exception {
		utente.setNomeutente(user.getNomeutente());
	}
	
	public static String getUtente(String user) {
		if (user.equals(utente.getNomeutente()))
			return "Saldo: "+utente.getSaldo();
		else
			return "Username errato";
	}

	public static void PlaceBet(Bet b) throws Exception {
		if(Bet.Verify(b) == true)
			throw new ImportoErrato();
		BetList.setBetlist(b);
		
	}
	
	public static Collection<Bet> getAllBet(){
		Map<String, Bet> betlist = BetList.getBetlist();
		return betlist.values();
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
        //double m= Statistiche.media(DatabaseHistorical.GetValuteStoriche(DateService.PreviousWeek(), DateService.CurrentDate(), currency));
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
        double m = md.getMedia();
        //double valatt = DatabaseLive.ValutaSceltaLive(currency);
        //double m=Statistiche.media(DatabaseHistorical.GetValuteStoriche(DateService.PreviousWeek(), DateService.CurrentDate(), currency));
        double diff=valatt/m;
        quote*=diff;
        quote=Math.round(quote*100.0)/100.0;
        if(quote<=1) quote=1.01;
        
        return quote;
	}
	
	public static double getValoreLive(String currencies) throws Exception {
		return DatabaseLive.ValutaSceltaLive(currencies);
	}

}
