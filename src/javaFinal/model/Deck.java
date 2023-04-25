package javaFinal.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonToNot 
{
//	public JsonToNot() 
//	{
//		
//	}
	
//	private String convert(String data)
	public static void main(String[] args)
	{
		String newData = "";
		String data = "{\"success\": true, \"deck_id\": \"pgmp0t2bggex\", \"cards\": [{\"code\": \"KS\", \"image\": \"https://deckofcardsapi.com/static/img/KS.png\", \"images\": {\"svg\": \"https://deckofcardsapi.com/static/img/KS.svg\", \"png\": \"https://deckofcardsapi.com/static/img/KS.png\"}, \"value\": \"KING\", \"suit\": \"SPADES\"}, {\"code\": \"QC\", \"image\": \"https://deckofcardsapi.com/static/img/QC.png\", \"images\": {\"svg\": \"https://deckofcardsapi.com/static/img/QC.svg\", \"png\": \"https://deckofcardsapi.com/static/img/QC.png\"}, \"value\": \"QUEEN\", \"suit\": \"CLUBS\"}], \"remaining\": 50}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		try
		{
			String jsonInString = data;
            Card card = mapper.readValue(jsonInString, Card.class);
            
            System.out.println(card);
		}
		catch (IOException error) 
		{
            error.printStackTrace();
        }
		
		
//		return newData;
	}
}
