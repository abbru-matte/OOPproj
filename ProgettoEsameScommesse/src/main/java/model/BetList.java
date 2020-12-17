package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Nella classe BetList viene gestita la LinkedHashMap 'betlist' che permette il
 * caricamento delle scommesse inserite tramite la POST in Postman all'interno di una
 * memoria dinamica.
 * 
 *  @author Murtezi Adrian & Abbruzzetti Matteo
 */

public class BetList {

	private static Map<Integer, Bet> betlist= new HashMap<>();

	public static Map<Integer, Bet> getBetlist() {
		return betlist;
	}

	public static void setBetlist(Bet b) {
		betlist.put(b.getIdBet(), b);
	}
	
}
