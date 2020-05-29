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

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdmForgetPassword extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmForgetPassword frame = new AdmForgetPassword();
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
	public AdmForgetPassword() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdmForgetPassword.class.getResource("/img/6.jpg")));
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
		button.setContentAreaFilled(false);
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantouwhite.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		button.setIcon(img1);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							AdmLogin frame = new AdmLogin();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setBounds(0, 0, 35, 35);
		panel.add(button);
		
		JButton btnNewButton = new JButton("submit");
		
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		btnNewButton.setBounds(738, 395, 120, 57);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("1.When was the year the film spirited away was made?");
		lblNewLabel.setBackground(SystemColor.text);
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		lblNewLabel.setBounds(37, 20, 821, 33);
		panel.add(lblNewLabel);
		
		JLabel lblwhenWasThe = new JLabel("2.How many cigarettes does miyazaki smoke a day?");
		lblwhenWasThe.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		lblwhenWasThe.setBounds(37, 106, 787, 33);
		panel.add(lblwhenWasThe);
		
		JLabel lbltheFollowingQuote = new JLabel("3.The following quote is from hayao miyazaki?");
		lbltheFollowingQuote.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		lbltheFollowingQuote.setBounds(37, 191, 821, 33);
		panel.add(lbltheFollowingQuote);
		
		JLabel lblmrMiyazakiAsked = new JLabel("4. What maximum does miyazaki require of a computer?");
		lblmrMiyazakiAsked.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		lblmrMiyazakiAsked.setBounds(37, 277, 821, 33);
		panel.add(lblmrMiyazakiAsked);
		
		JLabel lblwhyDoesHayao = new JLabel("5.Why does hayao miyazaki love to smoke?");
		lblwhyDoesHayao.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		lblwhyDoesHayao.setBounds(37, 364, 680, 33);
		panel.add(lblwhyDoesHayao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1992", "2001", "2002", "2003"}));
		comboBox.setBounds(64, 63, 93, 33);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "16", "30"}));
		comboBox_1.setBounds(64, 149, 60, 33);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"If you don't work hard in the city for a year, you can't be a witch.", "If winter comes , can spring be far behind?", "Make America Great Again.", "I still have my feet on the ground, I just wear better shoes. "}));
		comboBox_2.setBounds(64, 234, 782, 33);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"10%", "20%", "67%", "68%"}));
		comboBox_3.setBounds(64, 320, 93, 33);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Smoking makes a sound like a childhood memory", "Smoking stimulates physical activity", "Smoking is an inspiration", "Smoking is harmful to health"}));
		comboBox_4.setBounds(64, 407, 630, 33);
		panel.add(comboBox_4);
		
		JLabel lblTotoroRamen = new JLabel("");
		//label.setIcon(new ImageIcon(GuanliwangjiGUI.class.getResource("/manager/6.jpg")));
		lblTotoroRamen.setBounds(0, 0, 888, 490);
		
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		lblTotoroRamen.setIcon(img);
		
		panel.add(lblTotoroRamen);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//这里需要判断下，id是哪个的id，这里的id是大类里面构造器传入的
				String choice = comboBox.getSelectedItem().toString();
				String choice1 = comboBox_1.getSelectedItem().toString();
				String choice2 = comboBox_2.getSelectedItem().toString();
				String choice3 = comboBox_3.getSelectedItem().toString();
				String choice4 = comboBox_4.getSelectedItem().toString();
				if(choice == "2001" && choice1 == "30" && choice2 == "If you don't work hard in the city for a year, you can't be a witch." &&
				  choice3 == "10%" && choice4 == "Smoking is an inspiration")  {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								setVisible(false);
								AdmReset frame = new AdmReset();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else {
					JOptionPane.showOptionDialog(null, "sorry, your answer are not all correct.", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
				}     
			}
		});
		
	}
}
