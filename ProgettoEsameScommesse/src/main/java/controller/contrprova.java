package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import service.DateService;

public class contrprova {
	private static final int DAY = (24 * 60 * 60 * 1000);

	private static Date from_date;
	private static Date to_date;

	public static void dateVerify(String from, String to) throws ParseException, Exception {

		if (from.equals("") && to.equals("")) {
			to = today();
			from = yesterday();
		} else if (to.equals("")) {
			to = today();
		}
		from_date = new SimpleDateFormat("yyyy-MM-dd").parse(from);
		to_date = new SimpleDateFormat("yyyy-MM-dd").parse(to);

	}

	public static Vector<String> dateRange(String from, String to) throws  Exception {

		Long period = getPeriod(from, to);

		Vector<String> days = new Vector<String>();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i <= period; i++) {
			days.add(df.format(from_date));
			from_date.setTime((from_date.getTime() + DAY));
		}
		return days;
	}

	public static String today() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(today);
	}

	public static String yesterday() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(today.getTime() - DAY);
	}

	public static long getPeriod(String from, String to) throws Exception {
		dateVerify(from, to);
		
		return ((to_date.getTime() - from_date.getTime()) / (DAY));
	}
	

}
