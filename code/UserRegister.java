package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

//import manager.Log;
//import manager.Reg_info;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class UserRegister {

	private JFrame frmTorotoRamen;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private double price;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private double price;

			public void run() {
				try {
					UserRegister window = new UserRegister(this.price);
					window.frmTorotoRamen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserRegister(double price) {
		initialize();
		this.price = price;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTorotoRamen = new JFrame();
		frmTorotoRamen.setIconImage(Toolkit.getDefaultToolkit().getImage(UserRegister.class.getResource("/img/6.jpg")));
		frmTorotoRamen.setTitle("Toroto Ramen");
		frmTorotoRamen.getContentPane().setEnabled(false);
		frmTorotoRamen.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 888, 490);
		frmTorotoRamen.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 490);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserLogin window = new UserLogin(price);
	        	//window.frame.setVisible(true);
	            frmTorotoRamen.setVisible(false);
			}
		});

		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantouwhite.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		btnNewButton.setIcon(img1);
			
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnNewButton.setBounds(0, 0, 35, 35);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(226, 110, 210, 35);
		panel.add(textField);
				
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(226, 170, 210, 35);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(226, 230, 210, 35);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(226, 290, 210, 35);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(226, 350, 210, 35);
		panel.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fname = textField.getText();
				String lname = textField_1.getText();
				String email = textField_2.getText();
				String phone = textField_3.getText();
				String pwd = textField_4.getText();
				boolean flag1 = isNumLegal(textField_3.getText());
	        	boolean flag2 = isEmail(textField_2.getText());
				
				
				if(fname.equals("")||lname.equals("")||pwd.equals("")) 
					JOptionPane.showOptionDialog(null, "Please fill in your name or password!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);	        	
				else if(flag1||flag2) {
	        		if(flag1&&flag2) {
		        		ExcelHandler.Register(pwd, fname, lname, email, phone);
		        	}
		        	else if(flag1) {
		        		ExcelHandler.Register(pwd, fname, lname, phone, 1);
		        	}
		        	else if(flag2) {
		        		ExcelHandler.Register(pwd, fname, lname, email, 1);
		        	}
	        		
	        		UserPwdQuestion window = new UserPwdQuestion(price);
		            frmTorotoRamen.setVisible(false);
	        	}
	        	else JOptionPane.showOptionDialog(null, "Please fill in the correct telephone number or email address!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
			}
		});
		
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		btnNewButton_1.setBounds(108, 400, 215, 72);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Please fill in the information");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblNewLabel.setBounds(51, 55, 472, 35);
		panel.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblFirstName.setBounds(32, 110, 150, 35);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblLastName.setBounds(32, 170, 150, 35);
		panel.add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblEmail.setBounds(32, 230, 150, 35);
		panel.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblPhoneNumber.setBounds(32, 290, 178, 35);
		panel.add(lblPhoneNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblPassword.setBounds(32, 350, 178, 35);
		panel.add(lblPassword);
		
		JLabel label_1 = new JLabel("");
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_1.setIcon(img);
		
		label_1.setBounds(0, 0, 888, 490);
		panel.add(label_1);
		
		frmTorotoRamen.setBounds(150, 75, 888, 540);
		frmTorotoRamen.setLocationRelativeTo(null);
		frmTorotoRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmTorotoRamen.setVisible(true);

	}
	
	public static boolean isNumLegal(String str) {
        String regExp = "^(1)\\d{10}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
	
	public static Boolean isEmail(String str) {
        String expr = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$";

        return str.matches(expr);
    }
}
