package javaFinal.view;

import javaFinal.controller.Controller;
import javaFinal.model.BlackJack;
import javaFinal.model.Card;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel
{
	
	private Controller controller;
	
	private BlackJack game;
	private Card [] playerHand;
	private Card [] dealerHand;
	
	private String deckID;
	
	private int ace;
	private int dealerAce;

	private int cardIndex;
	private int dealerCardIndex;
	
	private boolean playerTurn;
	
	private JButton standButton;
	private JButton hitButton;
	private JButton aceValue;
	private JButton resetButton;
	private JButton winButton;
	
	private SpringLayout layout;
	private JPanel buttonPanel;
	private JPanel playerCards;
	private JPanel dealerCards;
	
	private JLabel pCardLabelOne;
	private JLabel pCardLabelTwo;
	private JLabel pCardLabelThree;
	private JLabel pCardLabelFour;
	private JLabel pCardLabelFive;
	private BufferedImage pCardImageOne;
	private BufferedImage pCardImageTwo;
	private BufferedImage pCardImageThree;
	private BufferedImage pCardImageFour;
	private BufferedImage pCardImageFive;
	
	private JLabel dCardLabelOne;
	private JLabel dCardLabelTwo;
	private JLabel dCardLabelThree;
	private JLabel dCardLabelFour;
	private JLabel dCardLabelFive;
	private BufferedImage dCardImageOne;
	private BufferedImage dCardImageTwo;
	private BufferedImage dCardImageThree;
	private BufferedImage dCardImageFour;
	private BufferedImage dCardImageFive;
	
	private JLabel hiddenCardLabel;
	private BufferedImage hiddenCardImage;
	
	private JLabel cardsValue;
	private JLabel dealerCardsValue;
	
	private JPanel winPanel;
	private JLabel winLoss;
	
	
	
	public GamePanel(Controller controller)
	{
		super();
		
		this.controller = controller;
		
		this.deckID = "";
		this.game = new BlackJack();
		this.playerHand = null;
		this.dealerHand = null;
		this.cardIndex = 2;
		this.dealerCardIndex = 2;
		this.playerTurn = true;
		this.ace = 1;
		this.dealerAce = 1;
		this.dealerCardsValue = new JLabel("");
		this.winLoss = new JLabel("");
		this.cardsValue = new JLabel("");
		
		this.winPanel = new JPanel(new GridLayout(1,0));
		this.buttonPanel = new JPanel(new GridLayout(1,0));
		this.playerCards = new JPanel(new GridLayout(1,0));
		this.dealerCards = new JPanel(new GridLayout(1,0));
		this.layout= new SpringLayout();
		this.hitButton = new JButton("HIT");
		this.standButton = new JButton("STAND");
		this.resetButton = new JButton("RESET GAME");
		this.winButton = new JButton("END GAME");
		this.aceValue = new JButton("CHANGE ACE TO 11");
		
		this.pCardLabelOne = null;
		this.pCardLabelTwo = null;
		this.pCardLabelThree = null;
		this.pCardLabelFour = null;
		this.pCardLabelFive = null;
		
		this.pCardImageOne = null;
		this.pCardImageTwo = null;
		this.pCardImageThree = null;
		this.pCardImageFour = null;
		this.pCardImageFive = null;
		
		this.pCardLabelOne = null;
		this.pCardLabelTwo = null;
		this.pCardLabelThree = null;
		this.pCardLabelFour = null;
		this.pCardLabelFive = null;
		
		this.dCardImageOne = null;
		this.dCardImageTwo = null;
		this.dCardImageThree = null;
		this.dCardImageFour = null;
		this.dCardImageFive = null;
		
		this.hiddenCardLabel = null;
		this.hiddenCardImage = null;
		
		playGame();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.add(buttonPanel);
		this.add(dealerCards);
		this.add(playerCards);
		
		
		this.add(cardsValue);
		this.cardsValue.setFont(new Font("Verdana", 1, 20));
		this.winLoss.setFont(new Font("Verdana", 1, 30));
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 500, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 550, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, winPanel, 400, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, winPanel, 550, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, playerCards, 700, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, playerCards, 400, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, dealerCards, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dealerCards, 400, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, cardsValue, 650, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cardsValue, 400, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		hitButton.addActionListener( click -> hit());
		aceValue.addActionListener( click -> changeAce());
		standButton.addActionListener( click -> stand());
		resetButton.addActionListener( click -> resetGame());
		winButton.addActionListener( click -> winOrLoss());
	}
	
	private void playGame()
	{
		game.playGame();
		this.playerHand = game.getPlayerCards();
		this.dealerHand = game.getDealerCards();
		this.cardIndex = 2;
		this.dealerCardIndex = 2;
		changeCardsValue(1);
		changeCardsValue(2);
		updateScreen();
		
		this.repaint();
	}
	
	private void updateScreen()
	{
		
		if (playerTurn = true)
		{
			this.buttonPanel.add(hitButton);
			this.buttonPanel.add(standButton);
		}
		
		String playerCardOne = playerHand[0].getImage(); 
		String playerCardTwo = playerHand[1].getImage();
		String dealerCardOne = dealerHand[0].getImage(); 
	
		changeCardsValue(1);
		
		try
		{
			pCardImageOne = ImageIO.read(new File("Cards/" + playerCardOne + ".png"));
			pCardLabelOne = new JLabel(new ImageIcon(pCardImageOne));
			this.playerCards.add(pCardLabelOne);
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		try
		{
			pCardImageTwo = ImageIO.read(new File("Cards/" + playerCardTwo + ".png"));
			pCardLabelTwo = new JLabel(new ImageIcon(pCardImageTwo));
			this.playerCards.add(pCardLabelTwo);
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		try
		{
			dCardImageOne = ImageIO.read(new File("Cards/" + dealerCardOne + ".png"));
			dCardLabelOne = new JLabel(new ImageIcon(dCardImageOne));
			this.dealerCards.add(dCardLabelOne);
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		try
		{
			hiddenCardImage = ImageIO.read(new File("Cards/hidden.png"));
			hiddenCardLabel = new JLabel(new ImageIcon(hiddenCardImage));
			this.dealerCards.add(hiddenCardLabel);
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		for (int index = 1; index <= cardIndex; index++)
		{
			if (playerHand[index - 1].getImage().contains("A"))
			{
				buttonPanel.add(aceValue);
				buttonPanel.repaint();
			}
		}
		
		this.repaint();
		cardsValue.repaint();
	}
	
	private void hit()
	{
		if (game.playerTotal(cardIndex, ace) <= 21)
		{
			if (cardIndex == 2)
			{
				String playerCardThree = playerHand[2].getImage();
				System.out.println(playerCardThree);
				try
				{
					pCardImageThree = ImageIO.read(new File("Cards/" + playerCardThree + ".png"));
					
					pCardLabelThree = new JLabel(new ImageIcon(pCardImageThree));
					this.playerCards.add(pCardLabelThree);
				}
				catch (IOException error)
				{
					error.printStackTrace();
				}
			}
			
			else if (cardIndex == 3)
			{
				String playerCardFour = playerHand[3].getImage();
				System.out.println(playerCardFour);
				try
				{
					pCardImageFour = ImageIO.read(new File("Cards/" + playerCardFour + ".png"));
					
					pCardLabelFour = new JLabel(new ImageIcon(pCardImageFour));
					this.playerCards.add(pCardLabelFour);
				}
				catch (IOException error)
				{
					error.printStackTrace();
				}
			}
			
			else if (cardIndex == 4)
			{
				this.buttonPanel.remove(hitButton);
				buttonPanel.repaint();
				String playerCardFive = playerHand[4].getImage();
				System.out.println(playerCardFive);
				try
				{
					pCardImageFive = ImageIO.read(new File("Cards/" + playerCardFive + ".png"));
					
					pCardLabelFive = new JLabel(new ImageIcon(pCardImageFive));
					this.playerCards.add(pCardLabelFive);
				}
				catch (IOException error)
				{
					error.printStackTrace();
				}
			}
			
			
			
			this.cardIndex += 1;
			
			for (int index = 1; index <= cardIndex; index++)
			{
				if (playerHand[index - 1].getImage().contains("A"))
				{
					buttonPanel.add(aceValue);
					buttonPanel.repaint();
				}
			}
			
			playerCards.repaint();
			this.repaint();
			changeCardsValue(1);
			cardsValue.repaint();
			
			if (game.playerTotal(cardIndex, ace) > 21)
			{
				buttonPanel.remove(hitButton);
				buttonPanel.repaint();
				
				cardsValue.setText(game.playerTotal(cardIndex, ace) + " BUST!");
				cardsValue.repaint();
				
				standing();
			}
		}
		
		repaintAll();
			
		
	}
	
	private void standing()
	{
		
		
		
		this.repaint();
		
		if (this.dealerCardIndex == 2)
		{
			
			
			String dealerCardTwo = dealerHand[1].getImage();
			System.out.println("dealer card 2 " + dealerCardTwo);
			this.buttonPanel.remove(hitButton);
			this.buttonPanel.remove(standButton);
			buttonPanel.repaint();
			try
			{
				dCardImageTwo = ImageIO.read(new File("Cards/" + dealerCardTwo + ".png"));
				dCardLabelTwo = new JLabel(new ImageIcon(dCardImageTwo));
				this.dealerCards.add(dCardLabelTwo);
				
				this.dealerCards.remove(hiddenCardLabel);
				dealerCards.repaint();
			}
			catch (IOException error)
			{
				error.printStackTrace();
			}
			
			if (game.dealerTotal(cardIndex, dealerAce) <= 18)
			{
				String dealerCardThree = dealerHand[2].getImage();
				System.out.println("dealer card 3 " + dealerCardThree);
				
				try
				{
					dCardImageThree = ImageIO.read(new File("Cards/" + dealerCardThree + ".png"));
					dCardLabelThree = new JLabel(new ImageIcon(dCardImageThree));
					this.dealerCards.add(dCardLabelThree);
					
					this.dealerCards.remove(hiddenCardLabel);
					dealerCards.repaint();
				}
				catch (IOException error)
				{
					error.printStackTrace();
				}
				
				
				if (game.dealerTotal(cardIndex, dealerAce) <= 18)
				{
					String dealerCardFour = dealerHand[3].getImage();
					System.out.println("dealer card 4 " + dealerCardThree);
					
					try
					{
						dCardImageFour = ImageIO.read(new File("Cards/" + dealerCardFour + ".png"));
						dCardLabelFour = new JLabel(new ImageIcon(dCardImageFour));
						this.dealerCards.add(dCardLabelFour);
						
						dealerCards.repaint();
					}
					catch (IOException error)
					{
						error.printStackTrace();
					}
				}
			}
			changeCardsValue(2);
		}
		
		boolean aceCondition = false;
		
		for (int index = 0; index <= dealerCardIndex; index++)
		{
			if (dealerHand[index].getImage().contains("A"))
			{
				aceCondition = true;
			}
		}
		
		if (game.dealerTotal(dealerCardIndex, 11) <= 21 && aceCondition)
		{
			changeDealerAce();
		}
		
		this.dealerCardIndex += 1;
		
		this.buttonPanel.add(winButton);
		
		buttonPanel.repaint();
		dealerCards.repaint();
		dealerCards.revalidate();
		repaintAll();
	}
	
	private void changeAce()
	{
		if (ace == 1)
		{
			this.ace = 11;
			changeCardsValue(1);
			cardsValue.repaint();
			
			aceValue.setText("CHANGE ACE TO 1");
			buttonPanel.repaint();
		}
		else
		{
			this.ace = 1;
			changeCardsValue(1);
			cardsValue.repaint(1);
			
			aceValue.setText("CHANGE ACE TO 11");
			buttonPanel.repaint();
		}
		buttonPanel.revalidate();
		repaintAll();
	}
	
	private void changeDealerAce()
	{
		dealerAce = 11;
		changeCardsValue(2);
		cardsValue.repaint();
		
	}
	
	private void changeCardsValue(int deck)
	{
		if (deck == 1)
		{
			cardsValue.setText("Your Cards total " + game.playerTotal(cardIndex, ace));
		}
		else if (deck == 2)
		{
			dealerCardsValue.setText("Dealer Cards total " + game.dealerTotal(dealerCardIndex, dealerAce));
		}
		
		cardsValue.repaint();
		dealerCardsValue.repaint();
		
		repaintAll();
	}
	
	private void resetGame()
	{
		this.deckID = "";
		this.game = new BlackJack();
		this.playerHand = null;
		this.dealerHand = null;
		
		this.playerTurn = true;
		this.ace = 1;
		
		winPanel.remove(winLoss);
		buttonPanel.remove(resetButton);
		playerCards.removeAll();
		dealerCards.removeAll();
		
		playGame();
		
		this.repaint();
	}
	
	private void stand()
	{
		standing();
		dealerCards.repaint();
		this.repaint();
	}
	
	private void winOrLoss()
	{
		int pTotal = game.playerTotal(cardIndex, ace);
		int dTotal = game.dealerTotal(dealerCardIndex, dealerAce);
		
		cardsValue.setText("This isnt working right player total is: " + pTotal + dTotal);
		
		if (pTotal > 21)
		{
			cardsValue.setText("Sorry You Lost! : Play Again!");
		}
		
		else if (dTotal == pTotal)
		{
			cardsValue.setText("Sorry You Tied! : Play Again!");
		}
		
		else if(dTotal <= 21 && pTotal <= 21)
		{
			if (pTotal < dTotal)
			{
				cardsValue.setText("Sorry You Lost! : Play Again!");
			}
			else if(dTotal < pTotal)
			{
				cardsValue.setText("You Won! : Play Again!");
			}
		}
		
		else if (dTotal > 21 && pTotal <= 21)
		{
			cardsValue.setText("You Won! : Play Again!");
		}
		

		this.buttonPanel.removeAll();
		
		cardsValue.repaint();
		this.buttonPanel.add(resetButton);
		repaintAll();
	}
	
	private void repaintAll()
	{
		winPanel.repaint();
		buttonPanel.repaint();
		playerCards.repaint();
		dealerCards.repaint();
		this.repaint();
	}
}
