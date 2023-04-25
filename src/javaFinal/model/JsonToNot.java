package javaFinal.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;

import javaFinal.controller.Controller;


public class JsonToNot 
{
	private WebReader reader;
	private Controller controller;
	private Card card;

	
	public JsonToNot(Controller controller) 
	{
		this.controller = controller;
		this.reader = new WebReader(controller);
	}
	
	public String getCard()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String data = reader.getInfo("https://deckofcardsapi.com/api/deck/mr61tvvg181u/draw/?count=1");
		
		String image = "";
		
		try
		{
			JsonNode node = objectMapper.readTree(data);
			
			image = node.get("cards").asText();
			
		}
		catch(IOException error)
		{
			controller.handleError(error);
		}
		
		return image;
		
		

	}
	

}
