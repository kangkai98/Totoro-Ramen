package code;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserReset extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserReset frame = new UserReset(0,"");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserReset(double price, String id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddRamen.class.getResource("/img/6.jpg")));
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UserForgetPwd frame = new UserForgetPwd(price);
							setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantoured.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		button.setIcon(img1);
		
		button.setBounds(0, 0, 35, 35);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("Please enter this...");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		lblNewLabel.setBounds(416, 10, 435, 53);
		panel.add(lblNewLabel);
		
		JLabel lblNewName = new JLabel("new passward:");
		lblNewName.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblNewName.setBounds(414, 118, 173, 46);
		panel.add(lblNewName);
		
		JLabel lblPassward = new JLabel("confirm passward:");
		lblPassward.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblPassward.setBounds(414, 185, 192, 34);
		panel.add(lblPassward);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		passwordField.setBounds(640, 119, 173, 46);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		passwordField_1.setBounds(640, 180, 173, 46);
		panel.add(passwordField_1);
		
		JButton btnGo = new JButton("Go");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pwd = passwordField.getText();
				String pwd_1 = passwordField_1.getText();
				
				if(pwd.equals(pwd_1)) {
					ExcelHandler.passwordrest(id, pwd_1);
					UserLogin window = new UserLogin(price);
		            setVisible(false);
				}
				else JOptionPane.showOptionDialog(null, "The two passwords don't match!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
			}
		});
		btnGo.setContentAreaFilled(false);
		btnGo.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnGo.setBounds(485, 289, 152, 53);
		panel.add(btnGo);
		
		JLabel label = new JLabel("");
		
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/3.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label.setIcon(img);
		
		label.setBounds(0, 0, 888, 490);
		panel.add(label);
		
		setVisible(true);
	}
}
