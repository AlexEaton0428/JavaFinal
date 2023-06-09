package javaFinal.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

import javaFinal.controller.Controller;


public class JsonToNot 
{
	private WebReader reader;
	private Card card;
	private String deckID;

	// Initializes new instance of WebReader as reader
	public JsonToNot() 
	{
		this.reader = new WebReader();
	}
	
	// Takes a DeckID as a parameter. Uses WebReader to get individual Card information from the API and creates a Card object with it
	public Card getCard(String thisDeckID)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String data = reader.getInfo("https://deckofcardsapi.com/api/deck/" + thisDeckID + "/draw/?count=1");
		
		try
		{
			JsonNode node = objectMapper.readValue(data, JsonNode.class);
			JsonNode cardsNode = node.get("cards");
			JsonNode arrayNode = cardsNode.get(0);
			
			JsonNode valueNode = arrayNode.get("value");
			JsonNode suitNode = arrayNode.get("suit");
			
			JsonNode codeNode = arrayNode.path("code");
	        
	        String value = valueNode.asText();
	        String suit = suitNode.asText();
	        String code = codeNode.asText();
	        
	        this.card = new Card(value, suit, code);
	        
	 
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		return card;
		
		

	}
	
	// Uses WebReader to get a new DeckID from the API
	public String getNewDeck()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String data = reader.getInfo("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
		
		
		try
		{
			JsonNode node = objectMapper.readValue(data, JsonNode.class);
			JsonNode deckNode = node.get("deck_id");
			this.deckID  = deckNode.asText();
	        
	       
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		return  deckID;
	}
	

	

}
