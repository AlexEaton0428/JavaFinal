package javaFinal.model;

import java.io.IOException;
import java.util.Random;
import javaFinal.controller.Controller;

public class BlackJack
{
	private Deck playingDeck;
	private Card [] playingCards;
	private String deckID;
	
	private Card [] playerCards;
	private Card [] dealerCards;
	
	private Controller controller;
	
	public BlackJack(String deckID, Card [] playingCards)
	{
		// official deck ID
		this.deckID = new String("eof4r8274w1x");
		this.playingCards = new Card [51];
		this.playingDeck = new Deck(deckID, playingCards);
		
		this.playerCards = new Card [5];
		this.dealerCards = new Card [5];
		
	}
	
	
	
	private void playGame()
	{
		addCardsToDeck(deckID);
		generateHands();
		
	}
	
	
	private void generateHands()
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
	
	private Card drawCard()
	{
		//add code for getting a card from the API
		
		int randomInt = (int)Math.floor(Math.random() * (0 - 52));
		
		Card newCard = playingDeck.getCard(randomInt);
		
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
	
	private void addCardsToDeck(String deckID)
	{
		for (int index = 0; index < playingCards.length; index++)
		{
			//adds new card with values taken from api
		}
	}
	
	private int getPlayerCardValue(int index)
	{
		return playerCards[index].getValue();
	}
	
	private int getDealerCardValue(int index)
	{
		return dealerCards[index].getValue();
	}
	
	private String stand(int cardOne, int cardTwo)
	{
		String winLoss = "";
		
		if (getPlayerCardValue(cardOne) + getPlayerCardValue(cardTwo) > 21)
		{
			winLoss = "Loss";
		}
		else
		{
			winLoss = "Not Loss";
		}
		
		return winLoss;
	}
	

}
