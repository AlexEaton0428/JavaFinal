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
	private BlackJack game;
	private JsonToNot parse;
	private WebReader reader;
	private String deckID;
	
	public Controller()
	{
		this.deckID = "";
		
		this.window = new GameFrame(this);
	
		this.game = new BlackJack();
		
		this.parse = new JsonToNot();
		
		this.reader = new WebReader();
	}
	
	public void start()
	{
		
		
		
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
