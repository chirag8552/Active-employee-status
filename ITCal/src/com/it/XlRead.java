package com.it;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlRead {
	
	public static void main(String[] args) {
		XlRead x=new XlRead();
		ArrayList<String> xl=x.xlr("C:/Users/chirag.gokani/Documents/data.xlsx");
		
		for(Object y:xl){
			System.out.println(y);
		}
	}
	
	public ArrayList<String> xlr(String filename){
		short a=0;
		  int i=0,c=0,cellcount=0;
		   ArrayList<String> value=new ArrayList<String>();
		    		/*"C:/Users/chirag.gokani/Documents/All Active Employee Records (with Superiors).xlsx";*/ 
		    
		    if (filename != null && !filename.equals("")) {
		    try{
		    
		    	FileInputStream fs =new FileInputStream(filename);
		   
		    	XSSFWorkbook wb = new XSSFWorkbook(fs);
		    	 DataFormatter df = new DataFormatter();
		    
		    for (int k = 0; k < wb.getNumberOfSheets(); k++){
		   		
	//	    	int j=i+1;
		   		 XSSFSheet sheet = wb.getSheetAt(k);
		   		 
		   		 int rows  = sheet.getPhysicalNumberOfRows();
		   
		   		 for (int r = 0; r < rows; r++){
		  		  XSSFRow row   = sheet.getRow(r);
	  		  
		   			 XSSFCell cell1  = row.getCell(a);
		   		
		   			c++;
		   			if(cell1.getCellTypeEnum()==CellType.BLANK){
		   			
		   				continue;
		   			}
		   			 if(cell1.getCellTypeEnum()==CellType.STRING){
	//	   				 System.out.println(cell1.getStringCellValue());	   				 
		   				 break;	
		   			 } 
		    }
		        i++;      
		    
		    for(int r=c-1;r<c;r++){
		    	XSSFRow row=sheet.getRow(r);
				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
				XSSFCell cell = (XSSFCell) cells.next();
				String temp=df.formatCellValue(cell);
	//			System.out.println(temp);
					cellcount++;			
					
					if(temp.equals("Employee Id")){
//						System.out.println("break");
						break;
					}
				}
			}
//		    System.out.println(cellcount);
		    
		    
		    for(int r=c;r<rows;r++){
		    	XSSFRow row=sheet.getRow(r);
				XSSFCell cell=row.getCell(cellcount-1);
				String s=cell.getStringCellValue();
				value.add(s);				
			}
		    
		    }}
		    catch(Exception e){
		        System.out.println(e);
		    }
		    }
			return value;
	}
	
	public ArrayList<String> cmpxl(String file1,String file2,String projinp){
		
		
		
		ActiveEmpExcel exceldata= new ActiveEmpExcel();
		ArrayList<String> xlslist=exceldata.file2(file1);
		
		XlRead xl=new XlRead();
		ArrayList<String> xlslistint=xl.xlr(file2);
		
		xlslistint.removeAll(xlslist);
		
		try{    
	           FileWriter fw=new FileWriter("C://Users/chirag.gokani/Documents/ITCal/"+projinp+".txt");   
	           for(Object x:xlslistint)
	           fw.write(x.toString());
	           fw.write("\n");
	           fw.close();    
	          }catch(Exception e){System.out.println(e);}    
	       
		
		return xlslistint;
	}
}
