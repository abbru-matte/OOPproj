package model;

import java.util.ArrayList;
import java.util.Vector;

/**
 * La classe ModelloStatistiche è un modello per la gestione delle
 * statistiche. Contiene gli attributi values, media, varianza e 
 * deviazione standard.
 * 
 * @author Murtezi Adrian & Abbruzzetti Matteo
 *
 *
 */

public class ModelloStatistiche {
	
	private ArrayList<Double> Values;

	private	static Double Media;
	
	private Double Varianza;

	private Double DeviazioneStandard;
	
	private String Message;

	/**
	 * @param values
	 * @param media
	 * @param varianza
	 * @param deviazioneStandard
	 * @param message
	 */
	public ModelloStatistiche(ArrayList<Double> values, Double media, Double varianza, Double deviazioneStandard,
			String message) {
		super();
		Values = values;
		Media = media;
		Varianza = varianza;
		DeviazioneStandard = deviazioneStandard;
		Message = message;
	}

	public ArrayList<Double> getValues() {
		return Values;
	}

	public void setValues(ArrayList<Double> values) {
		Values = values;
	}

	public static Double getMedia() {
		return Media;
	}

	public void setMedia(Double media) {
		Media = media;
	}

	public Double getVarianza() {
		return Varianza;
	}

	public void setVarianza(Double varianza) {
		Varianza = varianza;
	}

	public Double getDeviazioneStandard() {
		return DeviazioneStandard;
	}

	public void setDeviazioneStandard(Double deviazioneStandard) {
		DeviazioneStandard = deviazioneStandard;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	

	

}
