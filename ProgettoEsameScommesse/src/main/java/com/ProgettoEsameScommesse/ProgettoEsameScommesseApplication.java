package com.ProgettoEsameScommesse;


import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


import database.Database;
import database.DatabaseHistorical;
import database.DatabaseDatiUSD;

@SpringBootApplication
public class ProgettoEsameScommesseApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProgettoEsameScommesseApplication.class, args);
		//DatabaseDatiUSD.CiclaDate(2020-10-10, 2020-10-20, EUR);

		//Database.sendLiveRequest();
		//DatabaseHistorical.sendHistoricalRequest();
		//DatabaseConvert.sendConvertRequest();
		
		

		

	}
}
