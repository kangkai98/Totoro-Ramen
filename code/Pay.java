package code;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class Pay extends JFrame {
	
	private JPanel contentPane;
	
    public static void main(String[] args) {
		    Pay frame = new Pay(0);
		    frame.setVisible(true);
	}
    
    public Pay(double price) {
    	init(price);
    }

	private void init(double price) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/img/6.jpg")));
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
		
		JLabel label = new JLabel("Your meal is total:");
		label.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		label.setBounds(491, 58, 325, 51);
		panel.add(label);
		
		JButton button = new JButton();
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							AddRamen window = new AddRamen();
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
		
		JLabel label_1 = new JLabel(price+"");
		label_1.setFont(new Font("Segoe Print", Font.BOLD, 35));
		label_1.setBounds(609, 134, 176, 83);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u00A3");
		label_2.setFont(new Font("Segoe Print", Font.BOLD, 35));
		label_2.setBounds(562, 139, 37, 72);
		panel.add(label_2);
		
		JButton button_1 = new JButton("Loyalty service");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							UserLogin frame = new UserLogin(price);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button_1.setContentAreaFilled(false);
		button_1.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		button_1.setBounds(520, 244, 262, 51);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Pay directly");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				PayFinish frame = new PayFinish(price);
			}
		});
		button_2.setContentAreaFilled(false);
		button_2.setFont(new Font("Segoe Print", Font.PLAIN, 21));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(520, 329, 262, 51);
		panel.add(button_2);
		
		JLabel label_3 = new JLabel("");
		
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/3.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_3.setIcon(img);

		label_3.setBounds(0, 0, 888, 490);
		panel.add(label_3);
		    	
		setVisible(true);
	}
 }



