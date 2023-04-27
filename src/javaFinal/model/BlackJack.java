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
	
	
	public BlackJack()
	{
		
		
		this.parse = new JsonToNot();
		
		// official deck ID
		this.deckID = new String("");
		this.playingCards = new Card [51];
		
		this.playerCards = new Card [5];
		this.dealerCards = new Card [5];
		
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
			playerCards[index] = drawCard();
		}
		
		for (int index = 0; index < dealerCards.length; index++)
		{
			dealerCards[index] = drawCard();
		}
	}
	
	public Card drawCard()
	{
		
		Random number = new Random();
		int low = 0;
		int high = this.playerCards.length - 1;
		int result = number.nextInt(high-low) + low;
		
		Card newCard = playingCards[result];
		
		return newCard;
	}
	
	public void addCardsToDeck()
	{
		for (int index = 0; index < playingCards.length; index++)
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
	
	private String getPlayerCardValue(int index)
	{
		return playerCards[index].getValue();
	}
	
	private String getDealerCardValue(int index)
	{
		return dealerCards[index].getValue();
	}
	
	private Card presentPlayerCard(int index)
	{
		return playerCards[index];
	}
	
	private Card presentDealerCard(int index)
	{
		return dealerCards[index];
	}
	
	
	

}
