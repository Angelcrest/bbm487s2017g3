import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Admin {

	public static  JFrame frame;
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
		
		Label label = new Label("Name:");
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBounds(71, 26, 62, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Surname:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 13));
		label_1.setBounds(71, 54, 82, 22);
		frame.getContentPane().add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(187, 26, 125, 22);
		frame.getContentPane().add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(187, 54, 125, 22);
		frame.getContentPane().add(textField_1);
		
		Label label_2 = new Label("e-mail:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(71, 82, 62, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("Phone:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 13));
		label_3.setBounds(71, 110, 62, 22);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("Username:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 13));
		label_4.setBounds(71, 138, 82, 22);
		frame.getContentPane().add(label_4);
		
		Label label_5 = new Label("Password:");
		label_5.setFont(new Font("Dialog", Font.BOLD, 13));
		label_5.setBounds(71, 166, 82, 22);
		frame.getContentPane().add(label_5);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(187, 82, 125, 22);
		frame.getContentPane().add(textField_2);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(187, 110, 125, 22);
		frame.getContentPane().add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(187, 138, 125, 22);
		frame.getContentPane().add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 166, 131, 22);
		frame.getContentPane().add(passwordField);
		
		JButton logout = new JButton("Logout");
		logout.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(logout);
		logout.addActionListener(new ActionListener(){

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
	}
}
