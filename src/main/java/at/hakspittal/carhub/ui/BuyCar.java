package at.hakspittal.carhub.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import at.hakspittal.carhub.Car;
import at.hakspittal.carhub.Start;
import at.hakspittal.carhub.services.CarService;

import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;

public class BuyCar extends JFrame{
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
		
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
	
	private final CarService carService;

	private void fillCars() {
		for(Car car : carService.getCars()) {
			carlist.add(car);
			cbCarz.addItem(car.getMake()+" "+car.getModel());
		}
	}
	
	public void CarDetailsGui(){
		int carIndex = cbCarz.getSelectedIndex();
		
		if (carIndex >= 0) {
			Car car = carlist.get(carIndex);
			
			lblCat.setText(car.getCategory());
			lblBrand.setText(car.getMake());
			lblType.setText(car.getModel());
			lblFirstReg.setText(DATEFORMAT.format(car.getDateOfRegistration()));
			lblFt.setText(car.getTypeOfFuel());
			lblKm.setText(String.valueOf(car.getMileage()));
			epDesc.setText(car.getDescription());
		}
	}
	
	public BuyCar() {
		carService = new CarService(Start.getPersistance());
		
		fillCars();
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
		
		lblType.setBounds(176, 281, 161, 14);
		getContentPane().add(lblType);
		
		lblFirstReg.setBounds(176, 313, 161, 14);
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
		public void actionPerformed(ActionEvent event) {

			if (event.getSource()== btnBuy) {
				Car car = (Car)carlist.get(cbCarz.getSelectedIndex());
				if (carService.buyCar(car)) {
					JOptionPane.showMessageDialog(null,
						    "Congratulations!\n" +
							"HAVE FUN WITH YOUR NEW CAR!");
					dispose(); //Fenster schlieﬂen
				} else {
					JOptionPane.showMessageDialog(null, "AN ERROR OCCURRED - PLEASE TRY AGAIN");
				}
			}
			
			if (event.getSource()== btnBack) {
				dispose();
				
			}
		}
	}
	
}
