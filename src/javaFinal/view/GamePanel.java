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

	private int cardIndex;
	private int dealerCardIndex;
	
	private boolean playerTurn;
	
	private JButton standButton;
	private JButton hitButton;
	private JButton aceValue;
	
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
	
	
	
	public GamePanel(Controller controller)
	{
		super();
		
		this.controller = controller;
		
		this.deckID = "";
		this.game = new BlackJack();
		this.playerHand = game.getPlayerCards();
		this.dealerHand = game.getDealerCards();
		this.cardIndex = 2;
		this.dealerCardIndex = 2;
		this.playerTurn = true;
		this.ace = 1;
				
		this.buttonPanel = new JPanel(new GridLayout(1,0));
		this.playerCards = new JPanel(new GridLayout(1,0));
		this.dealerCards = new JPanel(new GridLayout(1,0));
		this.layout= new SpringLayout();
		this.hitButton = new JButton("HIT");
		this.standButton = new JButton("STAND");
		this.aceValue = new JButton("Default Ace value is 1, click to change to 11");
		this.cardsValue = new JLabel("");
		
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
		
		
		if (game.getPlayerCardValue(0).contains("A") || game.getPlayerCardValue(1).contains("B"))
		{
			this.buttonPanel.add(aceValue);
		}
		
		
		
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 150, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, playerCards, 700, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, playerCards, 400, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, dealerCards, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dealerCards, 500, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, cardsValue, 650, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cardsValue, 400, SpringLayout.WEST, this);
		
	}
	
	private void setupListeners()
	{
		hitButton.addActionListener( click -> hit());
		aceValue.addActionListener( click -> changeAce());
		standButton.addActionListener( click -> standing());
	}
	
	private void playGame()
	{
		game.playGame();
		updateScreen();
		
		
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
		
		
		String playerCardFive = playerHand[4].getImage();
		
		String dealerCardOne = dealerHand[0].getImage(); 
		
//		String dealerCardThree = dealerHand[2].getImage();
//		String dealerCardFour = dealerHand[3].getImage();
//		String dealerCardFive = dealerHand[4].getImage();
		
		
		changeCardsValue();
		System.out.println(playerCardOne);
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
		System.out.println(playerCardTwo);
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
		System.out.println("dealer one" + dealerCardOne);
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
		
		
		
	}
	
	private void hit()
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
		
		for (Component temp : playerCards.getComponents())
		{
			JLabel card = (JLabel) temp;
			card.repaint();
			System.out.println(card.getName());
		}
		
		playerCards.repaint();
		this.repaint();
		changeCardsValue();
		cardsValue.repaint();
		
	}
	
	private void standing()
	{
		if (this.dealerCardIndex == 2)
		{
			
//			
//			String dealerCardTwo = dealerHand[1].getImage();
//			try
//			{
//			
//				dCardImageTwo = ImageIO.read(new File("Cards/" + dealerCardTwo + ".png"));
//				dCardLabelOne = new JLabel(new ImageIcon(dCardImageTwo));
//				this.dealerCards.add(dCardLabelTwo);
////				this.dealerCards.remove(hiddenCardLabel);
//			}
//			catch (IOException error)
//			{
//				error.printStackTrace();
//			}
			

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
		}
		
		this.dealerCardIndex += 1;
		dealerCards.repaint();
		this.repaint();
	}
	
	private void changeAce()
	{
		this.ace = 11;
		changeCardsValue();
		cardsValue.repaint();
	}
	
	private void changeCardsValue()
	{
		cardsValue.setText("Your Cards total " + game.stand(cardIndex, ace));
	}
	
	
}
