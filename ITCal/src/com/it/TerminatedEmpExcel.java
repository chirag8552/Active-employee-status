package com.it;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TerminatedEmpExcel {
	public static void main(String[] args) {
		TerminatedEmpExcel b=new TerminatedEmpExcel();
		ArrayList l1=b.file2();
		
		for(Object x:l1){
			System.out.println(x);
		}
		
	}
	
	
	public ArrayList<String> file2(){
		short a=0;
		  int i=0,c=8,cellcount=0;
		   ArrayList<String> value=new ArrayList<String>();
		    String filename ="C:/Users/chirag.gokani/Documents/My Received Files/Terminated Employees Report for Last Month.xlsx"; 
		    
		    if (filename != null && !filename.equals("")) {
		    try{
		    
		    	FileInputStream fs =new FileInputStream(filename);
		   
		    	XSSFWorkbook wb = new XSSFWorkbook(fs);
		    	 DataFormatter df = new DataFormatter();
		    
		    for (int k = 0; k < wb.getNumberOfSheets(); k++){
		   		
		    	int j=i+1;
		   		 XSSFSheet sheet = wb.getSheetAt(k);
		   		 
		   		 int rows  = sheet.getPhysicalNumberOfRows();
		   
		/*   		 for (int r = 0; r < rows; r++){
		  		  XSSFRow row   = sheet.getRow(r);
		  		 // 	System.out.println(row.getRowNum());
		   			 XSSFCell cell1  = row.getCell(a);
		   		
		   			c++;
		   			System.out.println(c);
		   			if(cell1.getCellTypeEnum()==CellType.BLANK || df.formatCellValue(cell1)==""){
		   			System.out.println("blank");
		   				continue;
		   			}
		   			 if(cell1.getCellTypeEnum()==CellType.STRING){
		   				 System.out.println(cell1.getStringCellValue());	   				 
		   				 break;	
		   			 } 
		    }*/
		        i++;      
		   
		    for(int r=c-1;r<c;r++){
		    	XSSFRow row=sheet.getRow(r);
				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
				XSSFCell cell = (XSSFCell) cells.next();
				String temp=df.formatCellValue(cell);
	//			System.out.println(temp);
					cellcount++;			
					
					if(temp.equals("Emp Id")){
						System.out.println("break");
				break;
					}
				}
			}
		    System.out.println(cellcount);
		    
		    
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
}
