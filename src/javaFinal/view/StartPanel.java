package javaFinal.view;

import javaFinal.controller.Controller;
import javax.swing.*;


public class StartPanel extends JPanel
{
	
	private JButton startButton;
	private SpringLayout layout;
	
	public StartPanel(Controller controller)
	{
		super();
		
		this.startButton = new JButton("Start");
		this.layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
