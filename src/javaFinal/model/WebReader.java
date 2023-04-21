package javaFinal.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javaFinal.controller.Controller;

public class WebReader
{
	
	public WebReader()
	{
			
	}
	
	public String getInfo(String newURL)
	{
		try
		{
			
			URL url = new URL(newURL);
			
			String info = "";
			
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) 
	        {
	            String line = null;
	        

	            while ((line = reader.readLine()) != null) 
	            {
	                info += line;
	            }
	        }
		}
		catch()
		{
			
		}
		
		return info;
	}
        
//        public String getInfo(String newURL) throws IOException
//        {
//        	URL url = new URL(newURL);
//	        
//	        String webInfo = "";
//	        
//	        URLConnection con = url.openConnection();
//	        InputStream is = con.getInputStream();
//	        
//	        
//	        
//	        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) 
//	        {
//	            String line = null;
//	        
//	            // read each line and write to System.out
//	            while ((line = br.readLine()) != null) 
//	            {
//	                webInfo += line;
//	            }
//	        }
//	        
//	        
//	        return  webInfo;
//        }



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

