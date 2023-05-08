package javaFinal.model;

import java.io.IOException;
import java.util.Random;
import javaFinal.controller.Controller;

public class BlackJack
{
	private JsonToNot parse;
	
	private Card [] playingCards;
	private String deckID;
	
	private Card [] playerCards;
	private Card [] dealerCards;
	
	private int cardsCombined;
	
	private int dealerCardsCombined;
	
	// Initializes new instance of the JsonToNot class, initializes card deck arrays and other data members
	public BlackJack()
	{
		this.parse = new JsonToNot();
		
		// official deck ID
		this.deckID = new String("");
		this.playingCards = new Card [51];
		
		this.playerCards = new Card [5];
		this.dealerCards = new Card [5];
		
		this.cardsCombined = 0;
		this.dealerCardsCombined = 0;
	}
	
	
	// Gets new deckID from JsonToNot class, adds cards to main deck, adds cards from the main deck to player and dealer hands
	public void playGame()
	{
		this.deckID = parse.getNewDeck();
		addCardsToDeck();
		generateHands();
		
	}
	
	// Draws card from deck for every open slot in the player and dealer hands
	public void generateHands()
	{
		
		for (int index = 0; index < playerCards.length; index++)
		{
			playerCards[index] = drawCard(index);
		}
		
		for (int index = 0; index < dealerCards.length; index++)
		{
			dealerCards[index] = drawCard(index + 7);
		}
	}
	
	// returns a card from the main card deck. Takes index as a parameter - this insures that the same cards are not getting drawn
	public Card drawCard(int index)
	{
		Card newCard = playingCards[index];
		
		return newCard;
	}
	
	// Fills main card deck with cards created by the JsonToNot getCard method
	public void addCardsToDeck()
	{
			
		for (int index = 0; index < playingCards.length -1; index++)
		{
			playingCards [index] = parse.getCard(deckID);
		}
		
	}
	
	// Returns the playerHand array
	public Card [] getPlayerCards()
	{
		return playerCards;
	}
	
	// Returns the dealerHand array
	public Card [] getDealerCards()
	{
		return dealerCards;
	}
	
	// Uses the getValue method from Card to get the value of a specified card in a the player deck. Takes index as a parameter to choose which card
	public String getPlayerCardValue(int index)
	{
		return playerCards[index].getValue();
	}
	
	// Uses the getValue method from Card to get the value of a specified card in a the dealer deck. Takes index as a parameter to choose which card
	private String getDealerCardValue(int index)
	{
		return dealerCards[index].getValue();
	}
	
	// Turns the String value of a player card into an integer based on the rules of Black Jack
	// Takes the card index and value of the ace as parameters
	public int getIntPlayer(int cardIndex, int aceValue)
	{
		int value = 0;
		String stringValue = getPlayerCardValue(cardIndex);
		
		if (stringValue.contains("K") || stringValue.contains("Q") 
				|| stringValue.contains("J") || stringValue.contains("0")) 
		{
			value = 10;
		}
		else if (stringValue.contains("A"))
		{
			value = aceValue;
		}
		else
		{
			value = Integer.parseInt(stringValue.substring(0));
		}
		
		return value;
		
	}
	
	// Turns the String value of a dealer card into an integer based on the rules of Black Jack
	// Takes the card index and value of the ace as parameters
	public int getIntDealer(int cardIndex, int aceValue)
	{
		int value = 0;
		String stringValue = getDealerCardValue(cardIndex);
		
		if (stringValue.contains("K") || stringValue.contains("Q") 
				|| stringValue.contains("J") || stringValue.contains("0")) 
		{
			value = 10;
		}
		else if (stringValue.contains("A"))
		{
			value = aceValue;
		}
		else
		{
			value = Integer.parseInt(stringValue.substring(0));
		}
		
		return value;
		
	}
	
	// Totals the values of each card in the player hand based on how many are being used. Takes cardsOut and the value of an ace as parameters
	public int playerTotal(int cardsOut, int aceValue)
	{
		
		if (cardsOut == 2)
		{
			this.cardsCombined = getIntPlayer(0, aceValue) + getIntPlayer(1, aceValue);
		}
		else if (cardsOut == 3)
		{
			this.cardsCombined = getIntPlayer(0, aceValue) + getIntPlayer(1, aceValue) + getIntPlayer(2, aceValue);
		}
		else if (cardsOut == 4)
		{
			this.cardsCombined = getIntPlayer(0, aceValue) + getIntPlayer(1, aceValue) + getIntPlayer(2, aceValue) + getIntPlayer(3, aceValue);
		}
		else if (cardsOut == 5)
		{
			this.cardsCombined =getIntPlayer(0, aceValue) + getIntPlayer(1, aceValue) + getIntPlayer(2, aceValue) + getIntPlayer(4, aceValue);
		}
		
		
		return this.cardsCombined;
	}
	
	// Totals the values of each card in the dealer hand based on how many are being used. Takes cardsOut and the value of an ace as parameters
	public int dealerTotal(int cardsOut, int aceValue)
	{
		
		if (cardsOut == 2)
		{
			this.dealerCardsCombined = getIntDealer(0, aceValue) + getIntDealer(1, aceValue);
		}
		else if (cardsOut == 3)
		{
			this.dealerCardsCombined = getIntDealer(0, aceValue) + getIntDealer(1, aceValue) + getIntDealer(2, aceValue);
		}
		else if (cardsOut == 4)
		{
			this.dealerCardsCombined = getIntDealer(0, aceValue) + getIntDealer(1, aceValue) + getIntDealer(2, aceValue) + getIntDealer(3, aceValue);
		}
		else if (cardsOut == 5)
		{
			this.dealerCardsCombined =getIntDealer(0, aceValue) + getIntDealer(1, aceValue) + getIntDealer(2, aceValue) + getIntDealer(4, aceValue);
		}
		
		
		
		return this.dealerCardsCombined;
	}
	
	
	 
	
	
		
	
	
	
	
	
	

}
