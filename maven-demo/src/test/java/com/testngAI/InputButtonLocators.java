package com.testngAI;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputButtonLocators 
{
//	public static String html = "<input class=\"ais-SearchBox-input\" id=\"doc-search-box-input\" name=\"query\" type=\"search\" placeholder=\"Search across browserstack.com\" autocomplete=\"off\" autocorrect=\"off\" autocapitalize=\"off\" maxlength=\"512\" autofocus aria-label=\"Search across browserstack.com\">\r\n"
//			+ "<input type=\"hidden\" value=\"all\" name=\"type\">\r\n"
//			+ "<input autocomplete=\"off\" class=\"text input-lg input-primary input-margin\" id=\"live-form-url\" name=\"url\" placeholder=\"www.website.com\" type=\"text\" aria-label=\"Type URL\" aria-required=\"true\">\r\n"
//			+ "<input id=\"live-form-submit-btn\" class=\"btn-lg btn-primary\" data-btndisabled=\"Validating...\" data-btntext=\"Start test\" type=\"submit\" value=\"Start test\" role=\"button\">\r\n"
//			+ "<input autocomplete=\"off\" class=\"text input-lg input-primary input-margin\" id=\"live-local-testing-url\" name=\"url\" placeholder=\"www.website.com\" type=\"text\" aria-label=\"Type URL\" aria-required=\"true\">\r\n"
//			+ "<input id=\"live-local-testing-submit-btn\" class=\"live-local-testing-form__btnholder-btn btn-lg btn-primary\" data-btndisabled=\"Validating...\" data-btntext=\"Start test\" type=\"submit\" value=\"Start test\" role=\"button\">";

    public static void inputLocator(String htmlinput) 
    {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("InputLocators");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("0", new Object[] {"S.No", "Input", "Loc1", "Loc2", "Loc3", "Loc4", "Loc5", "Loc6", "Loc7"});
//        data.put("2", new Object[] {1, "Amit", "Shukla"});
//        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
//        data.put("4", new Object[] {3, "John", "Adwards"});
//        data.put("5", new Object[] {4, "Brian", "Schultz"});
          
        String htmlsplit[] = htmlinput.split("<input ");
    	System.out.println("Lenght%%%^^^:              "+htmlsplit.length);
    	for(int i=0;i<htmlsplit.length;i++)
    	{
//    		data.put(""+i+1 , new Object[] {"S.No", "Input", "Loc1", "Loc2", "Loc3", "Loc4", "Loc5", "Loc6", "Loc7"});
    		System.out.println("<input "+htmlsplit[i]);
    		String htmlsplit2[] = htmlsplit[i].split("\" ");
    		
    		String locatorname = htmlsplit2[0].replace("=", "").replace("\"", "");
    				
    		for(int ii=1;ii<htmlsplit2.length;ii++)
    		{
    			System.out.print(" "+htmlsplit2[ii]);
    			if(ii==0) {
    		     data.put(""+(i+1), new Object[] {""+(i), "Input_"+locatorname, ""+htmlsplit2[0].replace(">", "")+"\"", "", "", "", "", "", ""});
    			}
    			if(ii==1) {
       		     data.put(""+(i+1), new Object[] {""+(i), "Input_"+locatorname, ""+htmlsplit2[0].replace(">", "")+"\"", ""+htmlsplit2[1].replace(">", "")+"\"", "", "", "", "", ""});
       			}
    			if(ii==2) {
          		 data.put(""+(i+1), new Object[] {""+(i), "Input_"+locatorname, ""+htmlsplit2[0].replace(">", "")+"\"", ""+htmlsplit2[1].replace(">", "")+"\"", ""+htmlsplit2[2].replace(">", "")+"\"", "", "", "", ""});
          		}
    			if(ii==3) {
             		 data.put(""+(i+1), new Object[] {""+(i), "Input_"+locatorname, ""+htmlsplit2[0].replace(">", "")+"\"", ""+htmlsplit2[1].replace(">", "")+"\"", ""+htmlsplit2[2].replace(">", "")+"\"", ""+htmlsplit2[3].replace(">", "")+"\"", "", "", ""});
             	}
    		}
    	}
    	
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        System.out.println("%%%%%%%%:  "+"hgg>".replace(">", ""));
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\infok\\OneDrive\\Desktop\\Input.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    
    public static void buttonLocator(String htmlinput) 
    {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("InputLocators");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("0", new Object[] {"S.No", "Button", "Loc1", "Loc2", "Loc3", "Loc4", "Loc5", "Loc6", "Loc7"});
//        data.put("2", new Object[] {1, "Amit", "Shukla"});
//        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
//        data.put("4", new Object[] {3, "John", "Adwards"});
//        data.put("5", new Object[] {4, "Brian", "Schultz"});
          
        String htmlsplit[] = htmlinput.split("<button ");
    	System.out.println("Lenght%%%^^^:              "+htmlsplit.length);
    	for(int i=0;i<htmlsplit.length;i++)
    	{
//    		data.put(""+i+1 , new Object[] {"S.No", "Input", "Loc1", "Loc2", "Loc3", "Loc4", "Loc5", "Loc6", "Loc7"});
    		System.out.println("<button "+htmlsplit[i]);
    		String htmlsplit2[] = htmlsplit[i].split("\" ");
    		
    		String locatorname = htmlsplit2[0].replace("=", "").replace("\"", "");
    				
    		for(int ii=1;ii<htmlsplit2.length;ii++)
    		{
    			System.out.print(" "+htmlsplit2[ii]);
    			if(ii==0) {
    		     data.put(""+(i+1), new Object[] {""+(i), "Button_"+locatorname, ""+htmlsplit2[0].replace(">", "")+"\"", "", "", "", "", "", ""});
    			}
    			if(ii==1) {
       		     data.put(""+(i+1), new Object[] {""+(i), "Button_"+locatorname, ""+htmlsplit2[0].replace(">", "")+"\"", ""+htmlsplit2[1].replace(">", "")+"\"", "", "", "", "", ""});
       			}
    			if(ii==2) {
          		 data.put(""+(i+1), new Object[] {""+(i), "Button_"+locatorname, ""+htmlsplit2[0].replace(">", "")+"\"", ""+htmlsplit2[1].replace(">", "")+"\"", ""+htmlsplit2[2].replace(">", "")+"\"", "", "", "", ""});
          		}
    			if(ii==3) {
             		 data.put(""+(i+1), new Object[] {""+(i), "Button_"+locatorname, ""+htmlsplit2[0].replace(">", "")+"\"", ""+htmlsplit2[1].replace(">", "")+"\"", ""+htmlsplit2[2].replace(">", "")+"\"", ""+htmlsplit2[3].replace(">", "")+"\"", "", "", ""});
             	}
    		}
    	}
    	
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        System.out.println("%%%%%%%%:  "+"hgg>".replace(">", ""));
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\infok\\OneDrive\\Desktop\\Button.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}