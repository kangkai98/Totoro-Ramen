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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class AddOn extends JFrame {

	private JPanel contentPane;
	
	private int check = -1;
	private JButton button_9;
	private JButton button_9_1;
	private JLabel lblNewLabel_6;
	
	private String[] categories_1 = {"Tonkotsu","Shoyu","Shio"};
	private String[] categories_2 = {"Soft","Medium","Firm"};
	private String[] categories_3 = {"No please","Just a little","A lot!"};
	private String[] categories_4 = {"0(No)","1","2","3","4","5(Max)"};
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_7_1;
	private JLabel lblNewLabel_7_2;
	private JLabel lblNewLabel_7_3;
	
	double price_nori;
	double price_egg;
	double price_shoots;
	double price_chashu;
	
	public static int inventory_nori;
	public static int inventory_chashu;
	public static int inventory_egg;
	public static int inventory_shoot;
	
	static{
		File file=new File("src/xls/inventory.xls");
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet=workbook.getSheet(0);
			
			Cell cell0=sheet.getCell(0, 1);
			Cell cell1=sheet.getCell(1, 1);
			Cell cell2=sheet.getCell(2, 1);
			Cell cell3=sheet.getCell(3, 1);
			
			inventory_nori = Integer.parseInt(cell0.getContents());
			inventory_chashu = Integer.parseInt(cell1.getContents());
			inventory_egg = Integer.parseInt(cell2.getContents());
			inventory_shoot = Integer.parseInt(cell3.getContents());

		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOn frame = new AddOn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddOn() {
		initialize();
	}
	
	public AddOn(int i) {
		check = i;
		initialize();
		setinit(i);
	}
	
	public void setinit(int i) {
		
		String[] line = {AddRamen.order.get(i).Soup,AddRamen.order.get(i).Noodles,AddRamen.order.get(i).S_O,AddRamen.order.get(i).Spiciness,AddRamen.order.get(i).Nori+"",AddRamen.order.get(i).Chashu+"",AddRamen.order.get(i).Boiled_egg+"",AddRamen.order.get(i).Shoots+""};
		
		if(line[0]=="Shoyu") comboBox.setSelectedIndex(1);
		else if(line[0]=="Shio") comboBox.setSelectedIndex(2);
		
		if(line[1]=="Medium") comboBox.setSelectedIndex(1);
		else if(line[1]=="Firm") comboBox.setSelectedIndex(2);
		
		if(line[2]=="Just a little") comboBox.setSelectedIndex(1);
		else if(line[2]=="A lot!") comboBox.setSelectedIndex(2);
		
		if(line[3]=="0(No)") comboBox.setSelectedIndex(0);
		else if(line[3]=="5(Max)") comboBox.setSelectedIndex(5);
		else {
			int a = Integer.parseInt(line[3]);
			comboBox.setSelectedIndex(a);
		}
		
		lblNewLabel_7.setText(line[4]);
		lblNewLabel_7_1.setText(line[5]);
		lblNewLabel_7_2.setText(line[6]);
		lblNewLabel_7_3.setText(line[7]);
		
		button_9.setText("Sure  >");
		
		lblNewLabel_6.setText(AddRamen.order.get(i).price+"");
	}
	/**
	 * Create the frame.
	 */
	public void initialize() {
		
		File file=new File("src/xls/price.xls");
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			
			Sheet sheet=workbook.getSheet(0);
			
			Cell cell0=sheet.getCell(0, 1);
			Cell cell1=sheet.getCell(1, 1);
			Cell cell2=sheet.getCell(2, 1);
			Cell cell3=sheet.getCell(3, 1);
			
			
			price_nori = Integer.parseInt(cell0.getContents());
			price_egg = Integer.parseInt(cell1.getContents());
			price_shoots = Integer.parseInt(cell2.getContents());
			price_chashu = Integer.parseInt(cell3.getContents());

		} catch (BiffException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 75, 888, 548);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddRamen.class.getResource("/img/6.jpg")));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 888, 548);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 548);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check==-1) new AddRamen();
				else new ModifyOrder();
				setVisible(false);
			}
		});
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantouwhite.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		
		JLabel lblNewLabel = new JLabel("TO YOUR TASTE");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 31));
		lblNewLabel.setBounds(319, 10, 276, 49);
		panel.add(lblNewLabel);
		button.setIcon(img1);
		
		button.setBounds(0, 0, 35, 35);
		panel.add(button);
		
		JLabel label = new JLabel("Must");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Segoe Print", Font.BOLD, 30));
		label.setBounds(10, 45, 108, 29);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Soup");
		label_1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		label_1.setBounds(39, 82, 61, 29);
		panel.add(label_1);
		
		comboBox = new JComboBox(categories_1);
		comboBox.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		comboBox.setBounds(213, 80, 151, 29);
		panel.add(comboBox);
		
		JLabel label_2 = new JLabel("Noodles");
		label_2.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		label_2.setBounds(39, 124, 108, 29);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Spring onion");
		label_3.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		label_3.setBounds(39, 158, 164, 29);
		panel.add(label_3);
		
		comboBox_1 = new JComboBox(categories_2);
		comboBox_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		comboBox_1.setBounds(213, 122, 151, 29);
		panel.add(comboBox_1);
		
		comboBox_2 = new JComboBox(categories_3);
		comboBox_2.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		comboBox_2.setBounds(213, 158, 151, 29);
		panel.add(comboBox_2);
		
		JLabel label_4 = new JLabel("Spiciness");
		label_4.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		label_4.setBounds(39, 200, 127, 29);
		panel.add(label_4);
		
		comboBox_3 = new JComboBox(categories_4);
		comboBox_3.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		comboBox_3.setBounds(213, 198, 151, 29);
		panel.add(comboBox_3);
		
		JLabel label_5 = new JLabel("\u00A3");
		label_5.setFont(new Font("Segoe Print", Font.PLAIN, 50));
		label_5.setBounds(112, 424, 35, 63);
		panel.add(label_5);
		
		lblNewLabel_6 = new JLabel("9.99");
		lblNewLabel_6.setFont(new Font("Segoe Print", Font.PLAIN, 50));
		lblNewLabel_6.setBounds(155, 431, 209, 49);
		panel.add(lblNewLabel_6);
		
		JLabel label_7 = new JLabel("Extra");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Segoe Print", Font.BOLD, 30));
		label_7.setBounds(10, 241, 96, 29);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Nori   \u00A3"+ price_nori);
		label_8.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		label_8.setBounds(39, 276, 168, 29);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Chashu  \u00A3"+ price_chashu);
		label_9.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		label_9.setBounds(39, 310, 177 ,29);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Boiled egg   \u00A3"+ price_egg);
		label_10.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		label_10.setBounds(39, 345, 174, 29);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Shoots   \u00A3"+ price_shoots);
		label_11.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		label_11.setBounds(39, 383, 167, 29);
		panel.add(label_11);
		
		lblNewLabel_7 = new JLabel("0");
		lblNewLabel_7.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(291, 282, 18, 23);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_7_1 = new JLabel("0");
		lblNewLabel_7_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblNewLabel_7_1.setBounds(291, 316, 18, 23);
		panel.add(lblNewLabel_7_1);
		
		lblNewLabel_7_2 = new JLabel("0");
		lblNewLabel_7_2.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblNewLabel_7_2.setBounds(291, 351, 18, 23);
		panel.add(lblNewLabel_7_2);
		
		lblNewLabel_7_3 = new JLabel("0");
		lblNewLabel_7_3.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblNewLabel_7_3.setBounds(291, 387, 18, 23);
		panel.add(lblNewLabel_7_3);
		
		JLabel label_16 = new JLabel("(The first Nori, Chashu and Boiled egg are free)");
		label_16.setFont(new Font("Segoe Print", Font.PLAIN, 10));
		label_16.setBounds(107, 243, 282, 29);
		panel.add(label_16);
		
		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setContentAreaFilled(false);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = Integer.valueOf(lblNewLabel_7.getText()).intValue();
				count--;
				if(count>=0) {
					inventory_nori++;
					lblNewLabel_7.setText(count+"");
					
					if(count!=0) {
						double price = Double.parseDouble(lblNewLabel_6.getText());
						price-=price_nori;
						lblNewLabel_6.setText(price+"");
					}
				}	
			}
		});
		button_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		button_1.setBounds(225, 282, 45, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setContentAreaFilled(false);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = Integer.valueOf(lblNewLabel_7_1.getText()).intValue();
				count--;
				
				if(count>=0) {
					inventory_chashu++;
					lblNewLabel_7_1.setText(count+"");
					
					if(count!=0) {
						double price = Double.parseDouble(lblNewLabel_6.getText());
						price-=price_chashu;
						lblNewLabel_6.setText(price+"");
					}
				}	
			}
		});
		button_2.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		button_2.setBounds(225, 316, 45, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("-");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setContentAreaFilled(false);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = Integer.valueOf(lblNewLabel_7_2.getText()).intValue();
				count--;
				
				if(count>=0) {
					inventory_shoot++;
					lblNewLabel_7_2.setText(count+"");
					
					if(count!=0) {
						double price = Double.parseDouble(lblNewLabel_6.getText());
						price-=price_egg;
						lblNewLabel_6.setText(price+"");
					}
					
				}	
			}
		});
		button_3.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		button_3.setBounds(225, 351, 45, 23);
		panel.add(button_3);
		
		JButton button_4 = new JButton("-");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setContentAreaFilled(false);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = Integer.valueOf(lblNewLabel_7_3.getText()).intValue();
				count--;
				if(count>=0) {
					inventory_shoot++;
					lblNewLabel_7_3.setText(count+"");
					double price = Double.parseDouble(lblNewLabel_6.getText());
					price-=price_shoots;
					lblNewLabel_6.setText(price+"");
				}
			}
		});
		button_4.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		button_4.setBounds(225, 387, 45, 23);
		panel.add(button_4);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setContentAreaFilled(false);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (inventory_nori<1)
					JOptionPane.showOptionDialog(null, "stock not enough!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					int count = Integer.valueOf(lblNewLabel_7.getText()).intValue();
					count++;
					inventory_nori--;
					lblNewLabel_7.setText(count+"");
					
					if(count!=1) {
						double price = Double.parseDouble(lblNewLabel_6.getText());
						price+=price_nori;
						lblNewLabel_6.setText(price+"");
					}
				}
			}
		});
		button_5.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		button_5.setBounds(319, 282, 45, 23);
		panel.add(button_5);
		
		JButton button_6 = new JButton("+");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_6.setContentAreaFilled(false);
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (inventory_chashu<1)
					JOptionPane.showOptionDialog(null, "stock not enough!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					int count = Integer.valueOf(lblNewLabel_7_1.getText()).intValue();
					count++;
					inventory_chashu--;
					lblNewLabel_7_1.setText(count+"");
					
					if(count!=1) {
						double price = Double.parseDouble(lblNewLabel_6.getText());
						price+=price_chashu;
						lblNewLabel_6.setText(price+"");
					}
				}
			}
		});
		button_6.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		button_6.setBounds(319, 316, 45, 23);
		panel.add(button_6);
		
		JButton button_7 = new JButton("+");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_7.setContentAreaFilled(false);
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (inventory_egg<1)
					JOptionPane.showOptionDialog(null, "stock not enough!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					int count = Integer.valueOf(lblNewLabel_7_2.getText()).intValue();
					count++;
					inventory_egg--;
					lblNewLabel_7_2.setText(count+"");
					
					if(count!=1) {
						double price = Double.parseDouble(lblNewLabel_6.getText());
						price+=price_egg;
						lblNewLabel_6.setText(price+"");
					}
				}
			}
		});
		button_7.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		button_7.setBounds(319, 351, 45, 23);
		panel.add(button_7);
		
		JButton button_8 = new JButton("+");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_8.setContentAreaFilled(false);
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (inventory_shoot<1)
					JOptionPane.showOptionDialog(null, "stock not enough!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					int count = Integer.valueOf(lblNewLabel_7_3.getText()).intValue();
					count++;
					inventory_shoot--;
					lblNewLabel_7_3.setText(count+"");
					double price = Double.parseDouble(lblNewLabel_6.getText());
					price+=price_shoots;
					lblNewLabel_6.setText(price+"");
				}
			}
		});
		button_8.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		button_8.setBounds(319, 389, 45, 23);
		panel.add(button_8);
		
		button_9 = new JButton("ADD   >");
		button_9.setContentAreaFilled(false);
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check!=-1) {
					AddRamen.price -= AddRamen.order.get(check).price;
					AddRamen.order.remove(check);
				}
				
				setVisible(false);
				
				int Nori = Integer.valueOf(lblNewLabel_7.getText()).intValue();
				int Chashu = Integer.valueOf(lblNewLabel_7_1.getText()).intValue();
				int Boiled_egg = Integer.valueOf(lblNewLabel_7_2.getText()).intValue();
				int Shoots = Integer.valueOf(lblNewLabel_7_3.getText()).intValue();
				
				
				Ramen r = new Ramen(comboBox.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString(),
						comboBox_2.getSelectedItem().toString(),comboBox_3.getSelectedItem().toString(),Nori,Chashu,Boiled_egg,Shoots );
				
				
				if(Nori>=1)
					Nori--;
				if(Chashu>=1)
					Chashu--;
				if(Boiled_egg>=1)
					Boiled_egg--;
				double price = Nori*price_nori+Chashu*price_chashu+Boiled_egg*price_egg+Shoots*price_shoots+9.99;
								
				new AddRamen(price,r);
			}
		});
		button_9.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		button_9.setBounds(600, 431, 153, 49);
		panel.add(button_9);
		
		if(check!=-1) {
			button_9_1 = new JButton("Delete");
			button_9_1.setFont(new Font("Segoe Print", Font.PLAIN, 27));
			button_9_1.setContentAreaFilled(false);
			button_9_1.setBounds(409, 431, 153, 49);
			panel.add(button_9_1);
			
			button_9_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AddRamen.price -= AddRamen.order.get(check).price;
					AddRamen.order.remove(check);
					setVisible(false);
					new AddRamen();
				}
			});
		}		
		
		JLabel label_17 = new JLabel("");		
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_17.setIcon(img);
		
		label_17.setBounds(0, 0, 888, 490);
		panel.add(label_17);
		setVisible(true);
	}
}
