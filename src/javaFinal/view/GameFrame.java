package javaFinal.view;

import javaFinal.controller.Controller;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame
{
	
	private GamePanel gamePanel;
	
	private Controller controller;
	
	public GameFrame(Controller controller)
	{
		
		super();
		
		this.controller = controller;
		this.gamePanel = new GamePanel(this.controller);
		
		setupFrame();
		
	}
	
	private void setupFrame()
	{
		this.setSize(1750, 1225);
		this.setTitle("Mini Black Jack");
		this.add(gamePanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

}
