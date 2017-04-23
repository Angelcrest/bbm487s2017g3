import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class NewPassword {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewPassword.setBounds(89, 69, 89, 21);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblAgainPassword = new JLabel("Again Password:");
		lblAgainPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAgainPassword.setBounds(89, 101, 109, 21);
		frame.getContentPane().add(lblAgainPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(208, 69, 129, 21);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(208, 101, 129, 21);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnSave = new JButton("Save ");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(151, 175, 109, 21);
		frame.getContentPane().add(btnSave);
	}
}
