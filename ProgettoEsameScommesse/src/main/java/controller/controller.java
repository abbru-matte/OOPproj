package controller;


import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import Exceptions.ExcAbstract;
import Exceptions.GestoreException;
import Exceptions.IntervalloDataErrato;
import database.DatabaseHistorical;
import model.Bet;
import model.BetList;
import service.PrincipalService;

/**
 * Il restController serve per gestire le chiamate GET e POST in Postman
 * 
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 * 
 */
@RestController
public class controller {
	/**
	 * 
	 * @Autowired lancia automaticamente il costruttore all'avvio di Spring
	 */
	@Autowired
	PrincipalService service;
	
	
	/**
	 * Metodo che ci restituisce tutti gli scambi possibili
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/valute", method = RequestMethod.GET)
	public ResponseEntity<Object> getValute() throws Exception {
		return new ResponseEntity<>(PrincipalService.GetValute(), HttpStatus.OK);
	}
	
	
	
	/**
	 * Metodo che restituisce i metadati
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/metadati", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadati() throws Exception {
	return new ResponseEntity<>(service.getMetadati(), HttpStatus.OK);
	}
	
	
	/**
	 * Metodo che restituisce le quote di scommessa per una valuta scelta
	 * 
	 * @param currency
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/quotes", method = RequestMethod.GET)
	public ResponseEntity<Object> getBetQuotes(@RequestParam(name = "currency", defaultValue = "") String currency)
		throws Exception{
		return new ResponseEntity<>(PrincipalService.getMessaggio(currency), HttpStatus.OK);
	}
	
	
	/**
	 * L'utente fa una scommessa inserendo in formato json, tramite un metodo POST
	 * il proprio codice "idBet", la valuta su cui vuole scommettere "valute" e la
	 * somma di denaro che vuole puntare "amount"
	 * 
	 * @param bet Se la scommessa è stata fatta correttamente, ritorna un messaggio di
	 *         caricamento avvenuto, altrimenti viene lanciata l'eccezione "ImportoErrato"
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bet", method = RequestMethod.POST)
	public ResponseEntity<Object> postBet(@RequestBody Bet bet) throws Exception {
		service.PlaceBet(bet);
		service.updateCurrencies(bet);
		return new ResponseEntity<>(
				"Your bet has been placed successfully", HttpStatus.CREATED);
	}
	
	
	
	/**
	 * Metodo che restituisce tutte le scommesse inserite precedentemente
	 * @return 
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/bet", method = RequestMethod.GET)
	public ResponseEntity<Object> getBet() throws Exception{
		return new ResponseEntity<>(PrincipalService.getAllBet(), HttpStatus.OK);
	}
	
	
	/**
	 * Metodo che restituisce i valori storici
	 * @param from indica la data d'inizio
	 * @param to indica la data di fine
	 * @param currencies indica le valute scelte
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/valoristorici", method = RequestMethod.GET)
	public ResponseEntity<Object> getValoriStorici(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to,
			@RequestParam(name = "currencies", defaultValue = "") String currencies)
			throws Exception {
		return new ResponseEntity<Object>(PrincipalService.GetValoriStorici(from, to, currencies), HttpStatus.OK);
	}
	
	
	
	/**
	 * Metodo che filtra le valute in base alla quantità scommessa dagli utenti
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/classifiche", method = RequestMethod.GET)
	public ResponseEntity<Object> getClassificheScommesse() throws Exception{
		return new ResponseEntity<>(
				service.getAllcurrencies(), HttpStatus.OK);
	}
	
	
	
	/**
	 * Metodo che restituisce le statistiche
	 * @param from indica la data d'inizio
	 * @param to indica la data di fine
	 * @param currencies indica la valuta scelta
	 * @return Ritorna una HashMap con le Statistiche richieste(media,varianza e 
	 * 			deviazione standard) della valuta scelta in un certo periodo di tempo.
	 * @throws Exception
	 * @throws IntervalloDataErrato
	 */
		
	@RequestMapping(value = "/currencies/statistics", method = RequestMethod.GET)
	public ResponseEntity<Object> getStatistics(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to,
			@RequestParam(name = "currencies", defaultValue = "") String currencies)
			throws Exception, IntervalloDataErrato {
		return new ResponseEntity<Object>(PrincipalService.getStatistics(from, to, currencies), HttpStatus.OK);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Metodo per gestire le eccezioni lanciate dai metodi.
	 *
	 * @param e
	 * @return Ritorna un oggetto di tipo ExceptionError
	 */
	@ExceptionHandler(ExcAbstract.class)
	public ResponseEntity<Object> handler(ExcAbstract e) {
		GestoreException error = new GestoreException(Calendar.getInstance() , HttpStatus.BAD_REQUEST , e.getClass().getCanonicalName() , e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	







}

