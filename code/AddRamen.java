package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import code.ExcelHandler.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class AddRamen {
	
	//public static int count = 0;
	//record the number of ramen
	//public static Ramen[] list = new Ramen[50];
	public static ArrayList<Ramen> order =new ArrayList<Ramen>();
	
	public static double price = 0;
	//record total price

	JFrame frmTotoroRamen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AddRamen window = new AddRamen();
	}
	
	public void setPrice(double add){
		price = price + add;
	}

	/**
	 * Create the application.
	 */
	
	public AddRamen() {
		initialize();		
	}
	
	public AddRamen(double p, Ramen r) {
		setPrice(p);
		//list[count++] = r;
		order.add(r);
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmTotoroRamen = new JFrame();
		frmTotoroRamen.setTitle("Totoro Ramen");
		frmTotoroRamen.setIconImage(Toolkit.getDefaultToolkit().getImage(AddRamen.class.getResource("/img/6.jpg")));
		frmTotoroRamen.setBounds(150, 75, 888, 525);
		frmTotoroRamen.setLocationRelativeTo(null);
		frmTotoroRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTotoroRamen.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 888, 490);
		frmTotoroRamen.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 490);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon img = new ImageIcon("src/img/ramen.png");
	
		JButton button = new JButton("");
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantouwhite.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		button.setIcon(img1);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startup frame = new Startup();
				frame.setVisible(true);
				frmTotoroRamen.setVisible(false);
			}
		});
		
		ImageIcon img3 = new ImageIcon(Startup.class.getResource("/img/ramen3.jpg"));
		img3.setImage(img3.getImage().getScaledInstance(452,452,Image.SCALE_DEFAULT));
		
		JLabel label_1 = new JLabel("------------------------------------");
		label_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		label_1.setBounds(60, 220, 329, 15);
		panel.add(label_1);
		
		JLabel lblSettle = new JLabel("settle accounts->");
		lblSettle.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		lblSettle.setBounds(49, 267, 222, 51);
		panel.add(lblSettle);
		
		JLabel lblIngredients = new JLabel("ingredients->");
		lblIngredients.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		lblIngredients.setBounds(49, 146, 155, 51);
		panel.add(lblIngredients);
		
		JLabel label = new JLabel();
		label.setIcon(img3);
		
		label.setBounds(399,0, 452,452);
		panel.add(label);
		
		JLabel lblChooseYourRamen = new JLabel("choose  your  RAMEN!");
		lblChooseYourRamen.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		lblChooseYourRamen.setBounds(60, 0, 299, 51);
		panel.add(lblChooseYourRamen);
		button.setBounds(0, 0, 35, 35);		
		panel.add(button);
		
		JButton btnAdd_1 = new JButton("add");
		btnAdd_1.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		btnAdd_1.setContentAreaFilled(false);
		btnAdd_1.setBounds(277, 144, 112, 51);
		panel.add(btnAdd_1);
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ÅäÁÏ
				frmTotoroRamen.setVisible(false);
				new AddOn();
			}
		});
		
		JLabel lblRamenPoundsbowl = new JLabel("9.99 Pounds/bowl\r\n");
		lblRamenPoundsbowl.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lblRamenPoundsbowl.setBounds(172, 49, 187, 35);
		panel.add(lblRamenPoundsbowl);
		
		JButton btnOrder = new JButton("order");
		btnOrder.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		btnOrder.setContentAreaFilled(false);
		btnOrder.setBounds(277, 265, 112, 51);
		panel.add(btnOrder);
		btnOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//½áËã
				if (price>0) {
					frmTotoroRamen.setVisible(false);
					new Pay(price);
				}
				else
					JOptionPane.showOptionDialog(null, "you haven't order anything.", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);;
			}
		});
		
		JButton btnSure = new JButton("sure");
		btnSure.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		btnSure.setContentAreaFilled(false);
		btnSure.setBounds(277, 401, 112, 51);
		panel.add(btnSure);
		btnSure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//½áËã
				frmTotoroRamen.setVisible(false);
				new ModifyOrder();
			}
		});
		
		JLabel label_1_1 = new JLabel("------------------------------------");
		label_1_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		label_1_1.setBounds(60, 349, 329, 15);
		panel.add(label_1_1);
		
		JLabel lblViewSelected = new JLabel("view selected->");
		lblViewSelected.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		lblViewSelected.setBounds(49, 401, 222, 51);
		panel.add(lblViewSelected);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 0, 888, 490);
		panel.add(label_3);
		
		ImageIcon img2 = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img2.setImage(img2.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_3.setIcon(img2);
		
		
		this.frmTotoroRamen.setVisible(true);
		
	}
}