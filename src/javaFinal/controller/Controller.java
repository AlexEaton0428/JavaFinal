package javaFinal.controller;

import javax.swing.JOptionPane;

import javaFinal.view.GameFrame;

public class Controller
{
	private GameFrame window;
	
	public Controller()
	{
		window = new GameFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public void handleError(Exception error)
	{
		JOptionPane.showMessageDialog(window, error.getMessage(), "Oops!", JOptionPane.ERROR_MESSAGE);
		
	}
}
