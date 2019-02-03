package at.hakspittal.carhub.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import at.hakspittal.carhub.Start;
import at.hakspittal.carhub.services.UserService;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class LogIn extends JFrame {

	private static final long serialVersionUID = -55711035025600807L;
	ArrayList<Double> user = new ArrayList<Double>();
	JTextField txtUsern = new JTextField();
	JPasswordField txtPW = new JPasswordField();

	JButton btnReg = new JButton("REGISTER");
	JButton btnLogin = new JButton("LOGIN");

	private Toolkit t;
	private int x = 0, y = 0;
	private int width = 664, height = 454;

	private final UserService userService;
	
	public LogIn() {
		userService = new UserService(Start.getPersistance());

		t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		x = (int) (d.getWidth() - width) / 2;
		y = (int) (d.getHeight() - height) / 2;
		setBounds(x, y, width, height);

		setTitle("CarHub - Login");
		setResizable(false);
		MyActionListener myListener = new MyActionListener();
		btnReg.addActionListener(myListener);
		btnLogin.addActionListener(myListener);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 140, 0));
		getContentPane().setLayout(null);

		JLabel lblLoginToGet = new JLabel("Login to get started");
		lblLoginToGet.setBounds(0, 42, 648, 41);
		lblLoginToGet.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginToGet.setForeground(Color.BLACK);
		lblLoginToGet.setFont(new Font("Daily Mix 3", Font.PLAIN, 35));
		getContentPane().add(lblLoginToGet);

		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		canvas.setBounds(102, 112, 15, 259);
		getContentPane().add(canvas);

		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.BLACK);
		canvas_1.setBounds(524, 112, 15, 259);
		getContentPane().add(canvas_1);

		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(Color.BLACK);
		canvas_2.setBounds(102, 112, 437, 15);
		getContentPane().add(canvas_2);

		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(Color.BLACK);
		canvas_3.setBounds(102, 356, 437, 15);
		getContentPane().add(canvas_3);

		JLabel label = new JLabel("Username:");
		label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		label.setBounds(175, 196, 91, 14);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("Password:");
		label_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		label_1.setBounds(171, 260, 95, 14);
		getContentPane().add(label_1);

		txtUsern.setColumns(10);
		txtUsern.setBounds(307, 194, 146, 20);
		getContentPane().add(txtUsern);

		txtPW = new JPasswordField();
		txtPW.setColumns(10);
		txtPW.setBounds(307, 258, 146, 20);
		getContentPane().add(txtPW);

		btnLogin.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(345, 382, 121, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtUsern.getText().isEmpty() || txtPW.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null, "SOME TEXT FIELDS ARE NOT FILLED", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					
					String password = String.valueOf(txtPW.getPassword());
					String username = txtUsern.getText();
					
					if (userService.login(username, password)) {
						JOptionPane.showMessageDialog(null, "SUCCESFULLY LOGGED IN", "LOGIN",
								JOptionPane.INFORMATION_MESSAGE);
						
						Administration verw = new Administration();
						verw.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "INCORRECT LOGIN DETAILS", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		getContentPane().add(btnLogin);

		btnReg.setForeground(SystemColor.desktop);
		btnReg.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnReg.setBackground(Color.WHITE);
		btnReg.setBounds(175, 382, 153, 23);
		getContentPane().add(btnReg);

	}

	private class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnLogin) {
				dispose();
			}

			if (e.getSource() == btnReg) {
				setVisible(false);
				Register frameReg = new Register();
				frameReg.setVisible(true);
			}
		}
	}
}
