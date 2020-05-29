package code;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Ramen {

	public String Soup;
	public String Noodles;
	public String S_O;
	public String Spiciness ;	

	public int Nori = 0;
	public int Chashu = 0;
	public int Boiled_egg = 0;	
	public int Shoots = 0;
	
	public double price_nori;
	public double price_egg;
	public double price_shoots;
	public double price_chashu;
	
	public double price = 9.99;
	

	

	public Ramen(String s1,String s2,String s3, String i1,int i2,int i3,int i4,int i5) {
		
		File file=new File("src/xls/price.xls");
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet=workbook.getSheet(0);
			
			Cell cell0=sheet.getCell(0, 1);
			Cell cell1=sheet.getCell(1, 1);
			Cell cell2=sheet.getCell(2, 1);
			Cell cell3=sheet.getCell(3, 1);
			
			
			price_nori = Double.parseDouble(cell0.getContents());
			price_egg = Double.parseDouble(cell1.getContents());
			price_shoots = Double.parseDouble(cell2.getContents());
			price_chashu = Double.parseDouble(cell3.getContents());

		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		Soup = s1;
		Noodles =s2;
		S_O = s3;
		Spiciness = i1;
		Nori = i2;
		Chashu = i3;
		Boiled_egg = i4;
		Shoots = i5;
		
		if(i2>1) price += (i2-1)*price_nori;
		if(i3>1) price += (i3-1)*price_chashu;
		if(i4>1) price += (i4-1)*price_egg;
		if(i5>0) price += i5*price_shoots;
	}
	
}

