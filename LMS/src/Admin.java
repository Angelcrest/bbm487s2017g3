import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Admin {

	public static JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frame.setVisible(true);
					window.frame.setTitle("LMS");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Label nm = new Label("Name:");
		nm.setFont(new Font("Dialog", Font.BOLD, 13));
		nm.setBounds(71, 26, 62, 22);
		frame.getContentPane().add(nm);

		Label surnm = new Label("Surname:");
		surnm.setFont(new Font("Dialog", Font.BOLD, 13));
		surnm.setBounds(71, 54, 82, 22);
		frame.getContentPane().add(surnm);

		TextField nmTxt = new TextField();
		nmTxt.setBounds(187, 26, 125, 22);
		frame.getContentPane().add(nmTxt);

		TextField surnmTxt = new TextField();
		surnmTxt.setBounds(187, 54, 125, 22);
		frame.getContentPane().add(surnmTxt);

		Label email = new Label("e-mail:");
		email.setFont(new Font("Dialog", Font.BOLD, 13));
		email.setBounds(71, 82, 62, 22);
		frame.getContentPane().add(email);

		Label phone = new Label("Phone:");
		phone.setFont(new Font("Dialog", Font.BOLD, 13));
		phone.setBounds(71, 110, 62, 22);
		frame.getContentPane().add(phone);

		Label usernm = new Label("Username:");
		usernm.setFont(new Font("Dialog", Font.BOLD, 13));
		usernm.setBounds(71, 138, 82, 22);
		frame.getContentPane().add(usernm);

		Label pss = new Label("Password:");
		pss.setFont(new Font("Dialog", Font.BOLD, 13));
		pss.setBounds(71, 166, 82, 22);
		frame.getContentPane().add(pss);

		TextField emailTxt = new TextField();
		emailTxt.setBounds(187, 82, 125, 22);
		frame.getContentPane().add(emailTxt);

		TextField phoneTxt = new TextField();
		phoneTxt.setBounds(187, 110, 125, 22);
		frame.getContentPane().add(phoneTxt);

		TextField usernmTxt = new TextField();
		usernmTxt.setBounds(187, 138, 125, 22);
		frame.getContentPane().add(usernmTxt);

		passwordField = new JPasswordField();
		passwordField.setBounds(187, 166, 131, 22);
		frame.getContentPane().add(passwordField);

		JButton logout = new JButton("Logout");
		logout.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(logout);
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Logout.main(null, "Admin");
			}

		});

		JButton btnDeleteLibrarian = new JButton("Delete Librarian");
		btnDeleteLibrarian.setBounds(21, 227, 132, 23);
		frame.getContentPane().add(btnDeleteLibrarian);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(197, 207, 89, 23);
		frame.getContentPane().add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btnSignUp.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
				addLibrarian(nmTxt.getText(), surnmTxt.getText(), emailTxt.getText(), phoneTxt.getText(),
						usernmTxt.getText(), passwordField.getText());
				Admin.main(null);
			}

		});
	}

	void addLibrarian(String name, String surname, String email, String phone, String user_name, String pass) {

		int index = Login.record.getLibrarians().size() - 1;
		Login.record.getLibrarians().add(new Librarians(index + 1, name, surname, email, phone, user_name, pass));
	}
}
