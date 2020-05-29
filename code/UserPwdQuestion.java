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

public class UserPwdQuestion {

	private JFrame frmTorotoRamen;
	private static double price;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					UserPwdQuestion window = new UserPwdQuestion(price);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserPwdQuestion(double price) {
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
	            ExcelHandler.delet();
			}
		});

		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantouwhite.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		btnNewButton.setIcon(img1);
			
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnNewButton.setBounds(0, 0, 35, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Q1 = textField.getText();
				String Q2 = textField_1.getText();
				String Q3 = textField_2.getText();
				
				if(Q1.equals("")||Q2.equals("")||Q3.equals(""))
					JOptionPane.showOptionDialog(null, "Please set all the questions!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				else {
					String id = ExcelHandler.getId();
					ExcelHandler.Question(Q1, Q2, Q3);
					JOptionPane.showOptionDialog(null, "Successful! Please remember your id is "+id, " ", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,null,new Object[] {"OK"},null);
					
					UserLogin window = new UserLogin(price);
		            frmTorotoRamen.setVisible(false);
				}
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		
		
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		btnNewButton_1.setBounds(220, 397, 215, 72);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Please set your security problem");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblNewLabel.setBounds(157, 42, 472, 35);
		panel.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("Favorite movie character");
		lblFirstName.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblFirstName.setBounds(32, 110, 302, 35);
		panel.add(lblFirstName);
		
		textField = new JTextField();
		textField.setBounds(384, 110, 177, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblYourChildhoodDream = new JLabel("Your childhood dream job");
		lblYourChildhoodDream.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblYourChildhoodDream.setBounds(32, 220, 337, 35);
		panel.add(lblYourChildhoodDream);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(384, 220, 177, 38);
		panel.add(textField_1);
		
		JLabel lblFa = new JLabel("Favorite thing to do");
		lblFa.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblFa.setBounds(32, 330, 337, 35);
		panel.add(lblFa);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(384, 330, 177, 38);
		panel.add(textField_2);
		
		JLabel label_1 = new JLabel("");
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_1.setIcon(img);
		label_1.setBounds(0, 0, 888, 490);
		panel.add(label_1);
		
		frmTorotoRamen.setBounds(150, 75, 888, 550);
		frmTorotoRamen.setLocationRelativeTo(null);
		frmTorotoRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTorotoRamen.setVisible(true);

	}
}
