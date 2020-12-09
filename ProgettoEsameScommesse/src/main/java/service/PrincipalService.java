package service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import Statistiche.HashMapStats;
import database.DatabaseDatiUSD;
import database.DatabaseLive;
import model.ModelloStatistiche;

@org.springframework.stereotype.Service
public class PrincipalService {
	
	public static Vector<String> GetValute() throws Exception {
		return DatabaseLive.GetStringsValute();
	}
	
	public static HashMap<String,ModelloStatistiche> getStatistics(String from, String to,String currencies) throws Exception{
		return HashMapStats.createHashMap(DatabaseDatiUSD.GetStringsValute(from,to,currencies));	
	}

}
