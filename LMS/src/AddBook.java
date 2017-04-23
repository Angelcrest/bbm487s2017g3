import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.*;


import javax.swing.JTextField;
import javax.swing.JButton;

public class AddBook {

	private JFrame frame;
	private JTextField nmTxt;
	private JTextField authorTxt;
	private JTextField yearTxt;
	private JTextField textField;

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
		
		nmTxt = new JTextField();
		nmTxt.setBounds(168, 33, 126, 22);
		frame.getContentPane().add(nmTxt);
		nmTxt.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthor.setBounds(76, 67, 66, 16);
		frame.getContentPane().add(lblAuthor);
		
		authorTxt = new JTextField();
		authorTxt.setBounds(168, 65, 126, 23);
		frame.getContentPane().add(authorTxt);
		authorTxt.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYear.setBounds(76, 107, 55, 16);
		frame.getContentPane().add(lblYear);
		
		yearTxt = new JTextField();
		yearTxt.setBounds(168, 105, 126, 23);
		frame.getContentPane().add(yearTxt);
		yearTxt.setColumns(10);
		
		JLabel lblBarcode = new JLabel("Barcode:");
		lblBarcode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBarcode.setBounds(76, 142, 66, 23);
		frame.getContentPane().add(lblBarcode);
		
		textField = new JTextField();
		textField.setBounds(168, 144, 126, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(151, 190, 118, 23);
		frame.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addBook(nmTxt.getText(), authorTxt.getText(), yearTxt.getText(), textField.getText(), false);
				JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				frame.dispose();
				AddBook.main(null);
			}
			
		});
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHome.setBounds(322, 227, 89, 23);
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

	void addBook(String name, String author, String year, String brcode, boolean st){
		int index = Login.record.getBooks().size()-1;
		Login.record.getBooks().add(new Book(index+1, name, author, year, brcode, st));
	}
}
