package javaFinal.model;

public class Deck 
{
	private String deckID;
	private Card [] cards;
	
	public Deck(String deckID, Card [] cards)
	{
		this.deckID = new String("");
		this.cards = new Card[51];
	}
	
	private void setDeckID(String newDeck)
	{
		this.deckID = newDeck;
	}
	
	private void addCard(int index, Card card)
	{
		cards[index] = card;
	}
	
	private Card getCard(int index)
	{
		return cards[index];
	}
}