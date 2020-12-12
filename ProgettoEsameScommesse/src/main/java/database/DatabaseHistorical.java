package database;
import model.currencyHistorical;


import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import service.DateService;
import Exceptions.IntervalloDataErrato;
import Exceptions.FormatoData;


/**
 * 
 *
 *@author Murtezi Adrian & Abbruzzetti Matteo
 *
 */
public class DatabaseHistorical {
	public static final String ACCESS_KEY = "568cb386a5b16ba22a7a0a99b0f08f54";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "historical";
    //public static List<currencyHistorical> ListaDati = new LinkedList<>();
    public static ArrayList<currencyHistorical> datas =new ArrayList<currencyHistorical>();
    
    /**
     * Metodo che prende i dati dall'url e restituisce 
     * un vettore i valori delle valute in un
     * periodo di tempo
     * 
     * @param from indica la data di inizio
     * @param to indica la data di fine
     * @param currencies indica le valute 
     * @return 
     * @throws Exception
     */

	public static ArrayList<currencyHistorical> GetValuteStoriche(String from, String to, String currencies) throws Exception{
		
		currencyHistorical p = new currencyHistorical();
		
		ArrayList<currencyHistorical> q = new ArrayList<currencyHistorical>();
		
		ArrayList<String> days = DateService.ArrayDays(from, to);
		for(String date : days) {
			try {
				URL url = new URL(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + date + "&currencies=" + currencies );
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
				 
				 //ListaDati = ParsingDati.ParseDati(dati);
				 Gson g = new Gson(); 
				 p = g.fromJson(dati, currencyHistorical.class);

				 
				//ObjectMapper obj = new ObjectMapper();
				//p = obj.readValue(dati,currencyExchange.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			q.add(p);
		}
		return q;
		//return ListaDati;
	}
	
}