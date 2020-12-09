package model;

import java.util.ArrayList;
import java.util.Vector;

public class ModelloStatistiche {
	
	private ArrayList<Double> Values;

	private Double Media;
	
	private Double Varianza;

	private Double DeviazioneStandard;

	/**
	 * @param vet 
	 * @param media
	 * @param varianza
	 * @param deviazioneStandard
	 */
	public ModelloStatistiche(ArrayList<Double> vet, Double media, Double varianza, Double deviazioneStandard) {
		super();
		Values = vet;
		Media = media;
		Varianza = varianza;
		DeviazioneStandard = deviazioneStandard;
	}

	public ArrayList<Double> getValues() {
		return Values;
	}

	public void setValues(ArrayList<Double> values) {
		Values = values;
	}

	public Double getMedia() {
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

	

}
