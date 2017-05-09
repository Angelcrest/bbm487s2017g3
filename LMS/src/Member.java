import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.impl.duration.TimeUnit;

public class Member {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member window = new Member(id);
					window.frame.setVisible(true);
					window.frame.setTitle("LMS");
					Person.check_fine(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Member(int id) {
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {

		frame = new JFrame();
		frame.setBounds(100, 100, 690, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnMyAccount = new JButton("My Account");
		btnMyAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMyAccount.setBounds(21, 140, 115, 23);
		frame.getContentPane().add(btnMyAccount);
		btnMyAccount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Account.main(id, false);
				frame.dispose();
				frame.setVisible(false);

			}
		});

		Choice choice = new Choice();
		choice.setBounds(207, 140, 115, 83);
		frame.getContentPane().add(choice);
		choice.add("Reserved");
		choice.add("Borrowed");
		choice.add("Read");

		JLabel lblSelectList = new JLabel("View");
		lblSelectList.setBounds(207, 120, 104, 14);
		frame.getContentPane().add(lblSelectList);

		JLabel lblList = new JLabel("Book List");
		lblList.setBounds(343, 120, 94, 14);
		frame.getContentPane().add(lblList);

		JTextField textField = new JTextField();
		textField.setForeground(Color.black);
		textField.setFont(new Font("Tahoma", Font.HANGING_BASELINE, 13));
		textField.setColumns(10);
		textField.setBounds(21, 36, 301, 28);
		frame.getContentPane().add(textField);

		JButton btnNewButton_1 = new JButton("Check Out");
		btnNewButton_1.setBounds(207, 77, 115, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				int index = 0;
				boolean found = false;
				while (index < Record.getBooks().size()) {
					if (Record.getBooks().get(index).getBarcode().equals(textField.getText())) {
						if (Record.getBooks().get(index).isBorrowed() == true) {
							JOptionPane.showMessageDialog(null, "This book is borrowed!", " ",
									JOptionPane.WARNING_MESSAGE);
						} else {
							Record.getBooks().get(index).setBorrowed(true);
							Record.write_book(Record.getBooks(), "books.txt");
							int index_p = 0;
							while (index_p < Record.getMember().size()) {
								if (id == Record.getMember().get(index_p).getP_id())
									break;
								index_p++;
							}
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
							Record.write_reserved(Record.getMember().get(index_p), Record.getBooks().get(index),
									sdf.format(cal.getTime()), "reserved.txt");
							JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
						}
						found = true;
						break;
					}
					index++;
				}
				if (found == false) {
					JOptionPane.showMessageDialog(null, "No books found in this barcode!", " ",
							JOptionPane.WARNING_MESSAGE);
				}
				textField.setText(null);
			}

		});

		JButton btnNewButton_2 = new JButton("Check In");
		btnNewButton_2.setBounds(21, 77, 115, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				int index = 0;
				boolean found = false;
				while (index < Record.getBooks().size()) {
					if (Record.getBooks().get(index).getBarcode().equals(textField.getText())) {
						if (Record.getBooks().get(index).isBorrowed() == false) {
							JOptionPane.showMessageDialog(null, "This book is not borrowed!", " ",
									JOptionPane.WARNING_MESSAGE);
						} else {
							Record.getBooks().get(index).setBorrowed(false);
							Record.write_book(Record.getBooks(), "books.txt");
							int index_p = 0;
							while (index_p < Record.getMember().size()) {
								if (id == Record.getMember().get(index_p).getP_id())
									break;
								index_p++;
							}
							Record.delete_reserved(Record.getMember().get(index_p), Record.getBooks().get(index),
									"reserved.txt");
							JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
						}
						found = true;
						break;
					}
					index++;
				}
				if (found == false) {
					JOptionPane.showMessageDialog(null, "No books found in this barcode!", " ",
							JOptionPane.WARNING_MESSAGE);
				}
				textField.setText(null);
			}

		});

		JTextField txtSearchBook = new JTextField();
		txtSearchBook.setForeground(Color.LIGHT_GRAY);
		txtSearchBook.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtSearchBook.setText("Search book");
		txtSearchBook.setBounds(343, 36, 301, 28);
		frame.getContentPane().add(txtSearchBook);
		txtSearchBook.setColumns(10);

		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(new Object[][] {}, new String[] { "Name", "Borrowed", "Waiting" });
		JTable table = new JTable(model);
		table.getColumn("Waiting").setCellRenderer(new ButtonRenderer());
		table.getColumn("Waiting").setCellEditor(new ButtonEditor(new JCheckBox()));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(353, 140, 294, 200);
		frame.getContentPane().add(scrollPane);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(550, 77, 94, 23);
		frame.getContentPane().add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String book = txtSearchBook.getText();
				int index = 0;
				boolean found = false;
				while (index < Record.getBooks().size()) {
					if (Record.getBooks().get(index).getName().equals(book)) {
						if (Record.getBooks().get(index).isBorrowed()) {
							model.setDataVector(
									new Object[][] { { Record.getBooks().get(index).getName(), "Borrowed", "add" } },
									new String[] {});

						} else {
							model.addRow(new Object[] { Record.getBooks().get(index).getName(), "On The Shelf" });
						}

						found = true;

						break;
					}
					index++;
				}
				if (found == false) {
					JOptionPane.showMessageDialog(null, "No books found in this name!", " ",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton logout = new JButton("Logout");
		logout.setBounds(21, 331, 115, 23);
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
	}

	
}
