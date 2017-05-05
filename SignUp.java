import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignUp {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
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

		Label label = new Label("Name:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(73, 31, 88, 24);
		frame.getContentPane().add(label);

		Label label_1 = new Label("Surname:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(73, 61, 88, 24);
		frame.getContentPane().add(label_1);

		Label label_2 = new Label("Password:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(73, 120, 88, 24);
		frame.getContentPane().add(label_2);

		Label label_3 = new Label("Username:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(73, 90, 88, 24);
		frame.getContentPane().add(label_3);

		Label label_4 = new Label("e-mail:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(73, 152, 88, 24);
		frame.getContentPane().add(label_4);

		TextField nmTxt = new TextField();
		nmTxt.setBounds(239, 31, 116, 22);
		frame.getContentPane().add(nmTxt);

		TextField surnmTxt = new TextField();
		surnmTxt.setBounds(239, 61, 116, 22);
		frame.getContentPane().add(surnmTxt);

		TextField usernmTxt = new TextField();
		usernmTxt.setBounds(239, 92, 116, 22);
		frame.getContentPane().add(usernmTxt);

		passwordField = new JPasswordField();
		passwordField.setBounds(239, 120, 116, 24);
		frame.getContentPane().add(passwordField);

		TextField emailTxt = new TextField();
		emailTxt.setBounds(239, 154, 116, 22);
		frame.getContentPane().add(emailTxt);

		JButton button = new JButton("Sign Up");
		button.setBounds(256, 193, 88, 24);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (nmTxt.getText().isEmpty() || surnmTxt.getText().isEmpty() || usernmTxt.getText().isEmpty()
						|| passwordField.getText().isEmpty() || emailTxt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter necessary field!", " ",
							JOptionPane.WARNING_MESSAGE);
					nmTxt.setText(null);
					surnmTxt.setText(null);
					usernmTxt.setText(null);
					passwordField.setText(null);
					emailTxt.setText(null);

				}

				else {
					button.setVisible(true);
					addMember(nmTxt.getText(), surnmTxt.getText(), emailTxt.getText(), usernmTxt.getText(),
							passwordField.getText());
					JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					frame.dispose();
					SignUp.main(null);
				}
			}
		});

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(30, 193, 89, 23);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				LibrarianMain.main(null);
			}

		});
	}

	void addMember(String name, String surname, String email, String user_name, String pass) {

		int index = Record.getMember().size();
		Record.getMember().add(new Person(index + 1, name, surname, email, user_name, pass));
		Record.write_member(new Person(index + 1, name, surname, email, user_name, pass), "members.txt");
	}
}
