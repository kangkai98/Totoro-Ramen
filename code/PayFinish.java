package code;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.text.SimpleDateFormat;

public class PayFinish extends JFrame {
	
	private JPanel contentPane;
	private int check = 0;
	private int loyalty = 0;
	private String name;
	private String id;
	private int stamp;

	
    public static void main(String[] args) {
    		PayFinish frame = new PayFinish(0);
		    frame.setVisible(true);
	}
    
    
    public PayFinish(double price) {
    	init(price);
    }
    
    public PayFinish(String n,double price) {
    	name = ExcelHandler.getName(n);
    	stamp = Integer.parseInt(ExcelHandler.getStamp(n));
    	id = n;
    	loyalty = 1;
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
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(50, 0, 350, 80);
		panel.add(lblNewLabel_3);
		
		
		JCheckBox CheckBoxStamp = new JCheckBox("      stamp : "+stamp);
		CheckBoxStamp.setForeground(Color.DARK_GRAY);
		CheckBoxStamp.setBackground(Color.WHITE);
		CheckBoxStamp.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		CheckBoxStamp.setBounds(49, 312, 297, 37);
		CheckBoxStamp.setVisible(false);
		panel.add(CheckBoxStamp);
		
		JLabel lblNewLabel = new JLabel(price+"");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 40));
		lblNewLabel.setBounds(605, 57, 311, 37);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Pay frame = new Pay(price);
			    frame.setVisible(true);
			}
		});
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantouwhite.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		
		btnNewButton.setIcon(img1);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(0, 0, 35, 35);
		panel.add(btnNewButton);
		
		JCheckBox CheckBoxCash = new JCheckBox("     Cash");
		CheckBoxCash.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		CheckBoxCash.setOpaque(true);
		CheckBoxCash.setBackground(Color.WHITE);
		CheckBoxCash.setBounds(49, 145, 195, 37);
		panel.add(CheckBoxCash);
		
		JCheckBox CheckBoxCard = new JCheckBox("     Card");
		CheckBoxCard.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		CheckBoxCard.setOpaque(true);
		CheckBoxCard.setBackground(Color.WHITE);
		CheckBoxCard.setBounds(49, 210, 195, 37);
		panel.add(CheckBoxCard);
		
		CheckBoxCash.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即复选框本身）
            	if(CheckBoxCash.isSelected()) CheckBoxCard.setEnabled(false);
            	else CheckBoxCard.setEnabled(true);
            }
        });
		
		CheckBoxCard.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即复选框本身）
            	if(CheckBoxCard.isSelected()) CheckBoxCash.setEnabled(false);
            	else CheckBoxCash.setEnabled(true);
            }
        });
		
		CheckBoxStamp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(CheckBoxStamp.isSelected()) {
					if (stamp<10) {
						CheckBoxStamp.setForeground(Color.RED);
						CheckBoxStamp.setText("      stamp : "+stamp+" (not enough)");
					}
		    		if (price>9.99)
		    			lblNewLabel.setText(price-9.99+"");
		    		else 
		    			lblNewLabel.setText(0.01+"");
		    	}
		    	
		    	else {
		    		if (stamp<10) {
						CheckBoxStamp.setForeground(Color.DARK_GRAY);
						CheckBoxStamp.setText("      stamp : "+stamp);
					}
		    		if (lblNewLabel.getText().equals("0.01"))
		    			lblNewLabel.setText(9.99+"");
		    		else 
		    			lblNewLabel.setText(Double.parseDouble(lblNewLabel.getText())+9.99+"");
		    	}
			}
		});

		
		JButton btnNewButton_1 = new JButton("Confirm the payment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//结算
				//setVisible(false); 
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(CheckBoxCash.isSelected()||CheckBoxCard.isSelected()) {
					
					Stamp s = new Stamp();
					if(CheckBoxStamp.isSelected()) {
						if(s.judge(id)==0) {
							JOptionPane.showOptionDialog(null, "You don't have enough stamps!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
						}
						else {
							s.consume(id);
							ExcelHandler.ModifyStamp(id,AddRamen.order.size());
							JOptionPane.showOptionDialog(null, "Successful order!", " ", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,null,new Object[] {"OK"},null);
							Date t = new Date();
				        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        	
				        	AddRamen ar  = new AddRamen(); 
				        	ar.frmTotoroRamen.setVisible(false);
				        	
				        	for (int j=0;j<AddRamen.order.size();j++){
				        		ExcelHandler.ModifyInventory(AddRamen.order.get(j).Nori,AddRamen.order.get(j).Chashu,AddRamen.order.get(j).Boiled_egg,AddRamen.order.get(j).Shoots);
				        		ExcelHandler.ModifyOrder(AddRamen.order.get(j).Soup,AddRamen.order.get(j).Noodles,AddRamen.order.get(j).S_O,AddRamen.order.get(j).Spiciness,df.format(t),AddRamen.order.get(j).Nori,AddRamen.order.get(j).Chashu,AddRamen.order.get(j).Boiled_egg,AddRamen.order.get(j).Shoots);
				        	}
							setVisible(false);
						}
					}
					else {
						if (loyalty == 1)
							ExcelHandler.ModifyStamp(id,AddRamen.order.size());
						JOptionPane.showOptionDialog(null, "Successful order!", " ", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,null,new Object[] {"OK"},null);
						Date t = new Date();
			        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        	
			        	AddRamen ar  = new AddRamen(); 
			        	ar.frmTotoroRamen.setVisible(false);
			        	
			        	for (int j=0;j<AddRamen.order.size();j++){
			        		ExcelHandler.ModifyInventory(AddRamen.order.get(j).Nori,AddRamen.order.get(j).Chashu,AddRamen.order.get(j).Boiled_egg,AddRamen.order.get(j).Shoots);
			        		ExcelHandler.ModifyOrder(AddRamen.order.get(j).Soup,AddRamen.order.get(j).Noodles,AddRamen.order.get(j).S_O,AddRamen.order.get(j).Spiciness,df.format(t),AddRamen.order.get(j).Nori,AddRamen.order.get(j).Chashu,AddRamen.order.get(j).Boiled_egg,AddRamen.order.get(j).Shoots);
			        	}
						setVisible(false);
					}
					
				}
				
				else JOptionPane.showOptionDialog(null, "Please select the mode of payment!", " ", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"OK"},null);
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(87, 399, 299, 51);
		panel.add(btnNewButton_1);
		
		JLabel lblTotalPayment = new JLabel("Total payment:");
		lblTotalPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPayment.setFont(new Font("Segoe Print", Font.PLAIN, 28));
		lblTotalPayment.setBounds(595, 10, 321, 37);
		panel.add(lblTotalPayment);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the mode of payment:");
		lblPleaseSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectThe.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblPleaseSelectThe.setBounds(30, 69, 475, 70);
		panel.add(lblPleaseSelectThe);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.WHITE);
		
		ImageIcon img2 = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img2.setImage(img2.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_2.setIcon(img2);
		
		label_2.setBounds(0, -15, 888, 490);
		panel.add(label_2);
		
		

		
		if(loyalty == 1) {
			lblNewLabel_3.setText("Welcome to Totoro, dear " + name);
			CheckBoxStamp.setVisible(true);
		}
		
		
		
		setVisible(true);
	}
 }

