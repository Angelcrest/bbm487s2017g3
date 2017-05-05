import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class LibrarianMain {

	public static JFrame frame;
	private JTextField txtSearchMember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianMain window = new LibrarianMain();
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
	public LibrarianMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton logout = new JButton("Logout");
		logout.setBounds(437, 227, 89, 23);
		frame.getContentPane().add(logout);
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null, "Do you agree to sign out?", " ",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					frame.setVisible(false);
					frame.dispose();
					Login.main(null);
				}
			}

		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Book Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 27, 242, 173);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnSearchBook = new JButton("Search Book");
		btnSearchBook.setBounds(10, 29, 208, 23);
		panel_1.add(btnSearchBook);
		btnSearchBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				Books.main(null);
			}

		});

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(10, 63, 208, 23);
		panel_1.add(btnAddBook);
		btnAddBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				AddBook.main(null);
			}

		});

		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setBounds(10, 98, 208, 23);
		panel_1.add(btnDeleteBook);
		btnDeleteBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				DeleteBook.main(null);
			}

		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Member Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(283, 27, 271, 173);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.setBounds(26, 29, 212, 23);
		panel_2.add(btnAddMember);
		btnAddMember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				SignUp.main(null);
			}

		});

		JButton btnEditMember = new JButton("Edit Member");
		btnEditMember.setBounds(26, 111, 212, 23);
		panel_2.add(btnEditMember);

		txtSearchMember = new JTextField();
		txtSearchMember.setForeground(Color.LIGHT_GRAY);
		txtSearchMember.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtSearchMember.setText("Search member by user name");
		txtSearchMember.setBounds(26, 74, 212, 23);
		panel_2.add(txtSearchMember);
		txtSearchMember.setColumns(10);
		btnEditMember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int index = 0;
				boolean found = false;
				if (txtSearchMember.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Search field cannot be empty!", " ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					while (index < Record.getMember().size()) {

						if (Record.getMember().get(index).getUsername().equals(txtSearchMember.getText())) {
							found = true;
							frame.setVisible(false);
							frame.dispose();
							Account.main(Record.getMember().get(index).getP_id(), true);
							break;
						}
						index++;
					}
					if (found == false) {
						JOptionPane.showMessageDialog(null, "No such user record exists!", " ",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

	}
}
