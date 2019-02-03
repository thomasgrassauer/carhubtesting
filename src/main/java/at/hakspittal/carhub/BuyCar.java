package at.hakspittal.carhub;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;

public class BuyCar extends JFrame{

	private static final long serialVersionUID = -6511467318286881650L;
	JLabel lblCat = new JLabel("");
	JLabel lblBrand = new JLabel("");
	JLabel lblType = new JLabel("");
	JLabel lblFirstReg = new JLabel("");
	JLabel lblFt = new JLabel("");
	JLabel lblKm = new JLabel("");
	JEditorPane epDesc = new JEditorPane();
	JButton btnBuy = new JButton("BUY CAR");
	JButton btnBack = new JButton("BACK");
	
	ArrayList<Car> carlist = new ArrayList<Car>();
	
	ArrayList<Integer> idList = new ArrayList<Integer>();
	
	JComboBox<String> cbCarz = new JComboBox<String>();
	
	private Toolkit t;
	private int x = 0, y= 0;
	private int width = 814, height = 486; 
	

	public void ComboBCarAdd(){
		
		DBConnection db = new DBConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			db.connectDB();
			stmt = db.con.prepareStatement("SELECT * FROM fahrzeuge");	
			rs = stmt.executeQuery();
			
			while(rs.next()){
			
				Car car= new Car(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8));
				carlist.add(car);
			}
			
			
			for (int i = 0;i<carlist.size();i++){
			    
			    cbCarz.addItem(carlist.get(i).getMarke()+" "+carlist.get(i).getModell());
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		} 	 	
					
		

	}
	
	public void CarDetailsGui(){

		int car = cbCarz.getSelectedIndex();
		lblCat.setText(carlist.get(car).getCategory());
		lblBrand.setText(carlist.get(car).getMarke());
		lblType.setText(carlist.get(car).getModell());
		lblFirstReg.setText(String.valueOf(carlist.get(car).getErstzulassung()));
		lblFt.setText(carlist.get(car).getKraftstoffart());
		lblKm.setText(carlist.get(car).getKm());
		epDesc.setText(carlist.get(car).getDesc());

		
	}
	
	public BuyCar() {
		ComboBCarAdd();
		CarDetailsGui();
		t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		x = (int)(d.getWidth() - width) / 2;
		y = (int)(d.getHeight() - height) /2;
		setBounds(x,y,width, height);
		getContentPane().setBackground(new Color(255, 140, 0));
		setTitle("CarHub - BuyCar");
		MyActionListener myListener = new MyActionListener();
		btnBuy.addActionListener(myListener);
		btnBack.addActionListener(myListener);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblBrowseLitRydes = new JLabel("BROWSE LIT RYDES");
		lblBrowseLitRydes.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrowseLitRydes.setForeground(Color.BLACK);
		lblBrowseLitRydes.setFont(new Font("Daily Mix 3", Font.PLAIN, 35));
		lblBrowseLitRydes.setBackground(Color.BLACK);
		lblBrowseLitRydes.setBounds(0, 39, 798, 41);
		getContentPane().add(lblBrowseLitRydes);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		canvas.setBounds(10, 85, 778, 15);
		getContentPane().add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.BLACK);
		canvas_1.setBounds(10, 85, 15, 353);
		getContentPane().add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(Color.BLACK);
		canvas_2.setBounds(10, 423, 778, 15);
		getContentPane().add(canvas_2);
		
		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(Color.BLACK);
		canvas_3.setBounds(773, 85, 15, 353);
		getContentPane().add(canvas_3);
		
		btnBack.setForeground(new Color(255, 140, 0));
		btnBack.setFont(new Font("Daily Mix 3", Font.BOLD, 29));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(347, 360, 138, 47);
		getContentPane().add(btnBack);
		
		
		btnBuy.setForeground(new Color(255, 140, 0));
		btnBuy.setFont(new Font("Daily Mix 3", Font.BOLD, 29));
		btnBuy.setBackground(Color.BLACK);
		btnBuy.setBounds(520, 360, 212, 47);
		getContentPane().add(btnBuy);
		
		JLabel label = new JLabel("Category:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(87, 210, 79, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Brand:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(87, 246, 79, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Type:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(87, 281, 79, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("First registration:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(60, 313, 106, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Fuel type:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(63, 349, 103, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("KM:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(63, 381, 103, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Short description:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(347, 235, 103, 14);
		getContentPane().add(label_6);
		
		
		lblCat.setBounds(176, 210, 161, 14);
		getContentPane().add(lblCat);
		
		
		lblBrand.setBounds(176, 246, 161, 14);
		getContentPane().add(lblBrand);
		
		
		lblType.setBounds(176, 313, 161, 14);
		getContentPane().add(lblType);
		
		
		lblFirstReg.setBounds(176, 281, 161, 14);
		getContentPane().add(lblFirstReg);
		
		
		lblFt.setBounds(176, 349, 161, 14);
		getContentPane().add(lblFt);
		
		
		lblKm.setBounds(176, 381, 161, 14);
		getContentPane().add(lblKm);
		
	
		epDesc.setEditable(false);
		epDesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		epDesc.setBounds(460, 200, 272, 95);
		getContentPane().add(epDesc);
		cbCarz.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		cbCarz.setBounds(60, 121, 672, 60);
		cbCarz.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	CarDetailsGui();
		    }
		});
		getContentPane().add(cbCarz);
	}
	
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource()== btnBuy) {
				
				DBConnection db = new DBConnection();
				PreparedStatement stmt = null;
				String query = "";
				
							
				try {
					Car car = (Car)carlist.get(cbCarz.getSelectedIndex());
					
					db.connectDB();
					query = "DELETE FROM `fahrzeuge` WHERE id = " + car.getId();
					//System.out.println(query);
					stmt = db.con.prepareStatement(query);
					stmt.executeUpdate();
					
					if (stmt.getUpdateCount() == 0){
						JOptionPane.showMessageDialog(null, "AN ERROR OCCURRED - PLEASE TRY AGAIN");
						
					}
					else {
						JOptionPane.showMessageDialog(null,
							    "Congratulations!\n" +
								"HAVE FUN WITH YOUR NEW CAR!");
						dispose(); //Fenster schließen
					}	
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			if (e.getSource()== btnBack) {
				dispose();
				
			}
			
		}
	}
	
}
