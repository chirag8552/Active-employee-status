package com.it;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Scanner;

public class DBread {
	ArrayList<String> dblist = new ArrayList<String>();
	
//	Scanner sc = new Scanner(System.in);
//	String projinp=sc.next();
	

	public static void main(String args[]) throws FileNotFoundException,
			IOException {
//		DBread conn = new DBread();
//		conn.SetConn();
	}

	public void SetConn(String projinp,String filename) throws InvalidPropertiesFormatException, IOException {
		FileWriter fw=new FileWriter("C://Users/chirag.gokani/Documents/log/"+projinp+".txt");
		
		
		String driver = null;
		String url = null;
		String username = null;
		String pwd = null;
		FileInputStream fis = new FileInputStream("C:/Users/chirag.gokani/Desktop/eclipse-workspace/ITCal/src/Config.xml");
		Properties props = new Properties();
		props.loadFromXML(fis);
		 username = props.getProperty(projinp + ".username");
		 driver = props.getProperty(projinp + ".Driver");
		 url = props.getProperty(projinp + ".url");
		 pwd = props.getProperty(projinp + ".password");

		String tablename = props.getProperty(projinp + ".table");
		String columnLabel = props.getProperty(projinp + ".columnlabel");
		
		System.out.println(username+" - "+driver+" - "+url+" - "+pwd+" - "+tablename);
		
		try {
			System.out.println("hiii");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, pwd);

			if (con == null) {
				System.out.println("not connected");
			} else {
				System.out.println("connected");
			}
			Statement stmt = con.createStatement();
			System.out.println("hello");
			ResultSet rs = stmt.executeQuery("select * from " + tablename
					+ " where status=1");
			while (rs.next()) {
				String collabel = rs.getString(columnLabel);
				dblist.add(collabel);
			}
		fis.close();
	/*	for(Object x:dblist){
			System.out.println(x);
		}*/
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		
		ActiveEmpExcel exceldata= new ActiveEmpExcel();
		ArrayList<String> xlslist=exceldata.file2(filename);
		System.out.println("======================================================");
		
		ArrayList<String> rememp=new ArrayList<String>();
			
		dblist.removeAll(xlslist);
		for(Object x:dblist){
			rememp.add((String) x);
		}
		for(Object x:rememp){
			System.out.println(x);
		}
		
		try{
			int count=0;
			Class.forName(driver);  

			Connection con=DriverManager.getConnection(  
			url,username,pwd);

			for(int i=0;i<rememp.size();i++){
				String value=(String) rememp.get(i);
			 String query = "update "+tablename+" set status=0 where "+columnLabel+"=?";
		      PreparedStatement preparedStmt = con.prepareStatement(query); 
		      preparedStmt.setString(1, value);

		      count=preparedStmt.executeUpdate(); 
			}
			
		    	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		    	  Date date = new Date();
		    	  System.out.println(projinp+"  :  "+dateFormat.format(date));
	//	    	  String d=dateFormat.format(date);
		    	  fw.write(projinp+"  :  "+dateFormat.format(date));
		    	  fw.flush();
		    	  fw.close();
		      
			System.out.println("Data Updated");
	}
		 catch (Exception e) {
				// TODO: handle exception
			}
	/*	for(Object x:xlslist){
			System.out.println(x);
		}*/
	}
}
