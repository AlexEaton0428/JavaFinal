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
	
	
	public BlackJack()
	{
		
		
		this.parse = new JsonToNot();
		
		// official deck ID
		this.deckID = new String("");
		this.playingCards = new Card [51];
		
		this.playerCards = new Card [5];
		this.dealerCards = new Card [5];
		
		this.cardsCombined = 0;
		
	}
	
	
	
	public void playGame()
	{
		this.deckID = parse.getNewDeck();
		addCardsToDeck();
		generateHands();
		
	}
	
	
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
	
	public Card drawCard(int index)
	{
		
//		Random number = new Random();
//		int low = 0;
//		int high = this.playingCards.length - 1;
//		int result = number.nextInt(high-low) + low;
//		
		Card newCard = playingCards[index];
		
		
		return newCard;
	}
	
	public void addCardsToDeck()
	{
			
		for (int index = 0; index < playingCards.length -1; index++)
		{
			playingCards [index] = parse.getCard(deckID);
		}
		
	}
	
	public Card [] getPlayerCards()
	{
		return playerCards;
	}
	
	public Card [] getDealerCards()
	{
		return dealerCards;
	}
	
	public String getPlayerCardValue(int index)
	{
		return playerCards[index].getValue();
	}
	
	private String getDealerCardValue(int index)
	{
		return dealerCards[index].getValue();
	}
	
	public int getIntCardValue(int cardIndex, int aceValue)
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
	
	public int stand(int cardsOut, int aceValue)
	{
		if (cardsOut == 2)
		{
			this.cardsCombined = getIntCardValue(0, aceValue) + getIntCardValue(1, aceValue);
		}
		else if (cardsOut == 3)
		{
			this.cardsCombined = getIntCardValue(0, aceValue) + getIntCardValue(1, aceValue) + getIntCardValue(2, aceValue);
		}
		else if (cardsOut == 4)
		{
			this.cardsCombined = getIntCardValue(0, aceValue) + getIntCardValue(1, aceValue) + getIntCardValue(2, aceValue) +
					+ getIntCardValue(3, aceValue);
		}
		else if (cardsOut == 5)
		{
			this.cardsCombined = getIntCardValue(0, aceValue) + getIntCardValue(1, aceValue) + getIntCardValue(2, aceValue) +
					+ getIntCardValue(3, aceValue) + + getIntCardValue(4, aceValue);
		}
		
		return this.cardsCombined;
	}
	
	 
	
	
		
	
	
	
	
	
	

}
