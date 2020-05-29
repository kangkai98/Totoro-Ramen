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

public class UserForgetPwd {

	private JFrame frmTorotoRamen;
	private JTextField txtRetrievePassword;
	private String[] categories = {"Favorite movie character","Your childhood dream job","Favorite thing to do"};
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					UserForgetPwd window = new UserForgetPwd(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserForgetPwd(double price) {
		initialize(price);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(double price) {
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
				
		JComboBox comboBox = new JComboBox(this.categories);
		comboBox.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		comboBox.setBounds(27, 304, 314, 46);
		panel.add(comboBox);
			
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		btnNewButton.setBounds(0, 0, 35, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String choice = (String) comboBox.getSelectedItem();
				String answer = txtRetrievePassword.getText();
				String id = textField_1.getText();
				int i;
				if(choice.equals(categories[0])) i=7;
				else if(choice.equals(categories[1])) i=8;
				else i=9;
				
				if(answer.equals(ExcelHandler.checkAnswer(id, i))) {
					new UserReset(price,id);
					frmTorotoRamen.setVisible(false);
				}
				else JOptionPane.showOptionDialog(null, "Your account number or answer is wrong!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
				
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		btnNewButton_1.setBounds(196, 413, 215, 57);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Please select and answer the security questions");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblNewLabel.setBounds(27, 227, 567, 35);
		panel.add(lblNewLabel);
		
		txtRetrievePassword = new JTextField();
		txtRetrievePassword.setBounds(365, 304, 249, 46);
		panel.add(txtRetrievePassword);
		txtRetrievePassword.setColumns(10);
				
		textField_1 = new JTextField();
		textField_1.setBounds(365, 136, 249, 35);
		panel.add(textField_1);
		textField_1.setColumns(10);
				
		JLabel lblNewLabel_1 = new JLabel("Enter your id");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(27, 132, 182, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Retrieve password");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(183, 10, 567, 35);
		panel.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("");
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_1.setIcon(img);
		label_1.setBounds(0, 0, 888, 490);
		panel.add(label_1);
		
		frmTorotoRamen.setBounds(150, 75, 888, 547);
		frmTorotoRamen.setLocationRelativeTo(null);
		frmTorotoRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTorotoRamen.setVisible(true);
	}
}

