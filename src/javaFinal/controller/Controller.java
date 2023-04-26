package javaFinal.controller;

import javax.swing.JOptionPane;
import java.io.IOException;

import javaFinal.view.GameFrame;

import javaFinal.model.WebReader;
import javaFinal.model.JsonToNot;
import javaFinal.model.BlackJack;


public class Controller
{
	private GameFrame window;
	private WebReader reader;
	private JsonToNot json;
	private BlackJack game;
	
	public Controller()
	{
		this.window = new GameFrame(this);
		this.reader = new WebReader(this);
		this.json = new JsonToNot();
		this.game = new BlackJack("ftp95hugmt3d");
	}
	
	public void start()
	{
		game.addCardsToDeck();
		game.generateHands();
		System.out.println(game.drawCard().getSuit());
		
	}
	
	public void handleError(Exception error)
	{
		JOptionPane.showMessageDialog(window, error.getMessage(), "Oops!", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void play()
	{
		window.replaceScreen("Game");
	}
	
	public void showData(String data)
	{
		JOptionPane.showMessageDialog(window, data);
	}

}
