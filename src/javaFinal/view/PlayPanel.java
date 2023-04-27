package javaFinal.view;

import javaFinal.controller.Controller;
import javax.swing.*;
import java.awt.GridLayout;

public class PlayPanel extends JPanel
{
	private Controller controller;
	private GamePanel gamePanel;
	
	private SpringLayout layout;
	
	private JPanel gameContainer;
	
	public PlayPanel(Controller controller)
	{
		super();
		
		this.controller = controller;
		this.gamePanel = new GamePanel(controller);
		
		this.gameContainer = new JPanel(new GridLayout(1,0));
		
		this.layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.add(gameContainer);
		
		this.gameContainer.add(gamePanel);
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, gamePanel, 34, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, gamePanel, -50, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, gamePanel, -34, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, gamePanel, -750, SpringLayout.EAST, this);
	}
	
	
}
