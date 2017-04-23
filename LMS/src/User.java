import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class User {

	public static JFrame frame;
	private JTextField txtSearchBook;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User window = new User();
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
	public User() {
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
		
		JButton btnMyAccount = new JButton("My Account");
		btnMyAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMyAccount.setBounds(21, 177, 115, 23);
		frame.getContentPane().add(btnMyAccount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 77, -58, -18);
		frame.getContentPane().add(scrollPane);
		
		txtSearchBook = new JTextField();
		txtSearchBook.setForeground(Color.LIGHT_GRAY);
		txtSearchBook.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtSearchBook.setText("Search book");
		txtSearchBook.setBounds(184, 34, 179, 29);
		frame.getContentPane().add(txtSearchBook);
		txtSearchBook.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(269, 68, 94, 23);
		frame.getContentPane().add(btnSearch);
		
		Choice choice = new Choice();
		choice.setBounds(26, 34, 115, 20);
		frame.getContentPane().add(choice);
		choice.add("Reserved");
		choice.add("Borrowed");
		choice.add("Read");
		
		JButton logout = new JButton("Logout");
		logout.setBounds(21, 211, 115, 23);
		frame.getContentPane().add(logout);
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null, "Do you agree to sign out?", " ", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION){
					frame.setVisible(false);
					frame.dispose();
					Login.main(null);
				}
			}
		});
		
		
		JLabel lblSelectList = new JLabel("View");
		lblSelectList.setBounds(32, 11, 104, 14);
		frame.getContentPane().add(lblSelectList);
		
		JLabel lblList = new JLabel("Book List");
		lblList.setBounds(184, 105, 94, 14);
		frame.getContentPane().add(lblList);
		
		JList list = new JList();
		list.setBounds(184, 130, 179, 105);
		frame.getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Check Out");
		btnNewButton_1.setBounds(21, 77, 115, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				CheckOut.main(null);
			}
			
		});
		
		JButton btnNewButton_2 = new JButton("Check In");
		btnNewButton_2.setBounds(21, 116, 115, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				CheckIn.main(null);
			}
			
		});
		

	}
}
