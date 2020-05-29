package code;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdmModify extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	
	String av1;
	String av2;
	String av3;
	String av4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File file=new File("src/xls/price.xls");
					Workbook workbook;
					try {
						workbook = Workbook.getWorkbook(file);
						
						Sheet sheet=workbook.getSheet(0);
						
						Cell cell0=sheet.getCell(0, 1);
						Cell cell1=sheet.getCell(1, 1);
						Cell cell2=sheet.getCell(2, 1);
						Cell cell3=sheet.getCell(3, 1);
						
						
						AdmModify frame = new AdmModify(cell0.getContents(),cell1.getContents(),cell2.getContents(),cell3.getContents());
						frame.setVisible(true);

					} catch (BiffException | IOException e) {
						
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdmModify(String s1,String s2,String s3,String s4) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdmModify.class.getResource("/img/6.jpg")));
		setTitle("Totoro Ramen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 75, 888, 525);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 888, 490);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 490);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							AdmFunction frame = new AdmFunction();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setContentAreaFilled(false);
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantouwhite.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		
		File file=new File("src/xls/inventory.xls");
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet=workbook.getSheet(0);
			
			Cell cell0=sheet.getCell(0, 1);
			Cell cell1=sheet.getCell(1, 1);
			Cell cell2=sheet.getCell(2, 1);
			Cell cell3=sheet.getCell(3, 1);
			
			av1 = cell0.getContents();
			av2 = cell2.getContents();
			av3 = cell3.getContents();
			av4 = cell1.getContents();

		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		//chashu available
		//String av4 = "yes";
		JLabel label_12 = new JLabel(av4);
		label_12.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		label_12.setBounds(27, 307, 69, 49);
		panel.add(label_12);
		
		//bamboo shoots available
		//String av3 = "yes";
		JLabel label_11 = new JLabel(av3);
		label_11.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		label_11.setBounds(27, 245, 69, 49);
		panel.add(label_11);
		
		//boiled egg available
		//String av2 = "yes";
		JLabel label_10 = new JLabel(av2);
		label_10.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		label_10.setBounds(27, 187, 69, 49);
		panel.add(label_10);
		
		//Nori available
		//String av1 = "yes";
		JLabel label_9 = new JLabel(av1);
		label_9.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		label_9.setBounds(27, 128, 69, 49);
		panel.add(label_9);
		
		JLabel lblAvailable = new JLabel("inventory");
		lblAvailable.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblAvailable.setBounds(18, 70, 113, 46);
		panel.add(lblAvailable);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblPrice.setBounds(360, 69, 82, 49);
		panel.add(lblPrice);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(35, 302, 35, 49);
		panel.add(label_8);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(35, 246, 35, 49);
		panel.add(label_7);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(35, 187, 35, 49);
		panel.add(label_6);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(35, 128, 35, 49);
		panel.add(label_5);
		
		//bamboo shoots price
		double pr3 = 1;
		String PR3 = s3;
		JLabel label_3 = new JLabel(PR3);
		label_3.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		label_3.setBounds(365, 246, 82, 49);
		panel.add(label_3);
		
		//chashu price
		double pr4 = 2;
		String PR4 = s4;
		JLabel label_4 = new JLabel(PR4);
		label_4.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		label_4.setBounds(365, 302, 82, 49);
		panel.add(label_4);
		
		//boiled egg price
		double pr2 = 1;
		String PR2 = s2;
		JLabel label_2 = new JLabel(PR2);
		label_2.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		label_2.setBounds(365, 187, 82, 49);
		panel.add(label_2);
		
		//Nori price
		double pr1 = 1;
		String PR1 = s1;
		JLabel label_1 = new JLabel(PR1);
		label_1.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		label_1.setBounds(365, 128, 82, 49);
		panel.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		textField_4.setColumns(10);
		textField_4.setBounds(475, 128, 82, 49);
		panel.add(textField_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(475, 302, 82, 49);
		panel.add(textField_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(475, 246, 82, 49);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(475, 187, 82, 49);
		panel.add(textField_1);
		
		JButton button_3 = new JButton("change the price");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//chashu
				String choice4 = textField_3.getText();
				if (choice4.equals("")||!AdmModify.isNumeric(choice4))
					JOptionPane.showOptionDialog(null, "please enter a price.", "  warning ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					Double pr4 = new Double(choice4);
					String PR4 = choice4;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								setVisible(false);
								AdmModify frame = new AdmModify(PR1,PR2,PR3,PR4);
								frame.setVisible(true);
								ExcelHandler eh = new ExcelHandler();
								eh.ModifyPrice(PR1,PR2,PR3,PR4);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		button_3.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		button_3.setContentAreaFilled(false);
		button_3.setBounds(567, 302, 242, 46);
		panel.add(button_3);
		
		JButton button_2 = new JButton("change the price");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//bamboo shoots
				String choice3 = textField.getText();
				if (choice3.equals("")||!AdmModify.isNumeric(choice3))
					JOptionPane.showOptionDialog(null, "please enter a price.", "  warning ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					Double pr3 = new Double(choice3);
					String PR3 = choice3;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								setVisible(false);
								AdmModify frame = new AdmModify(PR1,PR2,PR3,PR4);
								frame.setVisible(true);
								ExcelHandler eh = new ExcelHandler();
								eh.ModifyPrice(PR1,PR2,PR3,PR4);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		button_2.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		button_2.setContentAreaFilled(false);
		button_2.setBounds(567, 243, 242, 46);
		panel.add(button_2);
		
		JButton button_1 = new JButton("change the price");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//boiled egg
				String choice2 = textField_1.getText();				
				if (choice2.equals("")||!AdmModify.isNumeric(choice2))
					JOptionPane.showOptionDialog(null, "please enter a price.", "  warning ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					Double pr2 = new Double(choice2);
					String PR2 = choice2;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								setVisible(false);
								AdmModify frame = new AdmModify(PR1,PR2,PR3,PR4);
								frame.setVisible(true);
								ExcelHandler eh = new ExcelHandler();
								eh.ModifyPrice(PR1,PR2,PR3,PR4);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		button_1.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		button_1.setContentAreaFilled(false);
		button_1.setBounds(567, 181, 242, 46);
		panel.add(button_1);
		button.setIcon(img1);

		button.setBounds(0, 0, 35, 35);
		panel.add(button);
		
		JLabel lblMenu = new JLabel("menu for manager");
		lblMenu.setFont(new Font("Segoe Print", Font.PLAIN, 29));
		lblMenu.setBounds(330, 10, 297, 45);
		panel.add(lblMenu);
		
		JLabel lblOption = new JLabel("option");
		lblOption.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblOption.setBounds(165, 70, 139, 46);
		panel.add(lblOption);
		
		JLabel lblNori = new JLabel("nori");
		lblNori.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblNori.setBounds(165, 128, 169, 49);
		panel.add(lblNori);
		
		JLabel lblBoiledEgg = new JLabel("boiled egg");
		lblBoiledEgg.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblBoiledEgg.setBounds(165, 187, 169, 49);
		panel.add(lblBoiledEgg);
		
		JLabel lblBambooShoots = new JLabel("bamboo shoots");
		lblBambooShoots.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblBambooShoots.setBounds(165, 246, 169, 49);
		panel.add(lblBambooShoots);
		
		JLabel lblChashu = new JLabel("chashu");
		lblChashu.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblChashu.setBounds(165, 305, 169, 49);
		panel.add(lblChashu);
		
		JButton btnChangeThePrice = new JButton("change the price");
		btnChangeThePrice.setContentAreaFilled(false);
		btnChangeThePrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//nori
				String choice1 = textField_4.getText();
				if (choice1.equals("")||!AdmModify.isNumeric(choice1))
					JOptionPane.showOptionDialog(null, "please enter a price.", "  warning ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					Double pr1 = new Double(choice1);
					String PR1 = choice1;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								setVisible(false);
								AdmModify frame = new AdmModify(PR1,PR2,PR3,PR4);
								frame.setVisible(true);
								ExcelHandler eh = new ExcelHandler();
								eh.ModifyPrice(PR1,PR2,PR3,PR4);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnChangeThePrice.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		btnChangeThePrice.setBounds(567, 125, 242, 46);
		panel.add(btnChangeThePrice);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon(Guanmlimodify.class.getResource("/manager/5.jpg")));
		label.setBounds(-10, -10, 888, 490);
		
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label.setIcon(img);
		
		panel.add(label);
	}
	
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
}
