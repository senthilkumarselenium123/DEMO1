package com.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelPOIRead {
	
	    private static FileInputStream fis;
	    private static FileOutputStream fileOut;
	    private static Workbook wb;
	    private static Sheet sh;
	    private static Cell cell;
	    private static Row row;
	    private static CellStyle cellstyle;
	    private static Color mycolor;
	    private static String excelFilePath;
	    private static Map<String, Integer> columns = new HashMap<>();

	    public static void setExcelFile(String ExcelPath, String SheetName) throws Exception {
	        try {
	            File f = new File(ExcelPath);

	            if (!f.exists()) {
	                f.createNewFile();
	                System.out.println("File doesn't exist, so created!");
	            }

	            fis = new FileInputStream(ExcelPath);
	            wb = WorkbookFactory.create(fis);
	            sh = wb.getSheet(SheetName);
	            //sh = wb.getSheetAt(0); //0 - index of 1st sheet
	            if (sh == null) {
	                sh = wb.createSheet(SheetName);
	            }

	            excelFilePath = ExcelPath;

	            //adding all the column header names to the map 'columns'
	            sh.getRow(0).forEach(cell ->{
	                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
	            });

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	public static String getCellData(int rownum, int colnum) throws Exception{
	    try{
	        cell = sh.getRow(rownum).getCell(colnum);
	        String CellData = null;
	        switch (cell.getCellType()){
	            case STRING:
	                CellData = cell.getStringCellValue();
	                break;
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell))
	                {
	                    CellData = String.valueOf(cell.getDateCellValue());
	                }
	                else
	                {
	                    CellData = String.valueOf((long)cell.getNumericCellValue());
	                }
	                break;
	            case BOOLEAN:
	                CellData = Boolean.toString(cell.getBooleanCellValue());
	                break;
	            case BLANK:
	                CellData = "";
	                break;
	        }
	        return CellData;
	    }catch (Exception e){
	        return"";
	    }
	}

	public static String getCellData(String columnName, int rownum) throws Exception {
	    return getCellData(rownum, columns.get(columnName));
	}

    public static String seleniumLocator;
	
	public static String xpath(String inputname) throws Exception {
	    setExcelFile("C:\\\\Users\\\\infok\\\\OneDrive\\\\Desktop\\\\TEST.xlsx", "Employee Data");
	    System.out.println("output");
	    for(int i=1;i<=10;i++) {
	    //System.out.println(getCellData("Input", 1));
	    String inputName = getCellData("Input", i);
	    if(inputName.equals(inputname)) {
	    	System.out.println(getCellData("Input", i));
	    	System.out.println(getCellData("Loc1", i));
		    System.out.println(getCellData("Loc2", i));
		    System.out.println(getCellData("Loc3", i));
		    seleniumLocator = "//*["+"@"+getCellData("Loc1", i)+"and @"+getCellData("Loc2", i)+"and @"+getCellData("Loc3", i)+"]";
		    break;
	    }
	    }
		return seleniumLocator;
	    
	}
	
	public static void main(String []args) throws Exception {
	    setExcelFile("C:\\\\Users\\\\infok\\\\OneDrive\\\\Desktop\\\\TEST.xlsx", "Employee Data");
	    System.out.println("output");
	    for(int i=1;i<=10;i++) {
	    //System.out.println(getCellData("Input", 1));
	    String inputName = getCellData("Input", i);
	    if(inputName.equals("Input_autocompleteoff")) {
	    	System.out.println(getCellData("Input", i));
	    	System.out.println(getCellData("Loc1", i));
		    System.out.println(getCellData("Loc2", i));
		    System.out.println(getCellData("Loc3", i));
		    break;
	    }
	    }
	    
	}
}
