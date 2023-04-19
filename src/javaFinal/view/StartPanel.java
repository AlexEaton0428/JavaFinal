package javaFinal.view;

import javaFinal.controller.Controller;
import javax.swing.*;
import java.awt.GridLayout;

public class StartPanel extends JPanel
{
	
	private Controller controller;
	
	private JButton startButton;
	private SpringLayout layout;
	
	private JPanel buttonPanel;
	
	public StartPanel(Controller controller)
	{
		super();
		
		this.controller = controller;
		
		this.startButton = new JButton("Start");
		this.layout = new SpringLayout();
		this.buttonPanel = new JPanel(new GridLayout(1,0));
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.add(buttonPanel);
		
		this.buttonPanel.add(startButton);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		startButton.addActionListener(click -> controller.play());
	}
}
