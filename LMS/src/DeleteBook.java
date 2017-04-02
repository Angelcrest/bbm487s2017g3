import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DeleteBook {

	private JFrame frame;
	private JTextField txtSearchBook;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBook window = new DeleteBook();
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
	public DeleteBook() {
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
		
		txtSearchBook = new JTextField();
		txtSearchBook.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtSearchBook.setForeground(Color.LIGHT_GRAY);
		txtSearchBook.setText("Search Book");
		txtSearchBook.setBounds(45, 35, 324, 30);
		frame.getContentPane().add(txtSearchBook);
		txtSearchBook.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(280, 76, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblBook = new JLabel("Book:");
		lblBook.setBounds(65, 146, 48, 19);
		frame.getContentPane().add(lblBook);
		
		textField = new JTextField();
		textField.setBounds(123, 144, 246, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(280, 192, 89, 23);
		frame.getContentPane().add(btnDelete);
	}

}
