package javaFinal.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import javaFinal.controller.Controller;


public class JsonToNot 
{
	private WebReader reader;
	private Controller controller;

	
	public JsonToNot(Controller controller) 
	{
		this.controller = controller;
		this.reader = new WebReader(controller);
	}
	
	public String getJsonData()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		
		String data = reader.getInfo("https://deckofcardsapi.com/api/deck/mr61tvvg181u/draw/?count=1");
		
		return data;
		
//		try
//		{
//			Card card = objectMapper.readValue(data, Card.class);
//			
//			System.out.println(card.getSuit());
//		}
//		catch(IOException error)
//		{
//			controller.handleError(error);
//		}
		
		

	}

}
