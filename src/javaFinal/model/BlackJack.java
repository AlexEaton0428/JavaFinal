package javaFinal.model;

public class BlackJack
{
	private int playerCards[];
	
	public BlackJack()
	{
		
	}
	
	private void playGame()
	{
		
		
	}
	
	private String hit()
	{
		String card = drawCard();
		
		return card;
	}
	
	private void stand()
	{
		countPlayerCards(playerCards);
		
	}
	
	private String shuffleCards(String deckID)
	{
		return deckID;
	}
	
	private String drawCard()
	{
		
		String card = "";
		
		return card;
	}
	
	private int countPlayerCards(int playerCards[])
	{
		int cardValues = 0;
		
		return cardValues;
	}
	
	private int countDealerCards(int dealerCards[])
	{
		int cardValues = 0;
		
		return cardValues;
	}
	
	private boolean winCheck(int playerCount, int dealerCount)
	{
		boolean win = false;
		
		return win;
	}
}
