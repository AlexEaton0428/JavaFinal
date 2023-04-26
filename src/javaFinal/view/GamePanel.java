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
	
	private String deckID;

	private int cardIndex;
	
	private JButton stand;
	private JButton hit;
	
	private SpringLayout layout;
	private JPanel buttonPanel;
	private JPanel playerCards;
	private JPanel dealerCards;
	
	
	
	public GamePanel(Controller controller)
	{
		super();
		
		this.deckID = "";
		this.game = new BlackJack(deckID);
		this.cardIndex = 0;
				
		this.buttonPanel = new JPanel(new GridLayout(1,0));
		this.playerCards = new JPanel(new GridLayout(1,0));
		this.dealerCards = new JPanel(new GridLayout(1,0));
		this.layout= new SpringLayout();
		this.hit = new JButton("HIT");
		this.stand = new JButton("STAND");
		
		
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
		
		try
		{
			BufferedImage cardImageTwo = ImageIO.read(new File("Cards/AD.png"));
			JLabel cardLabel = new JLabel(new ImageIcon(cardImageTwo));
			this.add(cardLabel);
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
		
		this.buttonPanel.add(hit);
		this.buttonPanel.add(stand);
		
		
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 700, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 300, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 300, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 300, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		
	}
	
	private void playGame()
	{
		// add player cards as images
		// add dealer cards as images
		
	}
	
}
