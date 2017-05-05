import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class NewPassword {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPassword window = new NewPassword();
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
	public NewPassword() {
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

		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(40, 81, 91, 14);
		frame.getContentPane().add(lblEmail);

		JLabel lblUsername = new JLabel("username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(42, 47, 96, 21);
		frame.getContentPane().add(lblUsername);

		textField = new JTextField();
		textField.setBounds(192, 48, 129, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(192, 79, 129, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewPassword.setBounds(42, 105, 89, 21);
		frame.getContentPane().add(lblNewPassword);

		JLabel lblAgainPassword = new JLabel("Again Password:");
		lblAgainPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAgainPassword.setBounds(42, 137, 109, 21);
		frame.getContentPane().add(lblAgainPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(192, 105, 129, 21);
		frame.getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(192, 137, 129, 21);
		frame.getContentPane().add(passwordField_1);

		JButton btnSave = new JButton("Save ");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(151, 175, 109, 21);
		frame.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean record = false;
				int i = 0;
				while (i < Record.getMember().size()) {
					if (Record.getMember().get(i).getUsername().equals(textField.getText())
							&& Record.getMember().get(i).getEmail().equals(textField_1.getText())) {
						if (passwordField.getText().equals(passwordField_1.getText())) {
							Record.getMember().get(i).setPass(passwordField.getText());
							Record.write_member(Record.getMember(), "members.txt");
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect password repeat!!", " ",
									JOptionPane.WARNING_MESSAGE);
						}
						btnSave.setVisible(true);
						frame.setVisible(false);
						frame.dispose();
						Login.main(null);
						record = true;
						break;
					}
					i++;
				}
				i = 0;
				while (i < Record.getLibrarians().size()) {
					if (Record.getLibrarians().get(i).getUsername().equals(textField.getText())
							&& Record.getLibrarians().get(i).getEmail().equals(textField_1.getText())) {
						if (passwordField.getText().equals(passwordField_1.getText())) {
							Record.getLibrarians().get(i).setPass(passwordField.getText());
							Record.write_librarian(Record.getLibrarians(), "librarians.txt");
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect password repeat!!", " ",
									JOptionPane.WARNING_MESSAGE);
						}
						btnSave.setVisible(true);
						frame.setVisible(false);
						frame.dispose();
						Login.main(null);
						record = true;
						break;
					}
					i++;
				}
				if(record == false){
					JOptionPane.showMessageDialog(null, "No such user record exists", " ",
							JOptionPane.INFORMATION_MESSAGE);
					btnSave.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
					NewPassword.main(null);
				}
			}
		});

	}
}
