package service;

import java.io.IOException;



import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import Exceptions.ImportoErrato;
import Statistiche.HashMapStats;
import Statistiche.Statistiche;
import model.currencyLive;
import database.DatabaseHistorical;
import database.DatabaseLive;
import model.Bet;
import model.BetList;
import model.ModelloStatistiche;
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
		return HashMapStats.createHashMap(DatabaseHistorical.GetValuteStoriche(from, to, currencies));
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
	
	

}
