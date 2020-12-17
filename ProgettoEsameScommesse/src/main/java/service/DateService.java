package service;

import java.text.DateFormat;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Exceptions.IntervalloDataErrato;
import Exceptions.FormatoData;

/**
 * 
 *@author Murtezi Adrian & Abbruzzetti Matteo
 *
 */

public class DateService {
	
	private static Date date1;
	private static Date date2;
	public static int DAY = (24 * 60 * 60 * 1000);
	
	/**
	 * Metodo che verifica se la data è scritta nel modo corretto
	 * @param from indica la data d'inizio
	 * @param to indica la date di fine 
	 * @throws Exception
	 */
	
	public static void CheckDate(String from, String to) throws Exception  {

		if (from.equals("") && to.equals("")) {
			to = DateService.CurrentDate();
			from = DateService.PreviousDate();
		} else if (to.equals("")) {
			to = DateService.CurrentDate();
		}
		date1 = FormatoData.parsingData(from);
		date2 = FormatoData.parsingData(to);
	}
	
	
	
	public static String CurrentDate() {
    	Calendar cal = new GregorianCalendar();
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	return simpleDateFormat.format(cal.getTime());
	}

	public static String PreviousDate() {
    	Calendar cal = new GregorianCalendar();
    	cal.add(Calendar.DAY_OF_MONTH, -1);
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	return simpleDateFormat.format(cal.getTime());
	}
	
	
	public static String PreviousWeek() {
    	Calendar cal = new GregorianCalendar();
    	cal.add(Calendar.WEEK_OF_MONTH, -2);
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	return simpleDateFormat.format(cal.getTime());
	}
	
	/**
	 * Metodo che a partire da una data d'inizio e una data di fine
	 * ci da un ArrayList che contiene l'insieme delle date 
	 * @param from indica la data d'inizio
	 * @param to indica la data di fine
	 * @return ritorna un ArrayList contiene l'insieme di date
	 * @throws Exception
	 */
	
	public static ArrayList<String> ArrayDays(String from, String to) throws Exception {
		
		CheckDate(from, to);
		if (date2.getTime() - date1.getTime() <= 0) {
			throw new IntervalloDataErrato();
		}
		Long periodo = ((date2.getTime() - date1.getTime()) / (DAY));

		ArrayList<String> giorni = new ArrayList<String>();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i <= periodo; i++) {
			giorni.add(df.format(date1));
			date1.setTime((date1.getTime() + DAY));
		}
		return giorni;
		
	}
	
	
}
