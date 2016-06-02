package fr.pizzeria.admin.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TokenService {
	
	private List<String> tokensValides = new ArrayList<String>();
	
	public String generateNewToken () {
		String token = UUID.randomUUID().toString();
		tokensValides.add(token);
		return token;
		//throw new UnsupportedOperationException();
	}
	
	public boolean isTokenValid (String token) {
		return tokensValides.contains(token);
		//throw new UnsupportedOperationException();
	}
	
}
