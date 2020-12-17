package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Metadati {

	
	public static  HashMap<String,String> mdAll(){
		
		HashMap<String,String> hs = new HashMap<String,String>();

		hs.put("Bet:idBet", "Contiene il codice della scommessa.  Type: Integer");
		hs.put("Bet:currency", "Contiene la valuta scelta.   Type: String");
		hs.put("Bet:segno", "Contiene il tipo di scommessa [1 per sale,2 per scende].   Type: Integer");
		hs.put("Bet:quote","Contiene la quota per il tipo di scommessa scelto.   Type: Double");
		hs.put("Bet:amount","Contiene la somma di denaro scommessa.  Type: Integer");
		hs.put("Bet:prize","Contiene l'importo dell'eventuale vincita della scommessa.   Type: Double");
		hs.put("Bet:date","Contiene la data in cui viene effettuata la scommessa.   Type: String");
		hs.put("Currency:name", "Contiene il nome della valuta.  Type: String");
		hs.put("Currency:betAmount", "Contiene l'importo totale scommesso dagli utenti in quella valuta.   Type: Integer");
		hs.put("Statistiche:Values", "Contiene i valori della valuta in un periodo scelto.   Type: ArrayList<Double>");
		hs.put("Statistiche:Media", "Contiene il valore medio dei valori della valuta nel periodo scelto.   Type: Double");
		hs.put("Statistiche:Varianza", "Contiene la varianza dei valori della valuta nel periodo scelto.   Type: Double");
		hs.put("Statistiche:DeviazioneStandard","Contiene la deviazione standard dei valori della valuta nel periodo scelto (Indice di volatilità).   Type: Double");
		hs.put("Statistiche:Message","Contiene un messaggio che indica se la quotazione attuale della valuta scelta è maggiore o minore della media mensile.   Type: String");
		return hs;

	}
}

