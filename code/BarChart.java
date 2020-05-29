package code;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class BarChart {

	public  BarChart(){
		ExcelHandler ex = new ExcelHandler();
		int spiciness = ex.getSpiciness();
		
    	CategoryDataset dataset = getDataSet();
    	
        JFreeChart chart = ChartFactory.createBarChart3D(
           		                 "Sale Stats Report", // ͼ�����
                                "The most popular spiciness degree is "+ spiciness, // Ŀ¼�����ʾ��ǩ
                                "sales volumn", // ��ֵ�����ʾ��ǩ
                                dataset, // ���ݼ�
                                PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                                true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                                false,          // �Ƿ����ɹ���
                                false           // �Ƿ�����URL����
        );
            
        //�����￪ʼ
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
        domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
        domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
        ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
        
        BarRenderer renderer=new BarRenderer();

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);

        plot.setRenderer(renderer);//���޸ĺ������ֵ���浽ͼ�� 

        JPanel jPanel = new ChartPanel(chart);
        //JLabel lblNewLabel = new JLabel("Must");
		//lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		//jPanel.add(lblNewLabel);

        JFrame frame = new JFrame("JFreechart");
        frame.add(jPanel);

        frame.setBounds(0, 0, 800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
    	
 	private static CategoryDataset getDataSet() {
 		
 		int i;
 		int tonkotsu=0;
 		int shoyu=0;
 		int shio=0;
 		int soft=0;
 		int medium=0;
 		int firm=0;
 		int no=0;
 		int little=0;
 		int much=0;
 		
 		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
 		
 		File file=new File("src/xls/order.xls");
		Workbook workbook;
		try {
			ExcelHandler eh = new ExcelHandler();
			
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet=workbook.getSheet(0);
			
			for (i=1;i<sheet.getRows();i++) {
		
				Cell cell0=sheet.getCell(0, i);
				Cell cell1=sheet.getCell(1, i);
				Cell cell2=sheet.getCell(2, i);
				Cell cell3=sheet.getCell(3, i);
				Cell cell4=sheet.getCell(4, i);
				Cell cell5=sheet.getCell(5, i);
				Cell cell6=sheet.getCell(6, i);
				Cell cell7=sheet.getCell(7, i);
				Cell cell8=sheet.getCell(8, i);
				
				if (eh.getDateDiff(cell8.getContents())==1) {
					//soup
					if (cell0.getContents().equals("Tonkotsu")) {
						tonkotsu++;
					}
					if (cell0.getContents().equals("Shoyu")) {
						shoyu++;
					}
					if (cell0.getContents().equals("Shio")) {
						shio++;
					}		
					//noodles
					if (cell1.getContents().equals("Soft")) {
						soft++;
					}
					if (cell1.getContents().equals("Medium")) {
						medium++;
					}
					if (cell1.getContents().equals("Firm")) {
						firm++;
					}		
					//spring onion
					if (cell2.getContents().equals("No please")) {
						no++;
					}
					if (cell2.getContents().equals("Just a little")) {
						little++;
					}
					if (cell2.getContents().equals("A lot!")) {
						much++;
					}		
					//add on 
					//������
				}
				
			}

		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}
 		
        dataset.addValue(tonkotsu, "Tonkotsu", "Soup");
        dataset.addValue(shoyu, "Shoyu", "Soup");
        dataset.addValue(shio, "Shio    ", "Soup");
        dataset.addValue(soft, "Soft", "Noodles");
        dataset.addValue(medium, "Medium", "Noodles");
        dataset.addValue(firm, "Firm    ", "Noodles");
        dataset.addValue(no, "No", "Spring onion");
        dataset.addValue(little, "Little", "Spring onion");
        dataset.addValue(much, "Much", "Spring onion");
        //dataset.addValue(400, "Nori", "Add on");
        //dataset.addValue(400, "Chashu", "Add on");
        //dataset.addValue(400, "Boiled egg", "Add on");


        return dataset;
 	}


    public static void main(String[] args) {
        BarChart bc = new BarChart();
    }
}