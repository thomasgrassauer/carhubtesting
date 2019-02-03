package at.hakspittal.carhub.ui;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import at.hakspittal.carhub.DBConnection;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class SellCar extends JFrame {

	private static final long serialVersionUID = -5505565473394061120L;
	JButton btnSell = new JButton("SELL CAR");
	JButton btnBack = new JButton("BACK");
	JComboBox<String> cbCate = new JComboBox<String>();

	JTextField txtBrand = new JTextField();
	JTextField txtType = new JTextField();
	JTextField txtFirstReg = new JTextField();
	JTextField txtFt = new JTextField();
	JTextField txtKM = new JTextField();
	JEditorPane epDesc = new JEditorPane();

	private Toolkit t;
	private int x = 0, y = 0;
	private int width = 814, height = 561;

	public SellCar() {
		t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		x = (int) (d.getWidth() - width) / 2;
		y = (int) (d.getHeight() - height) / 2;
		setBounds(x, y, width, height);
		setTitle("CarHub - SellCar");
		MyActionListener myListener = new MyActionListener();
		btnSell.addActionListener(myListener);
		btnBack.addActionListener(myListener);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		fertl();
		initialize();
	}

	private void initialize() {

		getContentPane().setBackground(new Color(255, 140, 0));
		getContentPane().setLayout(null);

		JLabel lblAdministration = new JLabel("SELL YOUR OLD RyDE");
		lblAdministration.setBackground(Color.BLACK);
		lblAdministration.setBounds(0, 38, 798, 41);
		lblAdministration.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministration.setForeground(Color.BLACK);
		lblAdministration.setFont(new Font("Daily Mix 3", Font.PLAIN, 35));
		getContentPane().add(lblAdministration);
		btnSell.setForeground(new Color(255, 140, 0));
		btnSell.setBackground(SystemColor.desktop);
		btnSell.setFont(new Font("Daily Mix 3", Font.BOLD, 29));
		btnSell.setBounds(533, 427, 212, 47);
		getContentPane().add(btnSell);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategory.setBounds(55, 130, 79, 14);
		getContentPane().add(lblCategory);

		cbCate.setBounds(144, 127, 133, 20);
		getContentPane().add(cbCate);

		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBrand.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrand.setBounds(55, 165, 79, 14);
		getContentPane().add(lblBrand);

		txtBrand.setBounds(144, 162, 133, 20);
		getContentPane().add(txtBrand);
		txtBrand.setColumns(10);

		txtType.setColumns(10);
		txtType.setBounds(144, 193, 133, 20);
		getContentPane().add(txtType);

		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(55, 198, 79, 14);
		getContentPane().add(lblType);

		JLabel lblFirstRegistrationDate = new JLabel("First registration:");
		lblFirstRegistrationDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstRegistrationDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstRegistrationDate.setBounds(31, 232, 106, 14);
		getContentPane().add(lblFirstRegistrationDate);
		txtFirstReg.setToolTipText("YYYY-MM-DD");

		txtFirstReg.setColumns(10);
		txtFirstReg.setBounds(144, 229, 133, 20);
		getContentPane().add(txtFirstReg);

		txtFt.setColumns(10);
		txtFt.setBounds(144, 260, 133, 20);
		getContentPane().add(txtFt);

		JLabel lblFuelType = new JLabel("Fuel type:");
		lblFuelType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFuelType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuelType.setBounds(31, 263, 103, 14);
		getContentPane().add(lblFuelType);

		txtKM.setColumns(10);
		txtKM.setBounds(144, 299, 133, 20);
		getContentPane().add(txtKM);

		JLabel lblKm = new JLabel("KM:");
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKm.setBounds(31, 302, 103, 14);
		getContentPane().add(lblKm);

		JLabel lblShortDescription = new JLabel("Short description:");
		lblShortDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblShortDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblShortDescription.setBounds(31, 353, 103, 14);
		getContentPane().add(lblShortDescription);

		epDesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		epDesc.setBounds(144, 353, 133, 121);
		getContentPane().add(epDesc);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(SellCar.class.getResource("/images/banner1img.jpg")));
		lblNewLabel.setBounds(375, 130, 351, 249);
		getContentPane().add(lblNewLabel);

		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		canvas.setBounds(10, 85, 778, 15);
		getContentPane().add(canvas);

		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.BLACK);
		canvas_1.setBounds(10, 497, 778, 15);
		getContentPane().add(canvas_1);

		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(Color.BLACK);
		canvas_2.setBounds(10, 85, 15, 427);
		getContentPane().add(canvas_2);

		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(Color.BLACK);
		canvas_3.setBounds(773, 85, 15, 427);
		getContentPane().add(canvas_3);

		btnBack.setForeground(new Color(255, 140, 0));
		btnBack.setFont(new Font("Daily Mix 3", Font.BOLD, 29));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(321, 427, 138, 47);
		getContentPane().add(btnBack);
	}

	public void fertl() {
		DBConnection db = new DBConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			db.connectDB();
			stmt = db.getConnection().prepareStatement("select * from category");
			rs = stmt.executeQuery();

			while (rs.next()) {
				cbCate.addItem(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnSell) {

				if ( cbCate.getSelectedIndex() == -1 || txtBrand.getText().isEmpty() ||
					 txtType.getText().isEmpty() || txtFirstReg.getText().isEmpty() ||
					 txtFt.getText().isEmpty() || txtKM.getText().isEmpty() ) {
					
					JOptionPane.showMessageDialog(null, "MISSING ENTRIES");
					
				}
				else {
					DBConnection db = new DBConnection();
					PreparedStatement stmt = null;
					String query = "";
					
					try {
						int number = Integer.parseInt(txtKM.getText());
						query = "INSERT INTO `fahrzeuge`(category, marke, modell, erstzulassung, kraftstoffart, km, description) VALUES ("
								+ "'" + cbCate.getSelectedItem() + "'" + "," + "'" + txtBrand.getText() + "'" + "," + "'"
								+ txtType.getText() + "'" + "," + "'" + txtFirstReg.getText() + "'" + "," + "'"
								+ txtFt.getText() + "'" + "," + "'" + txtKM.getText() + "'" + "," + "'" + epDesc.getText()
								+ "'" + ")";
	
						//System.out.println(query);
	
						try {
							db.connectDB();
	
							stmt = db.getConnection().prepareStatement(query);
							stmt.executeUpdate();
							if (stmt.getUpdateCount() == 0){
								JOptionPane.showMessageDialog(null, "AN ERROR OCCURRED - PLEASE TRY AGAIN");
								
							}
							else {
								JOptionPane.showMessageDialog(null, "YOUR CAR IS REGISTERED");
								dispose(); //Fenster schließen
							}	
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "KM ENTRY WRONG");
					}
				}
			}

			if (e.getSource() == btnBack) {
				setVisible(false);
			}

		}
	}

}
