package javaFinal.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

import javaFinal.controller.Controller;


public class JsonToNot 
{
	private WebReader reader;
	private Controller controller;
	private Card card;
	private String deckID;

	
	public JsonToNot() 
	{
		this.reader = new WebReader(controller);
	}
	
	public Card getCard(String deckID)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String data = reader.getInfo("https://deckofcardsapi.com/api/deck/" + deckID + "/draw/?count=1");
		
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
	        
	        this.card = new Card(value, suit, code + ".png");
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		return card;
		
		

	}
	
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
