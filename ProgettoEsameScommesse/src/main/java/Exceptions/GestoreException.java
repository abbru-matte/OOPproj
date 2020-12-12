package Exceptions;

import java.util.Calendar;


import org.springframework.http.HttpStatus;


/**
 * 
 * Classe che funziona da modello per gli errori dovuti ad eccezioni.
 * 
 * @author Murtezi Adrian & Abbruzzetti Matteo
 */

public class GestoreException {

	private Calendar date;
	private HttpStatus httpStatus;
	private String exception;
	private String message;
	
	/**
	 * ExceptionError Constructor
	 * @param date restituisce la  data e l'orario della richiesta
	 * @param httpStatus restituisce lo stato della richiesta
	 * @param exception informa l'utente su quale eccezione è stata generata.
	 * @param message indica il messaggio dell'eccezione
	 */
	public GestoreException(Calendar date, HttpStatus httpStatus, String exception, String message) {
		super();
		this.date = date;
		this.httpStatus = httpStatus;
		this.exception = exception;
		this.message = message;
	}
	


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Calendar getDate() {
		return date;
	}


	public void setC(Calendar date) {
		this.date = date;
	}


	public String getException() {
		return exception;
	}


	public void setException(String exception) {
		this.exception = exception;
	}


}
