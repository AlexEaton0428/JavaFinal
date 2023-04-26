package javaFinal.model;

import java.io.IOException;
import java.util.Random;
import javaFinal.controller.Controller;

public class BlackJack
{
	private JsonToNot parse;
	
	private Deck playingDeck;
	private Card [] playingCards;
	private String deckID;
	
	private Card [] playerCards;
	private Card [] dealerCards;
	
	private Controller controller;
	
	public BlackJack(String deckID)
	{
		this.parse = new JsonToNot();
		
		// official deck ID
		this.deckID = new String(deckID);
		this.playingCards = new Card [51];
		this.playingDeck = new Deck(deckID, playingCards);
		
		this.playerCards = new Card [5];
		this.dealerCards = new Card [5];
		
	}
	
	
	
	private void playGame()
	{
		addCardsToDeck();
		generateHands();
		
	}
	
	
	public void generateHands()
	{
		shuffleCards(deckID);
		
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
		//add code for getting a card from the API
		
		Random number = new Random();
		int low = 0;
		int high = this.playerCards.length - 1;
		int result = number.nextInt(high-low) + low;
		
		Card newCard = playingCards[result];
		
		return newCard;
	}
	
	private Card presentPlayerCard(int index)
	{
		return playerCards[index];
	}
	
	private Card presentDealerCard(int index)
	{
		return dealerCards[index];
	}
	
	private void shuffleCards(String deckID)
	{
		
	}
	
	public void addCardsToDeck()
	{
		for (int index = 0; index < playingCards.length; index++)
		{
			playingCards [index] = parse.getCard(deckID);
		}
	}
	
	private String getPlayerCardValue(int index)
	{
		return playerCards[index].getValue();
	}
	
	private String getDealerCardValue(int index)
	{
		return dealerCards[index].getValue();
	}
	
	
	

}
