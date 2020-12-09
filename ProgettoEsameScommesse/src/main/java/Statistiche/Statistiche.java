package Statistiche;

import java.util.ArrayList;
import java.util.Vector;

public class Statistiche {
	
	public static double media(ArrayList<Double> vet) {

		double sum = 0;
		for (int i = 0; i < vet.size(); i++)
			sum += vet.get(i);
		return (double) sum / vet.size();

	}
	
	public static double varianza(ArrayList<Double> vet) {
		double m = media(vet);
		double e = 0;
		for (int i = 0; i < vet.size(); i++)
			e += (vet.get(i) - m) * (vet.get(i) - m);
		return e / vet.size();
	}
	
	public static double DeviazioneStandard(ArrayList<Double> vet) {
		return Math.sqrt(varianza(vet));
	}
	

}
