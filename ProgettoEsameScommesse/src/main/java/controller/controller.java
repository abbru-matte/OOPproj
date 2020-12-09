package controller;

import java.io.IOException;


import java.net.MalformedURLException;
import java.util.ArrayList;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import database.DatabaseHistorical;
import model.currencyExchange;
import database.Database;

import service.PrincipalService;
@RestController
@CrossOrigin
public class controller {
	
	
	@RequestMapping(value = "/valute", method = RequestMethod.GET)
	public ResponseEntity<Object> valute() throws Exception {
		return new ResponseEntity<>(PrincipalService.GetValute(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/currencies/statistics", method = RequestMethod.GET)
	public ResponseEntity<Object> getStatistics(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to,
			@RequestParam(name = "currencies", defaultValue = "") String currencies)
			throws Exception {
		return new ResponseEntity<>(PrincipalService.getStatistics(from, to, currencies), HttpStatus.OK);

	}







}

