package javaFinal.controller;

import javax.swing.JOptionPane;
import java.io.IOException;

import javaFinal.view.GameFrame;


import javaFinal.model.BlackJack;


public class Controller
{
	private GameFrame window;
	private BlackJack game;
	
	public Controller()
	{
		this.window = new GameFrame(this);
	
		this.game = new BlackJack("h45nr2v12ov2");
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
