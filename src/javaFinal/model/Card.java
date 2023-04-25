package javaFinal.model;

public class Card 
{
	
	private String suit;
	private int value;
	private String imageFile;
	
	public Card(String suit, int value, String imageFile)
	{
		this.suit = "";
		this.value = 0;
		this.imageFile = "";
	}
	
	public String getSuit()
	{
		return this.suit;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public void setSuit(String newSuit)
	{
		this.suit = newSuit;
	}
	
	public void setValue(String newValue)
	{
		this.suit = newValue;
	}
	
	public void setImage(String newImageFile)
	{
		this.imageFile = newImageFile;
	}
}