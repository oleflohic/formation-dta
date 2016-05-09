package com.bankonet.model;

/**
 * Classe utilisee pour lancer les exceptions liees à la partie "metier"
 * de l'application Bankonet.
 * 
 * @author fguibert
 */
public class BankonetException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8179813305563241451L;

	public BankonetException()
	{
		super();
	}
	
	public BankonetException(String _message) {
		super(_message);
	}
	
}
