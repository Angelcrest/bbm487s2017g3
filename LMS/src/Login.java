import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Login {

	private JFrame frame;
	public static Record record  = new Record();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		record.getMember().add(new Person(1, "Alper", "Çetinkaya", " ", "alper", "123"));
		record.getLibrarians().add(new Librarians(1, "Merve", "Yetginbal", " ", "123456789", "merve", "123"));
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Login window = new Login(record.getMember(), record.getLibrarians());
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
	public Login(ArrayList<Person> members, ArrayList<Librarians> librarians) {

		initialize(members, librarians);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Person> members, ArrayList<Librarians> librarians) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(149, 77, 68, 23);
		frame.getContentPane().add(lblUsername);

		JTextField textField = new JTextField();
		textField.setBounds(238, 78, 149, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(149, 111, 68, 27);
		frame.getContentPane().add(lblPassword);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(238, 115, 149, 23);
		frame.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(255, 160, 108, 23);
		frame.getContentPane().add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {

			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				boolean recordExist = false;
				boolean emptyField = false;

				/* admin login */
				if (textField.getText().equals("admin") && passwordField.getText().equals("123")) {
					recordExist = true;
					btnLogin.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
					Admin.main(null);
				}
				/* member login */
				if (!members.isEmpty()) {
					int i = 0;
					while (i < members.size()) {
						if (members.get(i).getUsername().equals(textField.getText())) {
							recordExist = true;
							btnLogin.setVisible(true);
							frame.setVisible(false);
							frame.dispose();
							User.main(null);

						}
						i++;
					}

				}
				/* librarian login */
				if (!librarians.isEmpty()) {
					int i = 0;

					while (i < librarians.size()) {
						if (librarians.get(i).getUsername().equals(textField.getText())) {
							recordExist = true;
							btnLogin.setVisible(true);
							frame.setVisible(false);
							frame.dispose();
							Librarian.main(null);

						}
						i++;
					}

				}
				if (textField.getText().equals(" ") || passwordField.getText().equals(" ")) {
					recordExist = true;
					EmptyField.main(null);
				}

				if (recordExist == false)
					NoUser.main(null);
			}

		});

		JButton btnForgotPassword = new JButton("Forgot password");
		btnForgotPassword.setBounds(238, 194, 149, 23);
		frame.getContentPane().add(btnForgotPassword);

		ImageIcon imageIcon = new ImageIcon("book.png");
		Image image = imageIcon.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);

		JPanel panel = new JPanel();
		panel.setBounds(21, 61, 120, 121);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 120, 121);
		panel.add(label);
		label.setIcon(imageIcon);

	}
}
