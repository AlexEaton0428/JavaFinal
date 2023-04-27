package javaFinal.view;

import javaFinal.controller.Controller;
import javaFinal.model.BlackJack;
import javaFinal.model.Card;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
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

	private int cardIndex;
	
	private JButton standButton;
	private JButton hitButton;
	
	private SpringLayout layout;
	private JPanel buttonPanel;
	private JPanel playerCards;
	private JPanel dealerCards;
	
	private JLabel cardLabelOne;
	private JLabel cardLabelTwo;
	private BufferedImage pCardImageOne;
	private BufferedImage pCardImageTwo;
	private BufferedImage pCardImageThree;
	private BufferedImage pCardImageFour;
	private BufferedImage pCardImageFive;
	
	private BufferedImage dCardImageOne;
	private BufferedImage dCardImageTwo;
	private BufferedImage dCardImageThree;
	private BufferedImage dCardImageFour;
	private BufferedImage dCardImageFive;
	
	
	
	public GamePanel(Controller controller)
	{
		super();
		
		this.controller = controller;
		
		this.deckID = "";
		this.game = new BlackJack();
		this.playerHand = game.getPlayerCards();
		this.dealerHand = game.getDealerCards();
		this.cardIndex = 0;
				
		this.buttonPanel = new JPanel(new GridLayout(1,0));
		this.playerCards = new JPanel(new GridLayout(1,0));
		this.dealerCards = new JPanel(new GridLayout(1,0));
		this.layout= new SpringLayout();
		this.hitButton = new JButton("HIT");
		this.standButton = new JButton("STAND");
		
		
		this.cardLabelOne = null;
		this.pCardImageOne = null;
		this.pCardImageTwo = null;
		this.pCardImageThree = null;
		this.pCardImageFour = null;
		this.pCardImageFive = null;
		
		this.dCardImageOne = null;
		this.dCardImageTwo = null;
		this.dCardImageThree = null;
		this.dCardImageFour = null;
		this.dCardImageFive = null;
		
		setupPanel();
		setupLayout();
		setupListeners();
		playGame();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.add(buttonPanel);
		this.add(dealerCards);
		this.add(playerCards);
		
		
		this.buttonPanel.add(hitButton);
		this.buttonPanel.add(standButton);
		
		
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 700, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 300, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, playerCards, 300, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, playerCards, 300, SpringLayout.WEST, this);
		
	}
	
	private void setupListeners()
	{
		hitButton.addActionListener( click -> addCard());
	}
	
	private void playGame()
	{
		game.playGame();
		updateScreen();
		
		
	}
	
	private void updateScreen()
	{
		String playerCardOne = playerHand[0].getImage(); 
		String playerCardTwo = playerHand[1].getImage();
		String playerCardThree = playerHand[2].getImage();
		String playerCardFour = playerHand[3].getImage();
		String playerCardFive = playerHand[4].getImage();
		try
		{
			pCardImageOne = ImageIO.read(new File("Cards/" + playerCardOne + ".png"));
			cardLabelOne = new JLabel(new ImageIcon(pCardImageOne));
			this.playerCards.add(cardLabelOne);
			
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		if (this.cardIndex == 1)
		{
			try
			{
				
			
				pCardImageTwo = ImageIO.read(new File("Cards/" + playerCardTwo + ".png"));
				cardLabelTwo = new JLabel(new ImageIcon(pCardImageTwo));
				this.playerCards.add(cardLabelTwo);
				
				
			}
			catch (IOException error)
			{
				error.printStackTrace();
			}
			
		}
	}
	
	private void addCard()
	{
		this.cardIndex += 1;
		updateScreen();
	}
	
}
