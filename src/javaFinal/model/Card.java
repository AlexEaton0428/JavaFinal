package javaFinal.model;

public class Card 
{

	private String value;
	private String suit;
	private String image;
	
	// Takes value, suit, and image as parameters. Image is a two digit code used for images and for integer values
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
	
	public String toString()
	{
		String card = "This is a " + this.value + " of " + this.suit + " with a image codeo of" + this.image;
		
		return card;
	}
}