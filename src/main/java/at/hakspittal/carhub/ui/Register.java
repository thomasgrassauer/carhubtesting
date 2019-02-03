package at.hakspittal.carhub.ui;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import at.hakspittal.carhub.Start;
import at.hakspittal.carhub.User;
import at.hakspittal.carhub.services.UserService;
import at.hakspittal.carhub.services.UserService.RegistrationResult;

import javax.swing.JTextField;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Register extends JFrame{

	private static final long serialVersionUID = 1449409259170527543L;
	private JTextField txtUser;
	private JTextField txtPW;
	private JTextField txtZip;
	private JTextField txtCity;
	private JTextField txtFN;
	private JTextField txtSN;

	JButton btnRegister = new JButton("REGISTER");
	JButton btnLogin = new JButton("LOGIN");


	private Toolkit t;
	private int x = 0, y= 0;
	private int width = 846, height = 575; 

	private final UserService userService;
		
	public Register() {
		this.userService = new UserService(Start.getPersistance());
		
		t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		x = (int)(d.getWidth() - width) / 2;
		y = (int)(d.getHeight() - height) /2;
		setBounds(x,y,width, height);
		setTitle("CarHub - Registration");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initialize();
		setResizable(false);
	}

	
	private void initialize() {
		
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(new Color(255, 140, 0));
		getContentPane().setLayout(null);
		
		JLabel lblWelcomeToCarhub = new JLabel("WELCOME TO CARHUB");
		lblWelcomeToCarhub.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToCarhub.setFont(new Font("Daily Mix 3", Font.PLAIN, 35));
		lblWelcomeToCarhub.setForeground(SystemColor.desktop);
		lblWelcomeToCarhub.setBounds(0, 21, 844, 74);
		getContentPane().add(lblWelcomeToCarhub);
		
		JLabel lblNewLabel = new JLabel("Create an account or Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(115, 149, 626, 20);
		getContentPane().add(lblNewLabel);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(SystemColor.desktop);
		canvas.setBounds(100, 111, 15, 356);
		getContentPane().add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(SystemColor.desktop);
		canvas_1.setBounds(100, 111, 656, 15);
		getContentPane().add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(Color.BLACK);
		canvas_2.setBounds(741, 111, 15, 356);
		getContentPane().add(canvas_2);
		
		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(Color.BLACK);
		canvas_3.setBounds(100, 452, 656, 15);
		getContentPane().add(canvas_3);
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (txtUser.getText().equals("")||txtPW.getText().equals("")||txtZip.getText().equals("")||txtCity.getText().equals("")||txtFN.getText().equals("")||txtSN.getText().equals("")){
					JOptionPane.showMessageDialog(null,
						    "SOME TEXT FIELDS ARE NOT FILLED",
						    "ERROR",
						    JOptionPane.ERROR_MESSAGE);
				}
				else {
					User m1 = new User(
							txtUser.getText(),
							txtPW.getText(),
							txtZip.getText(),
							txtCity.getText(),
							txtFN.getText(),
							txtSN.getText());
					
					RegistrationResult registrationResult = userService.registerUser(m1);
					
					switch(registrationResult) {
						case OK:
							JOptionPane.showMessageDialog(null,
								    "SUCCESFULLY REGISTERED",
								    "REGISTER",
								    JOptionPane.INFORMATION_MESSAGE);
							break;
						case USER_EXISTS:
							JOptionPane.showMessageDialog(null,
								    "USERNAME ALREADY EXISTS",
								    "ERROR",
								    JOptionPane.ERROR_MESSAGE);
							break;
						case ERROR:
						default:
							JOptionPane.showMessageDialog(null,
									"SOMETHING WENT WRONG DURING THE REGISTRATION, TRY AGAIN",
								    "REGISTER",
								    JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnRegister.setBounds(279, 486, 128, 23);
		getContentPane().add(btnRegister);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				LogIn log = new LogIn();
				log.setVisible(true);
			}
		});
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnLogin.setBounds(438, 486, 89, 23);
		getContentPane().add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblUsername.setBounds(167, 235, 91, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblPassword.setBounds(466, 233, 95, 14);
		getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(268, 233, 119, 20);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPW = new JTextField();
		txtPW.setColumns(10);
		txtPW.setBounds(567, 231, 119, 20);
		getContentPane().add(txtPW);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblFirstname.setBounds(167, 310, 91, 14);
		getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblLastname.setBounds(470, 310, 91, 14);
		getContentPane().add(lblLastname);
		
		txtFN = new JTextField();
		txtFN.setColumns(10);
		txtFN.setBounds(268, 308, 119, 20);
		getContentPane().add(txtFN);
		
		txtSN = new JTextField();
		txtSN.setColumns(10);
		txtSN.setBounds(567, 308, 119, 20);
		getContentPane().add(txtSN);
		
		JLabel lblPostalCode = new JLabel("Postal code:");
		lblPostalCode.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblPostalCode.setBounds(155, 381, 103, 14);
		getContentPane().add(lblPostalCode);
		
		txtZip = new JTextField();
		txtZip.setColumns(10);
		txtZip.setBounds(268, 379, 67, 20);
		getContentPane().add(txtZip);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		lblCity.setBounds(519, 381, 42, 14);
		getContentPane().add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(567, 379, 119, 20);
		getContentPane().add(txtCity);
	}
	
}
