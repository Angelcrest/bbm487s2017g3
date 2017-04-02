import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;

public class SignUp {

	private JFrame frame;

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
		
		TextField textField = new TextField();
		textField.setBounds(239, 31, 116, 22);
		frame.getContentPane().add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(239, 61, 116, 22);
		frame.getContentPane().add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(239, 92, 116, 22);
		frame.getContentPane().add(textField_2);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(239, 124, 116, 22);
		frame.getContentPane().add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(239, 154, 116, 22);
		frame.getContentPane().add(textField_4);
		
		Button button = new Button("Sign Up");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(169, 198, 88, 24);
		frame.getContentPane().add(button);
	}

}
