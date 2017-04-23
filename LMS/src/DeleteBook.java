import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DeleteBook {

	private JFrame frame;
	private JTextField txtSearchBook;
	private JTextField textField;
	private int index = 0;
	private boolean found = false;

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

		JLabel lblBook = new JLabel("Book:");
		lblBook.setBounds(65, 146, 48, 19);
		frame.getContentPane().add(lblBook);

		textField = new JTextField();
		textField.setBounds(123, 144, 246, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(280, 76, 89, 23);
		frame.getContentPane().add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String book = txtSearchBook.getText();
				while (index < Login.record.getBooks().size()) {
					if (Login.record.getBooks().get(index).getName().equals(book)) {
						textField.setForeground(Color.BLACK);
						textField.setFont(new Font("Tahoma", Font.ITALIC, 12));
						textField.setText(Login.record.getBooks().get(index).getName());
						found = true;
						break;
					}
					index++;
				}
				if (found == false) {
					JOptionPane.showMessageDialog(null, "No books found in this name!", " ",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					frame.dispose();
					DeleteBook.main(null);
				}
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(280, 192, 89, 23);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDelete.setVisible(true);
				if (found) {
					Login.record.getBooks().remove(index);
					JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					frame.dispose();
					DeleteBook.main(null);

				} else {
					JOptionPane.showMessageDialog(null, "No books found in this name!", " ",
							JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					frame.dispose();
					DeleteBook.main(null);
				}
			}
			
		});
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(45, 192, 89, 23);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				Librarian.main(null);
			}
			
		});
	}
}
