package Exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoData {
		
	Date date = new Date();
	private static String formato;
	
	
	public FormatoData() {
		formato = "yyyy-MM-dd";
	}
	
	
	public static Date parsingData(String dataDaParsare) throws ParseException{
		Date sdf =  new SimpleDateFormat("yyyy-MM-dd").parse(dataDaParsare);
		
		return sdf;
	}

}
