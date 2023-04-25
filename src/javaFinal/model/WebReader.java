package javaFinal.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javaFinal.controller.Controller;

public class WebReader
{
	
private Controller controller;
	
	public WebReader(Controller controller)
	{
		this.controller = controller;
	}
	
	public String getInfo(String newURL)
	{
		String info = "";
		
		try 
		{
	        URL url = new URL(newURL);
	        URLConnection connection = url.openConnection();
	        InputStream content = connection.getInputStream();
	        
	        try(BufferedReader br = new BufferedReader(new InputStreamReader(content))) 
	        {
                String line = null;
            
                
                while ((line = br.readLine()) != null) 
                {
                    info += line;
                	
                }
	        }
		}
	     
		catch (MalformedURLException error) 
		{
	        controller.handleError(error);
	    } 
		catch (IOException error) 
		{
			controller.handleError(error);
	    }
		
		
		return info;
	}

	
	

}

