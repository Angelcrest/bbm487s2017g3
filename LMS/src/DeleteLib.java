import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DeleteLib {

	private JFrame frame;
	private JTextField txtSearchLibrarian;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteLib window = new DeleteLib();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteLib() {
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
		
		txtSearchLibrarian = new JTextField();
		txtSearchLibrarian.setForeground(Color.LIGHT_GRAY);
		txtSearchLibrarian.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtSearchLibrarian.setText("Search Librarian by username");
		txtSearchLibrarian.setBounds(44, 30, 313, 34);
		frame.getContentPane().add(txtSearchLibrarian);
		txtSearchLibrarian.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(272, 85, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(138, 143, 219, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Username:");
		lblName.setBounds(44, 143, 84, 23);
		frame.getContentPane().add(lblName);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(239, 196, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
}
