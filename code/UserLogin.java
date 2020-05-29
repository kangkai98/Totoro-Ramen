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

public class UserLogin extends JFrame {

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
					UserLogin frame = new UserLogin(0);
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
	public UserLogin(double price) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/img/6.jpg")));
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
				setVisible(false);
				Pay frame = new Pay(price);
			    frame.setVisible(true);
			}
		});
		button.setContentAreaFilled(false);
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantoured.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		button.setIcon(img1);

		button.setBounds(0, 0, 35,35);
		panel.add(button);
		
		JLabel lblWelcomemyLord = new JLabel("Welcome,my lord!");
		lblWelcomemyLord.setFont(new Font("Script MT Bold", Font.PLAIN, 27));
		lblWelcomemyLord.setBounds(416, 10, 373, 53);
		panel.add(lblWelcomemyLord);
		
		JLabel label = new JLabel("--------------------------------------------------");
		label.setFont(new Font("Script MT Bold", Font.PLAIN, 22));
		label.setBounds(426, 73, 373, 15);
		panel.add(label);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		lblUserName.setBounds(414, 118, 104, 46);
		panel.add(lblUserName);
		
		JLabel lblPassward = new JLabel("passward");
		lblPassward.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		lblPassward.setBounds(414, 185, 104, 34);
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
		
		JButton btnGo = new JButton("go");
		btnGo.setContentAreaFilled(false);
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = textField.getText();
				String pwd = passwordField.getText();

				
				if (id.equals("") || pwd.equals("")) {
					JOptionPane.showOptionDialog(null, "Account or password can't be null!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				}
				else {
					if (ExcelHandler.Login(id,pwd,"src/xls/user.xls") == 1) {
						setVisible(false);
						PayFinish pf = new PayFinish(id,price);
					}
					else {
						JOptionPane.showOptionDialog(null, "Fail! account or password wrong.", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
					}
				}
			}
		});
		btnGo.setFont(new Font("Script MT Bold", Font.PLAIN, 27));
		btnGo.setBounds(393, 312, 125, 53);
		panel.add(btnGo);
		
		JButton btnIForget = new JButton("i forget...");
		btnIForget.setContentAreaFilled(false);
		btnIForget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserForgetPwd ul = new UserForgetPwd(price);
				setVisible(false);
			}
		});
		btnIForget.setFont(new Font("Script MT Bold", Font.PLAIN, 27));
		btnIForget.setBounds(541, 312, 139, 53);
		panel.add(btnIForget);
		
		JButton btnNewUser = new JButton("new user");
		btnNewUser.setContentAreaFilled(false);
		btnNewUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserRegister r = new UserRegister(price);
				setVisible(false);
			}
		});

		btnNewUser.setFont(new Font("Script MT Bold", Font.PLAIN, 27));
		btnNewUser.setBounds(704, 312, 139, 53);
		panel.add(btnNewUser);
		
		JLabel label_1 = new JLabel("");
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/3.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_1.setIcon(img);
		
		label_1.setBounds(0, 0, 888, 490);
		panel.add(label_1);
		
		setVisible(true);
	}
}

