package database;
import model.CurrencyHistorical;


import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.google.gson.Gson;


import service.DateService;


/**
 *Classe che contiene il metodo per ricavare i valori storici delle valuta 
 *
 *@author Murtezi Adrian & Abbruzzetti Matteo
 *
 */
public class DatabaseHistorical {
<<<<<<< HEAD
	public static final String ACCESS_KEY = "c93d78b47a583604031cef64872013fc";
=======
	public static final String ACCESS_KEY = "df67a19946a6f06aa0ad368c10e9f32e";
>>>>>>> branch 'master' of https://github.com/abbru-matte/OOPproj
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "historical";
   
    
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

	public static ArrayList<CurrencyHistorical> GetValuteStoriche(String from, String to, String currencies) throws Exception{
		
		CurrencyHistorical p = new CurrencyHistorical();
		
		ArrayList<CurrencyHistorical> q = new ArrayList<CurrencyHistorical>();
		
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
				 
				
				 Gson g = new Gson(); 
				 p = g.fromJson(dati, CurrencyHistorical.class);

			} catch (IOException e) {
				e.printStackTrace();
			}
			q.add(p);
		}
		return q;
	}
	
}