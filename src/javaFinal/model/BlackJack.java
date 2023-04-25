package javaFinal.model;

import java.io.IOException;
import javaFinal.controller.Controller;

public class BlackJack
{
	private Deck playingDeck;
	private Card [] playingCards;
	private String deckID;
	
	private Card [] playerCards;
	private Card [] dealerCards;
	
	private Controller controller;
	
	public BlackJack()
	{
		// temp deck ID
		this.deckID = new String("51");
		this.playingCards = new Card [51];
		this.playingDeck = new Deck(deckID, playingCards);
		
		this.playerCards = new Card [5];
		this.dealerCards = new Card [5];
		
	}
	
	
	
	private void playGame()
	{
		generateHands();
		
		
	}
	
	private void generateHands()
	{
		for (int index = 0; index < playerCards.length; index++)
		{
			playerCards[index] = drawCard(deckID);
		}
		
		for (int index = 0; index < dealerCards.length; index++)
		{
			dealerCards[index] = drawCard(deckID);
		}
	}
	

}
