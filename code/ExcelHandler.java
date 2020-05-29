package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class ExcelHandler {

	/**
	 * jxl读取文件
	 * workbook为只读文件 可以读取内容
	 */

	public static String ExcelReader(){

		File file=new File("src/xls/inventory.xls");
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet=workbook.getSheet(0);
			
			Cell cell0=sheet.getCell(2, 1);

			
			//System.out.println(cell0.getContents());
			return cell0.getContents();

		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static void Register(String pwd, String fname, String lname, String s, int check) {
		int i;
		//i is the number of rows
		
		try {
			File file=new File("src/xls/user.xls");
			//File file=new File("C:\\Users\\lz\\Desktop\\user.xls");
	
			Workbook workbook=Workbook.getWorkbook(file);
	
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
	
			WritableSheet sheet = writeBook.getSheet(0);
			
			i = sheet.getRows();
			
			Cell cell0 = sheet.getCell(0, i-1);
			int num = 1+Integer.parseInt(cell0.getContents());
			DecimalFormat decFrt = new DecimalFormat("00000000");
			String s1 = decFrt.format(num);
			
			Label lable0 = new Label(0, i, s1);
			Label lable1 = new Label(1, i, pwd);
			Label lable2 = new Label(2, i, fname);
			Label lable3 = new Label(3, i, lname);
			Label lable4 = new Label(4, i, s);
			Label lable5 = new Label(5, i, s);
			Label lable6 = new Label(6, i, "0");

		
			sheet.addCell(lable0);
			sheet.addCell(lable1);
			sheet.addCell(lable2);
			sheet.addCell(lable3);
			sheet.addCell(lable6);
			
			if(check==1) sheet.addCell(lable5);
			else sheet.addCell(lable4);
			
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Register(String pwd, String fname, String lname, String mail, String phone) {
		int i;
		//i is the number of rows
		
		try {
			File file=new File("src/xls/user.xls");
			//File file=new File("C:\\Users\\lz\\Desktop\\user.xls");
	
			Workbook workbook=Workbook.getWorkbook(file);
	
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
	
			WritableSheet sheet = writeBook.getSheet(0);
			
			i = sheet.getRows();
			
			Cell cell0 = sheet.getCell(0, i-1);
			int num = 1+Integer.parseInt(cell0.getContents());
			DecimalFormat decFrt = new DecimalFormat("00000000");
			String s1 = decFrt.format(num);
			
			Label lable0 = new Label(0, i, s1);
			Label lable1 = new Label(1, i, pwd);
			Label lable2 = new Label(2, i, fname);
			Label lable3 = new Label(3, i, lname);
			Label lable4 = new Label(4, i, mail);
			Label lable5 = new Label(5, i, phone);
			Label lable6 = new Label(6, i, "0");

		
			sheet.addCell(lable0);
			sheet.addCell(lable1);
			sheet.addCell(lable2);
			sheet.addCell(lable3);
			sheet.addCell(lable6);
			sheet.addCell(lable5);
			sheet.addCell(lable4);
			
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delet() {
		int i;
		//i is the number of rows
		
		try {
			File file=new File("src/xls/user.xls");
			//File file=new File("C:\\Users\\lz\\Desktop\\user.xls");
	
			Workbook workbook=Workbook.getWorkbook(file);
	
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
	
			WritableSheet sheet = writeBook.getSheet(0);
			
			i = sheet.getRows()-1;
			sheet.removeRow(i);
						
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Question(String q1, String q2, String q3) {
		int i;
		//i is the number of rows
		
		try {
			File file=new File("src/xls/user.xls");
			//File file=new File("C:\\Users\\lz\\Desktop\\user.xls");
	
			Workbook workbook=Workbook.getWorkbook(file);
	
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
	
			WritableSheet sheet = writeBook.getSheet(0);
			
			i = sheet.getRows()-1;
			
			Label lable0 = new Label(7, i, q1);
			Label lable1 = new Label(8, i, q2);
			Label lable2 = new Label(9, i, q3);
		
			sheet.addCell(lable0);
			sheet.addCell(lable1);
			sheet.addCell(lable2);
			
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getName(String id) {
		int i;
		File file=new File("src/xls/user.xls");
		Workbook workbook;
		String result = "";
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet = workbook.getSheet(0);			
	
			for (i=1;i<sheet.getRows();i++) {
				Cell cell0 = sheet.getCell(0, i);
				if(id.equals(cell0.getContents())) break;
			}
			
			Cell cell1 = sheet.getCell(2, i);
			Cell cell2 = sheet.getCell(3, i);

			result = cell1.getContents()+" "+cell2.getContents();
		
		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}	
		return result;
	}
	
	public static String getStamp(String id) {
		int i;
		File file=new File("src/xls/user.xls");
		Workbook workbook;
		String result = "";
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet = workbook.getSheet(0);			
	
			for (i=1;i<sheet.getRows();i++) {
				Cell cell0 = sheet.getCell(0, i);
				if(id.equals(cell0.getContents())) break;
			}
			
			Cell cell1 = sheet.getCell(6, i);

			result = cell1.getContents();
		
		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}	
		return result;
	}
	
	public static String getId() {
		File file=new File("src/xls/user.xls");
		Workbook workbook;
		String result = "";
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet = workbook.getSheet(0);			
	
			Cell cell1 = sheet.getCell(0, sheet.getRows()-1);

			result = cell1.getContents();
		
		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}	
		return result;
	}
	
	public static String checkAnswer(String id, int question) {
		int i;
		File file=new File("src/xls/user.xls");
		Workbook workbook;
		String result = "";
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet = workbook.getSheet(0);			
	
			for (i=1;i<sheet.getRows();i++) {
				Cell cell0 = sheet.getCell(0, i);
				if(id.equals(cell0.getContents())) break;
			}

			Cell cell1 = sheet.getCell(question, i);

			result = cell1.getContents();
		
		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}	
		return result;
	}
	
	
	public static void passwordrest(String id, String pwd) {
		int i;
		
		try {
			File file=new File("src/xls/user.xls");
	
			Workbook workbook=Workbook.getWorkbook(file);
	
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
	
			WritableSheet sheet = writeBook.getSheet(0);
			
			for (i=1;i<sheet.getRows();i++) {
				Cell cell0 = sheet.getCell(0, i);
				if(id.equals(cell0.getContents())) break;
			}
						
			WritableCell cell1=sheet.getWritableCell(1, i);

			Label lable1 = new Label(1, i, pwd);
			
			sheet.addCell(lable1);
				
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int Login(String id, String pwd, String filename){
		int i;
		File file=new File(filename);
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);			
			for (i=1;i<sheet.getRows();i++) {	
				Cell cell0 = sheet.getCell(0, i);	//id
				Cell cell1 = sheet.getCell(1, i);	//password
				if (id.equals(cell0.getContents()) && pwd.equals(cell1.getContents()))
					return 1;	
			}	
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	/**
	 * jxl实现excel读取并输出
	 * 读取excel修改之后重新输出
	 */

	public static void ModifyExcelAndOutput() {

		try {
			File file=new File("src/xls/inventory.xls");
			//这里读出来的workbook作为模版
			Workbook workbook=Workbook.getWorkbook(file);
			//这里是将要输出的workbook
			
			//输出文件名
			//String outFileName="C:\\Users\\kangk\\Desktop\\java\\test\\output"+i+".xls";
			// jxl.Workbook 对象是只读的，所以如果要修改Excel，需要创建一个可读的副本，副本指向原Excel文件（即下面的new File(excelpath)） 
			//WritableWorkbook如果直接createWorkbook模版文件会覆盖原有的文件
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook); 
			//WritableWorkbook writeBook=Workbook.createWorkbook(new File(outFileName),workbook); 
			//读取第一个sheet
			WritableSheet sheet=writeBook.getSheet(0);
			//读取将要修改的cell
			WritableCell cell=sheet.getWritableCell(2, 1);
			//获取上一部cell的格式
			jxl.format.CellFormat cf=cell.getCellFormat();
			Label lable=new Label(2, 1, "商户名称：修改后的商户名"+"1");
			//将修改后的单元格格式设置成和原来一样的
			lable.setCellFormat(cf);
			//将修改后的cell放回sheet中
			sheet.addCell(lable);
			writeBook.write();
			writeBook.close();

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ModifyStamp(String id, int n) {
		int user=-1;
		int Stamp_num=-1;
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
		    Cell cell = sheet.getCell(6, user);
		    Stamp_num =  Integer.parseInt(cell.getContents());
			
		    Stamp_num += n;
		    
			Label lable0 = new Label(6, user, Stamp_num+"");
		
			sheet.addCell(lable0);
			
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void ModifyPrice(String a, String b, String c, String d) {

		try {
			File file=new File("src/xls/price.xls");
			//这里读出来的workbook作为模版
			Workbook workbook=Workbook.getWorkbook(file);
			//这里是将要输出的workbook
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
			//读取第一个sheet
			WritableSheet sheet=writeBook.getSheet(0);
			
			//读取将要修改的cell
			WritableCell cell0=sheet.getWritableCell(0, 1);
			WritableCell cell1=sheet.getWritableCell(1, 1);
			WritableCell cell2=sheet.getWritableCell(2, 1);
			WritableCell cell3=sheet.getWritableCell(3, 1);
			
			//获取上一部cell的格式
			jxl.format.CellFormat cf=cell0.getCellFormat();
			
			Label lable0 = new Label(0, 1, a);
			Label lable1 = new Label(1, 1, b);
			Label lable2 = new Label(2, 1, c);
			Label lable3 = new Label(3, 1, d);
			
			lable0.setCellFormat(cf);
			lable1.setCellFormat(cf);
			lable2.setCellFormat(cf);
			lable3.setCellFormat(cf);
			
			sheet.addCell(lable0);
			sheet.addCell(lable1);
			sheet.addCell(lable2);
			sheet.addCell(lable3);
			
			writeBook.write();
			writeBook.close();

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void ModifyInventory(int a, int b, int c, int d) {

		try {
			File file=new File("src/xls/inventory.xls");
			//这里读出来的workbook作为模版
			Workbook workbook=Workbook.getWorkbook(file);
			//这里是将要输出的workbook
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
			//读取第一个sheet
			WritableSheet sheet=writeBook.getSheet(0);
			
			//读取将要修改的cell
			WritableCell cell0=sheet.getWritableCell(0, 1);
			WritableCell cell1=sheet.getWritableCell(1, 1);
			WritableCell cell2=sheet.getWritableCell(2, 1);
			WritableCell cell3=sheet.getWritableCell(3, 1);
			
			//获取上一部cell的格式
			jxl.format.CellFormat cf=cell0.getCellFormat();
			
			Label lable0 = new Label(0, 1, (Integer.parseInt(cell0.getContents())-a)+"");
			Label lable1 = new Label(1, 1, (Integer.parseInt(cell1.getContents())-b)+"");
			Label lable2 = new Label(2, 1, (Integer.parseInt(cell2.getContents())-c)+"");
			Label lable3 = new Label(3, 1, (Integer.parseInt(cell3.getContents())-d)+"");
			
			lable0.setCellFormat(cf);
			lable1.setCellFormat(cf);
			lable2.setCellFormat(cf);
			lable3.setCellFormat(cf);
			
			sheet.addCell(lable0);
			sheet.addCell(lable1);
			sheet.addCell(lable2);
			sheet.addCell(lable3);
			
			writeBook.write();
			writeBook.close();

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void ModifyOrder(String s1, String s2, String s3, String s4, String s5, int a, int b, int c, int d) {
		int i;
		//i is the number of rows
		
		try {
			File file=new File("src/xls/order.xls");
	
			Workbook workbook=Workbook.getWorkbook(file);
	
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
	
			WritableSheet sheet = writeBook.getSheet(0);
			
			i = sheet.getRows();
						
			//读取将要修改的cell
			WritableCell cell0=sheet.getWritableCell(0, i);
			WritableCell cell1=sheet.getWritableCell(1, i);
			WritableCell cell2=sheet.getWritableCell(2, i);
			WritableCell cell3=sheet.getWritableCell(3, i);
			WritableCell cell4=sheet.getWritableCell(4, i);
			WritableCell cell5=sheet.getWritableCell(5, i);
			WritableCell cell6=sheet.getWritableCell(6, i);
			WritableCell cell7=sheet.getWritableCell(7, i);
			WritableCell cell8=sheet.getWritableCell(8, i);
			
			Label lable0 = new Label(0, i, s1);
			Label lable1 = new Label(1, i, s2);
			Label lable2 = new Label(2, i, s3);
			Label lable3 = new Label(3, i, s4);
			Label lable4 = new Label(4, i, a+"");
			Label lable5 = new Label(5, i, b+"");
			Label lable6 = new Label(6, i, c+"");
			Label lable7 = new Label(7, i, d+"");
			Label lable8 = new Label(8, i, s5);
			
			
			sheet.addCell(lable0);
			sheet.addCell(lable1);
			sheet.addCell(lable2);
			sheet.addCell(lable3);
			sheet.addCell(lable4);
			sheet.addCell(lable5);
			sheet.addCell(lable6);
			sheet.addCell(lable7);
			sheet.addCell(lable8);
			
			
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int getDateDiff(String ordertime) { 
		
		long d = 1000*24*60*60;
		
	    Date orderDate = null;  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    try {  
            orderDate = sdf.parse(ordertime);  
        } catch (ParseException e) {  
            System.out.println(e.getMessage());  
        }
	    
		Date nowDate = new Date();
		long day = (nowDate.getTime()-orderDate.getTime())/d;  
		//System.out.println(day);
		
		if (day<7)
			return 1;
		else 
			return 0;
	}
	
	public static int getSpiciness(){
		
		int i;
		int s[] = {0,0,0,0,0,0};
		int max=0;
		int max_index=0;
		
		File file=new File("src/xls/order.xls");
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet = workbook.getSheet(0);			
			
			for (i=1;i<sheet.getRows();i++) {
				
				Cell cell0 = sheet.getCell(3, i);
				
				if (cell0.getContents().equals("0(No)")) {
					s[0]++;
				}
				if (cell0.getContents().equals("1")) {
					s[1]++;
				}
				if (cell0.getContents().equals("2")) {
					s[2]++;
				}
				if (cell0.getContents().equals("3")) {
					s[3]++;
				}
				if (cell0.getContents().equals("4")) {
					s[4]++;
				}
				if (cell0.getContents().equals("5(Max)")) {
					s[5]++;
				}			
				
			}
			for (i=0;i<6;i++) {
				if (s[i]>max) {
					max = s[i];
					max_index = i;
				}
			}
			
	
		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}
		
		return max_index;
		
	}
	
	
	public static void ModifyPassword(String id, String password) {

		int i;
		//i is the number of rows
		
		try {
			File file=new File("src/xls/admin.xls");
	
			Workbook workbook=Workbook.getWorkbook(file);
	
			WritableWorkbook writeBook=Workbook.createWorkbook(file,workbook);  
	
			WritableSheet sheet = writeBook.getSheet(0);
			
			i = sheet.getRows();
						
			//读取将要修改的cell
			WritableCell cell0=sheet.getWritableCell(0, i);
			WritableCell cell1=sheet.getWritableCell(1, i);
			
			
			Label lable0 = new Label(0, i, id);
			Label lable1 = new Label(1, i, password);
			
			
			
			sheet.addCell(lable0);
			sheet.addCell(lable1);
			
			
			
			writeBook.write();
			writeBook.close();
	
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		//ModifyExcelAndOutput();
		//ExcelReader();
		//ModifyInventory();
		//ModifyOrder("a","b","c","d",1,2,3,4);
		getDateDiff("2020-04-09 11:04:00");
		//ExcelHandler eh = new ExcelHandler();
		//eh.Login("00000001", "123456","user.xls");
	}
}