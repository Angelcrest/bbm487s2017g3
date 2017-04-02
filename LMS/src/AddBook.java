import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook();
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
	public AddBook() {
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
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(76, 33, 66, 23);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(168, 33, 126, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthor.setBounds(76, 79, 66, 16);
		frame.getContentPane().add(lblAuthor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 78, 126, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYear.setBounds(76, 127, 55, 16);
		frame.getContentPane().add(lblYear);
		
		textField_2 = new JTextField();
		textField_2.setBounds(168, 126, 126, 23);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(151, 190, 118, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHome.setBounds(322, 227, 89, 23);
		frame.getContentPane().add(btnHome);
	}

}
