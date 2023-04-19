package javaFinal.view;

import javaFinal.controller.Controller;

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
	
	private JButton stand;
	private JButton hit;
	
	private BufferedImage aceSpades;
	private SpringLayout layout;
	private JPanel buttonPanel;
	private JPanel playerCards;
	private JPanel dealerCards;
	
	public GamePanel(Controller controller)
	{
		super();
		
		try
		{
			aceSpades = ImageIO.read(new File("ace_of_spades.jpg"));
		}
		catch(IOException error)
		{
			controller.handleError(error);
		}
		
		
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
		
		this.buttonPanel.add(hit);
		this.buttonPanel.add(stand);
		
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(aceSpades, 0, 0, this);
	}
}
