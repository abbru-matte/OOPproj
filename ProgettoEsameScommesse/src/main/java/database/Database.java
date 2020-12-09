package database;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.currencyExchange;
import service.DateService;
import database.DatabaseHistorical;
import controller.contrprova;

public class Database {
	
	public static final String ACCESS_KEY = "a54b9a9f6cf87b4b46074086c7638b32";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "historical";
    public static final String CURRENCIES = "EUR,AUD,BTC";


	public static Vector<String> GetStringsValute() throws Exception{
		
		currencyExchange p = new currencyExchange();
			
		try {
			URL url = new URL(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + contrprova.today() + "&currencies=" + CURRENCIES );
			URLConnection URLConn = url.openConnection();
			InputStream in = URLConn.getInputStream();
			
			 String dati = "";
			 String line = "";
			 try {
			   
			   BufferedReader br = new BufferedReader( new InputStreamReader( in ) );
			  
			   while ( ( line = br.readLine() ) != null ) {
				   dati+= line;
			   }
			 } finally {
			   in.close();
			 }
			 
			 ObjectMapper obj = new ObjectMapper();
			 p = obj.readValue(dati,currencyExchange.class);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Vector<String> vet = new Vector<String>();
		vet.addAll(p.quotes.keySet());
		return vet;
		
		
		//invece di arraylist creare un hashmap con keys e values
	}
	

}
