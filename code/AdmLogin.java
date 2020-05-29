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

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class AdmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmLogin frame = new AdmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdmLogin.class.getResource("/img/6.jpg")));
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

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							Startup frame = new Startup();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setContentAreaFilled(false);
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantoublue.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		button.setIcon(img1);
		button.setBounds(0, 0, 35, 35);
		panel.add(button);
		
		JLabel label = new JLabel("Welcome back,Mr. Miyazaki!");
		label.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		label.setBounds(416, 10, 435, 53);
		panel.add(label);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblUserName.setBounds(414, 118, 144, 46);
		panel.add(lblUserName);
		
		JLabel lblPassward = new JLabel("passward:");
		lblPassward.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblPassward.setBounds(414, 185, 128, 34);
		panel.add(lblPassward);
		
		textField = new JTextField();
		textField.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		textField.setBounds(616, 118, 173, 46);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		passwordField.setBounds(616, 185, 173, 46);
		panel.add(passwordField);
		
		JButton btnEnter = new JButton("go");
		btnEnter.setContentAreaFilled(false);
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				String id = textField.getText();
				String pwd = passwordField.getText();

				
				if (id.equals("") || pwd.equals("")) {
					JOptionPane.showMessageDialog(null, "account or password can't be null."); 
				}
				else {
					ExcelHandler eh = new ExcelHandler();
					if (eh.Login(id,pwd,"src/xls/admin.xls") == 1) {
						//JOptionPane.showMessageDialog(null, "success!"); 
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
						setVisible(false);
					}
					else {
						Object[] options = {"OK","cancel"};
						JOptionPane.showOptionDialog(null,"fail! account or password wrong.","warning",
						        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
						//JOptionPane.showMessageDialog(null, pwd,id,JOptionPane.WARNING_MESSAGE);
						//JOptionPane.showMessageDialog(null, "fail! account or password wrong.");  
					}
				}
				
				
			}
		});
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnter.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		btnEnter.setBounds(416, 289, 152, 53);
		panel.add(btnEnter);
		
		JButton btnForgetTheName = new JButton("i forget...");
		btnForgetTheName.setContentAreaFilled(false);
		btnForgetTheName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//没有加条件
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							String id = textField.getText();
							setVisible(false);
							AdmForgetPassword frame = new AdmForgetPassword();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnForgetTheName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnForgetTheName.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		btnForgetTheName.setBounds(626, 289, 163, 53);
		panel.add(btnForgetTheName);
		
		JLabel label_1 = new JLabel("--------------------------------------------------");
		label_1.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		label_1.setBounds(426, 73, 373, 15);
		panel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(GuanlidengluGUI.class.getResource("/manager/2.jpg")));
		lblNewLabel.setBounds(0, 0, 888, 490);
		
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/2.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(img);
		
		panel.add(lblNewLabel);
	}
}