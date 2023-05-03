package javaFinal.view;

import javaFinal.controller.Controller;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame
{
	private JPanel panelCards;
	
	private GamePanel gamePanel;
	
	private StartPanel startPanel;
	
	private Controller controller;
	
	public GameFrame(Controller controller)
	{
		
		super();
		
		this.controller = controller;
		this.gamePanel = new GamePanel(this.controller);
		this.startPanel = new StartPanel(this.controller);
		this.panelCards = new JPanel(new CardLayout());
		
		setupFrame();
		
	}
	
	private void setupFrame()
	{
		panelCards.add(gamePanel, "Game");
		panelCards.add(startPanel, "Start");
		this.setSize(1750, 1250);
		this.setTitle("Black Jack");
		this.add(panelCards);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		replaceScreen("Start");
		
		this.setVisible(true);
	}
	
	public void replaceScreen(String screen)
	{
		((CardLayout) panelCards.getLayout()).show(panelCards, screen);
	}
}
