package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Stamp {
	private int Stamp_num = -1;
	private int user = -1;
	
	public void getStamp(String id) {
		try {
			File file=new File("src/xls/user.xls");
			InputStream inputStream = new FileInputStream(file.getAbsoluteFile()); 
			Workbook workbook = Workbook.getWorkbook(inputStream);
		    Sheet sheet = workbook.getSheet(0);
		    int rownum = sheet.getRows();
		    

		    for(int i=1;i<rownum;i++) {
		    	
		    	Cell cell = sheet.getCell(0, i);
		    	if(cell.getContents().equals(id)) {
		    		user = i;
		    		break;
		    	}
		    }
		    Cell cell = sheet.getCell(6, user);
		    this.Stamp_num =  Integer.parseInt(cell.getContents());
		    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int judge(String id) {
		this.getStamp(id);
		if(this.Stamp_num<10) return 0;
		else return 1;
	}
	
	public void consume(String id) {
		this.getStamp(id);
		try {
			File file=new File("src/xls/user.xls");
	
			Workbook workbook=Workbook.getWorkbook(file);
	
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
	
			WritableSheet sheet = writeBook.getSheet(0);
			
			int rownum = sheet.getRows();

		    for(int i=1;i<rownum;i++) {
		    	Cell cell = sheet.getCell(0, i);
		    	if(cell.getContents().equals(id)) {
		    		user = i;
		    		break;
		    	}
		    }
			
		    Stamp_num -= 10;
		    
			Label lable0 = new Label(6, user, Stamp_num+"");
		
			sheet.addCell(lable0);
			
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

