package com.it;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTime {

	public static void main(String[] args) {
		
	}
	
	public String dat(String projname) {
		 String readLine = "";
   		try {

            File f = new File("C:/Users/chirag.gokani/Documents/log/"+projname+".txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            readLine = b.readLine();
           /* while ((readLine = b.readLine()) != null) { 
            	
      }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
   		return readLine;
	}
}
