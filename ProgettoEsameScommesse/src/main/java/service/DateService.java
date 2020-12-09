package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import Exceptions.DateExc;
import Exceptions.FormatoData;
public class DateService {
	
	private static Date date1;
	private static Date date2;
	public static int DAY = (24 * 60 * 60 * 1000);
	
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
	
	
	public static Vector<String> ArrayDays(String from, String to) throws Exception {
		
		
		
		Long periodo = getPeriod(from, to);

		Vector<String> giorni = new Vector<String>();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i <= periodo; i++) {
			giorni.add(df.format(date1));
			date1.setTime((date1.getTime() + DAY));
		}
		return giorni;
		
	}
	
	public static long getPeriod(String from, String to) throws Exception {
		CheckDate(from, to);
		
		return ((date2.getTime() - date1.getTime()) / (DAY));
	}


	
}
