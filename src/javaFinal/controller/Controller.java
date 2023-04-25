package javaFinal.controller;

import javax.swing.JOptionPane;
import java.io.IOException;

import javaFinal.view.GameFrame;

import javaFinal.model.WebReader;
import javaFinal.model.JsonToNot;


public class Controller
{
	private GameFrame window;
	private WebReader reader;
	private JsonToNot json;
	
	public Controller()
	{
		window = new GameFrame(this);
		reader = new WebReader(this);
		json = new JsonToNot(this);
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
	
	public void showData(String data)
	{
		JOptionPane.showMessageDialog(window, data);
	}
}
