package javaFinal.controller;

import javax.swing.JOptionPane;
import java.io.IOException;

import javaFinal.view.GameFrame;

import javaFinal.model.WebReader;

public class Controller
{
	private GameFrame window;
	private WebReader reader;
	
	public Controller()
	{
		window = new GameFrame(this);
		reader = new WebReader(this);
	}
	
	public void start()
	{
		System.out.println(reader.getInfo("https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/?count=2"));
	}
	
	public void handleError(Exception error)
	{
		JOptionPane.showMessageDialog(window, error.getMessage(), "Oops!", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void play()
	{
		window.replaceScreen("Game");
	}
}
