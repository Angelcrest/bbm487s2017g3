import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Librarian {

	private JFrame frame;
	private JTextField txtSearchMember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian window = new Librarian();
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
	public Librarian() {
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
		
		JButton logout = new JButton("Logout");
		logout.setBounds(307, 227, 89, 23);
		frame.getContentPane().add(logout);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Book Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 189, 145);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSearchBook = new JButton("Search Book");
		btnSearchBook.setBounds(10, 29, 156, 23);
		panel_1.add(btnSearchBook);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(10, 63, 156, 23);
		panel_1.add(btnAddBook);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setBounds(10, 98, 156, 23);
		panel_1.add(btnDeleteBook);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Member Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(209, 11, 215, 145);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.setBounds(26, 29, 164, 23);
		panel_2.add(btnAddMember);
		
		JButton btnEditMember = new JButton("Edit Member");
		btnEditMember.setBounds(26, 111, 164, 23);
		panel_2.add(btnEditMember);
		
		txtSearchMember = new JTextField();
		txtSearchMember.setForeground(Color.LIGHT_GRAY);
		txtSearchMember.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtSearchMember.setText("Search member");
		txtSearchMember.setBounds(26, 74, 164, 23);
		panel_2.add(txtSearchMember);
		txtSearchMember.setColumns(10);
		
	}
}
