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
	
	private boolean playerTurn;
	
	private JButton standButton;
	private JButton hitButton;
	
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
	
	
	
	public GamePanel(Controller controller)
	{
		super();
		
		this.controller = controller;
		
		this.deckID = "";
		this.game = new BlackJack();
		this.playerHand = game.getPlayerCards();
		this.dealerHand = game.getDealerCards();
		this.cardIndex = 0;
		this.playerTurn = true;
				
		this.buttonPanel = new JPanel(new GridLayout(1,0));
		this.playerCards = new JPanel(new GridLayout(1,0));
		this.dealerCards = new JPanel(new GridLayout(1,0));
		this.layout= new SpringLayout();
		this.hitButton = new JButton("HIT");
		this.standButton = new JButton("STAND");
		
		
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
		
		
		
		
		
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 250, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 250, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, playerCards, 700, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, playerCards, 600, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, dealerCards, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dealerCards, 600, SpringLayout.WEST, this);
		
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
		
		if (playerTurn = true)
		{
			this.buttonPanel.add(hitButton);
			this.buttonPanel.add(standButton);
		}
		
		String playerCardOne = playerHand[0].getImage(); 
		String playerCardTwo = playerHand[1].getImage();
		String playerCardThree = playerHand[2].getImage();
		String playerCardFour = playerHand[3].getImage();
		String playerCardFive = playerHand[4].getImage();
		
		String dealerCardOne = dealerHand[0].getImage(); 
		String dealerCardTwo = dealerHand[1].getImage();
		String dealerCardThree = dealerHand[2].getImage();
		String dealerCardFour = dealerHand[3].getImage();
		String dealerCardFive = dealerHand[4].getImage();
		
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
			pCardImageTwo = ImageIO.read(new File("Cards/" + playerCardThree + ".png"));
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
		
	}
	
	private void addCard()
	{
		this.cardIndex = 1;
		updateScreen();
	}
	
	
}
