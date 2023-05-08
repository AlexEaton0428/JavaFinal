package javaFinal.controller;

import javax.swing.JOptionPane;
import java.io.IOException;

import javaFinal.view.GameFrame;

import javaFinal.model.JsonToNot;
import javaFinal.model.BlackJack;
import javaFinal.model.WebReader;

public class Controller
{
	private GameFrame window;
	
	
	// Initializes instance of GameFrame as window
	public Controller()
	{
		this.window = new GameFrame(this);
	}
	
	// Empty
	public void start()
	{
		
	}
	
	// Used for error handling throughout project
	public void handleError(Exception error)
	{
		JOptionPane.showMessageDialog(window, error.getMessage(), "Oops!", JOptionPane.ERROR_MESSAGE);
		
	}


	
	
	
}
