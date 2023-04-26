package javaFinal.model;

public class Card 
{

	private String value;
	private String suit;
	private String image;
	
	public Card(String newValue, String newSuit, String newImage)
	{
		this.suit = newSuit;
		this.value = newValue;
		this.image = newImage;
	}

	
	public String getSuit()
	{
		return this.suit;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public String getImage()
	{
		return this.image;
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
		this.image = newImageFile;
	}
}