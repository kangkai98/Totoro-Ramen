package code;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Startup extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startup frame = new Startup();
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
	public Startup() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Startup.class.getResource("/img/6.jpg")));
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
		
		lblNewLabel = new JLabel("Welcome to Totoro Ramen!");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblNewLabel.setBounds(416, 10, 373, 53);
		panel.add(lblNewLabel);
		
		
		//ImageIcon img = new ImageIcon(DengluGUI.class.getResource("C:\\Users\\Vermouth zing\\Desktop\\BP\\1.jpg"));
		
		//img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		
		
		
		JButton btnVustomerService = new JButton("Customer service");
		btnVustomerService.setContentAreaFilled(false);
		btnVustomerService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							AddRamen ar = new AddRamen();
							//UserLogin frame = new UserLogin(0);
							ar.frmTotoroRamen.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnVustomerService.setFont(new Font("Segoe Print", Font.BOLD, 24));
		btnVustomerService.setBounds(465, 112, 253, 76);
		panel.add(btnVustomerService);
		
		JButton btnManagerService = new JButton("Manager service");
		btnManagerService.setContentAreaFilled(false);
		btnManagerService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		
		btnManagerService.setFont(new Font("Segoe Print", Font.BOLD, 24));
		btnManagerService.setBounds(465, 236, 256, 78);
		panel.add(btnManagerService);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEFT);

		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vermouth zing\\Desktop\\BP\\1.jpg"));
		
		//Image img1 = new ImageIcon(this.getClass().getResource("file:///C:/Users/Vermouth%20zing/Desktop/´úÂëÐÂ/XXQ/manager/src/1.jpg")).getImage();
		//lblNewLabel_1.setIcon(new ImageIcon(DengluGUI.class.getResource("/manager/1.jpg")));
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/1.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(img);
		
		lblNewLabel_1.setBounds(0, 0, 888, 490);
		panel.add(lblNewLabel_1);
	}
}
