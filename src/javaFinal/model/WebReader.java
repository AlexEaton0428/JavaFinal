package javaFinal.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class WebReader
{
	
	public WebReader()
	{
		
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
	        error.printStackTrace();
	    } 
		catch (IOException error) 
		{
			error.printStackTrace();
	    }
		
		
		return info;
	}

	
	

}

