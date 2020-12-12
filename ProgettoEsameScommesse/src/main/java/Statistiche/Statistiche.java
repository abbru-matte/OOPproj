package Statistiche;

import java.io.IOException;


import java.util.ArrayList;

/**
 * La classe Statistiche contiene i metodi per la gestione
 * delle statistiche
 * 
 * @author Murtezi Adrian & Abbruzzetti Matteo
 *
 */

public class Statistiche {
	public static final String defaultcurrency = "USD";
	
	/**
	 * Metodo che calcola la media delle quote in un determinato 
	 * intervallo di tempo
	 * 
	 * @param vet indica un ArrayList contenente i valori assunti 
	 * @return ritorna la media 
	 */
	public static double media(ArrayList<Double> vet) {

		double somma = 0;
		for (int i = 0; i < vet.size(); i++)
			somma += vet.get(i);
		return (double) somma / vet.size();

	}
	
	/**
	 * Metodo che calcola la varianza 
	 * 
	 * @param vet indica un ArrayList contenente i valori assunti 
	 * @return ritorna la varianza 
	 */
	
	public static double varianza(ArrayList<Double> vet) {
		double m = media(vet);
		double e = 0;
		for (int i = 0; i < vet.size(); i++)
			e += (vet.get(i) - m) * (vet.get(i) - m);
		return e / vet.size();
	}
	
	/**
	 * Metodo che calcola la deviazione standard
	 * 
	 * @param vet indica un ArrayList contenente i valori assunti 
	 * @return ritorna la deviazione standard
	 */
	
	public static double DeviazioneStandard(ArrayList<Double> vet) {
		return Math.sqrt(varianza(vet));
	}
	/*
	
		
		//Metodo che effettua il calcolo del tasso di cambio tra due valute(storiche) in un certo periodo(tra due date)
		public static ArrayList<Double> CalcolaTassoHistorical( ArrayList<currencyHistorical> ArrHis, String code, String code2) throws JSONException, IOException {

			double rateCode = 0;
			double ratecode2 = 0;
			ArrayList<Double> ch = new ArrayList<Double>();
			for(currencyHistorical his : ArrHis) {
			rateCode = his.getQuotes().get(defaultcurrency + code);
			ratecode2 = his.getQuotes().get(defaultcurrency + code2);
			Double finalrate = ratecode2 / rateCode;
			ch.add(finalrate);
			}
			
			return ch;
		}

		*/
		
			
			
			
			
			
			
			
		

}
