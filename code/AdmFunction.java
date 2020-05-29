package code;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;

public class AdmFunction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmFunction frame = new AdmFunction();
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
	public AdmFunction() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdmFunction.class.getResource("/img/6.jpg")));
		setTitle("Totoro Ramen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 75, 888, 525);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
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
		button.setContentAreaFilled(false);
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantoublue.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		button.setIcon(img1);
		button.setBounds(0, 0, 35, 35);
		contentPane.add(button);
		
		/*
		JToggleButton tglbtnYes = new JToggleButton("yes");
		tglbtnYes.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		tglbtnYes.setBounds(657, 362, 84, 41);
		contentPane.add(tglbtnYes);
		
		JLabel lblMailTheReport = new JLabel("mail the report to me");
		lblMailTheReport.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblMailTheReport.setBounds(384, 356, 253, 53);
		contentPane.add(lblMailTheReport);
		*/
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 490);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPleaseChooseThe = new JLabel("please choose the function");
		lblPleaseChooseThe.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		lblPleaseChooseThe.setBounds(416, 10, 373, 53);
		contentPane.add(lblPleaseChooseThe);
		
		JButton btnModifyMenu = new JButton("Modify menu");
		btnModifyMenu.setContentAreaFilled(false);
		btnModifyMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							File file=new File("src/xls/price.xls");
							Workbook workbook;
							try {
								workbook = Workbook.getWorkbook(file);
								
								Sheet sheet=workbook.getSheet(0);
								
								Cell cell0=sheet.getCell(0, 1);
								Cell cell1=sheet.getCell(1, 1);
								Cell cell2=sheet.getCell(2, 1);
								Cell cell3=sheet.getCell(3, 1);
								
								setVisible(false);
								AdmModify frame = new AdmModify(cell0.getContents(),cell1.getContents(),cell2.getContents(),cell3.getContents());
								frame.setVisible(true);

							} catch (BiffException | IOException e) {
								
								e.printStackTrace();
							}
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnModifyMenu.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		btnModifyMenu.setBounds(465, 112, 253, 76);
		contentPane.add(btnModifyMenu);
		
		JButton btnViewStatus = new JButton("View stats");
		btnViewStatus.setContentAreaFilled(false);
		btnViewStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnViewStatus.setFont(new Font("Segoe Print", Font.PLAIN, 27));
		btnViewStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart bc = new BarChart();
			}
		});
		btnViewStatus.setBounds(465, 236, 256, 78);
		contentPane.add(btnViewStatus);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon(GuanlixuanzeGUI.class.getResource("/manager/2.jpg")));
		
		ImageIcon img = new ImageIcon(Startup.class.getResource("/img/2.jpg"));
		img.setImage(img.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label.setIcon(img);
		
		label.setBounds(0, 0, 888, 490);
		contentPane.add(label);
	}

}

