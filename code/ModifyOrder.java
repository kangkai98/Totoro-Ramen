package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import code.ExcelHandler.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class ModifyOrder {
	
	public static double price = 0;
	//record total price

	JFrame frmTotoroRamen;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ModifyOrder window = new ModifyOrder();
	}
	
	public void setPrice(double add){
		price = price + add;
	}

	/**
	 * Create the application.
	 */
	
	public ModifyOrder() {
		initialize();		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmTotoroRamen = new JFrame();
		frmTotoroRamen.setTitle("Totoro Ramen");
		frmTotoroRamen.setIconImage(Toolkit.getDefaultToolkit().getImage(AddRamen.class.getResource("/img/6.jpg")));
		frmTotoroRamen.setBounds(150, 75, 888, 525);
		frmTotoroRamen.setLocationRelativeTo(null);
		frmTotoroRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTotoroRamen.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 888, 490);
		frmTotoroRamen.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 490);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon img = new ImageIcon("src/img/ramen.png");
	
		JButton button = new JButton("");
		
		ImageIcon img1 = new ImageIcon(Startup.class.getResource("/img/jiantouwhite.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(35, 35,Image.SCALE_DEFAULT));
		button.setIcon(img1);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddRamen();

				frmTotoroRamen.setVisible(false);
			}
		});
		
		ImageIcon img3 = new ImageIcon(Startup.class.getResource("/img/ramen3.jpg"));
		img3.setImage(img3.getImage().getScaledInstance(452,452,Image.SCALE_DEFAULT));
		
		JLabel label = new JLabel();
		label.setIcon(img3);
		
		label.setBounds(385,0, 478,452);
		panel.add(label);
		
		JLabel lblChooseYourRamen = new JLabel("choose  your  RAMEN!");
		lblChooseYourRamen.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		lblChooseYourRamen.setBounds(60, 0, 299, 51);
		panel.add(lblChooseYourRamen);
		button.setBounds(0, 0, 35, 35);		
		panel.add(button);
		
		String data[][] = new String[AddRamen.order.size()][8] ;
		String[] dataTitle = {"Soup","Noodles","Onion","Spiciness","Nori","Chashu","egg","shoots"};
		for(int i=0;i<AddRamen.order.size();i++) {
			//String[] line = {AddRamen.list[i].Soup,AddRamen.list[i].Noodles,AddRamen.list[i].S_O,AddRamen.list[i].Spiciness,AddRamen.list[i].Nori+"",AddRamen.list[i].Chashu+"",AddRamen.list[i].Boiled_egg+"",AddRamen.list[i].Shoots+""};
			String[] line = {AddRamen.order.get(i).Soup,AddRamen.order.get(i).Noodles,AddRamen.order.get(i).S_O,AddRamen.order.get(i).Spiciness,AddRamen.order.get(i).Nori+"",AddRamen.order.get(i).Chashu+"",AddRamen.order.get(i).Boiled_egg+"",AddRamen.order.get(i).Shoots+""};
			data[i] = line;
		}

		table = new JTable(data,dataTitle);		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 61, 349, 391);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scroll);
		
		table.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent event)
            {
                    int row = table.rowAtPoint(event.getPoint());
                    new AddOn(row);
                    frmTotoroRamen.setVisible(false);
            }
        });
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 0, 888, 490);
		panel.add(label_3);
		
		ImageIcon img2 = new ImageIcon(Startup.class.getResource("/img/5.jpg"));
		img2.setImage(img2.getImage().getScaledInstance(888, 490,Image.SCALE_DEFAULT));
		label_3.setIcon(img2);
				
		this.frmTotoroRamen.setVisible(true);
		
	}
}