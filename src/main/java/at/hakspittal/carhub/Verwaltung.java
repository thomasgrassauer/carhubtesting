package at.hakspittal.carhub;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Verwaltung extends JFrame{
	private static final long serialVersionUID = -4516355876247291473L;

	private String username;
	
	JButton btnSell = new JButton("SELL CAR");
	JButton btnBuy = new JButton("BUY CAR");
	
	private Toolkit t;
	private int x = 0, y= 0;
	private int width = 787, height = 530; 
	
	public Verwaltung(String username){
		super();
		this.username = username;
	}

	public Verwaltung() {
		t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		x = (int)(d.getWidth() - width) / 2;
		y = (int)(d.getHeight() - height) /2;
		setBounds(x,y,width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("CarHub - Main Menu");
		setResizable(false);
		initialize();
		MyActionListener myListener = new MyActionListener();
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSell.addActionListener(myListener);
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Canvas canvas = new Canvas();
		canvas.setBackground(SystemColor.desktop);
		canvas.setBounds(10, 85, 751, 15);
		getContentPane().add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.BLACK);
		canvas_1.setBounds(10, 466, 751, 15);
		getContentPane().add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(SystemColor.desktop);
		canvas_2.setBounds(10, 85, 15, 396);
		getContentPane().add(canvas_2);
		
		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(Color.BLACK);
		canvas_3.setBounds(746, 85, 15, 396);
		getContentPane().add(canvas_3);
		
		Canvas canvas_4 = new Canvas();
		canvas_4.setBackground(Color.BLACK);
		canvas_4.setBounds(378, 85, 15, 396);
		getContentPane().add(canvas_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Verwaltung.class.getResource("/images/meriwabuy.png")));
		label.setBounds(419, 116, 300, 300);
		getContentPane().add(label);
		btnBuy.addActionListener(myListener);
	}


	private void initialize() {

		getContentPane().setBackground(new Color(255, 140, 0));
		getContentPane().setLayout(null);
		
		JLabel lblAdministration = new JLabel("MAIN MENU");
		lblAdministration.setBounds(0, 38, 771, 41);
		lblAdministration.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministration.setForeground(Color.BLACK);
		lblAdministration.setFont(new Font("Daily Mix 3", Font.PLAIN, 35));
		getContentPane().add(lblAdministration);
		
		
		btnSell.setBounds(143, 427, 114, 23);
		getContentPane().add(btnSell);
		
		
		btnBuy.setBounds(505, 427, 114, 23);
		getContentPane().add(btnBuy);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setIcon(new ImageIcon(Verwaltung.class.getResource("/images/meriwasell.png")));
		lblNewLabel.setBounds(51, 116, 300, 300);
		getContentPane().add(lblNewLabel);
	}
	
	private class MyActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()== btnSell) {
				SellCar sellcar = new SellCar();
				sellcar.setVisible(true);
			}
			
			if (e.getSource()== btnBuy) {
				BuyCar buycar = new BuyCar();
				buycar.setVisible(true);
			}
			
		}
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

}
