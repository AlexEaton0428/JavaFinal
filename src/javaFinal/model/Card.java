package javaFinal.model;

public class Card 
{
	
	private String suit;
	private String value;
	
	public Card()
	{
		this.suit = "";
		this.value = "";
	}
	
	private String getSuit()
	{
		return this.suit;
	}
	
	private String getValue()
	{
		return this.value;
	}
	
	private void setSuit(String newSuit)
	{
		this.suit = newSuit;
	}
	
	private void setValue(String newValue)
	{
		this.suit = newValue;
	}
}