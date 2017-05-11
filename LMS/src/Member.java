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
					check_waiting_list(id);
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
		frame.setBounds(100, 100, 665, 418);
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
								if (id == Record.getMember().get(index_p).getP_id()) {
									Record.getMember().get(index_p).getB().add(Record.getBooks().get(index));
									break;
								}
								index_p++;
							}
							Record.delete_reserved(Record.getMember().get(index_p), Record.getBooks().get(index),
									"reserved.txt");
							Record.write_reading(Record.getMember(), "reading.txt");
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
		txtSearchBook.setBounds(343, 36, 279, 28);
		frame.getContentPane().add(txtSearchBook);
		txtSearchBook.setColumns(10);

		JTextArea textPane = new JTextArea();
		textPane.setBounds(343, 140, 279, 105);
		frame.getContentPane().add(textPane);
		

		Choice choice = new Choice();
		choice.setBounds(207, 140, 115, 83);
		frame.getContentPane().add(choice);
		choice.add("List Your Book");
		choice.add("Reserved");
		choice.add("Read");
		choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String data = choice.getItem(choice.getSelectedIndex());
				if(data.equals("Reserved")){
					int index_p = 0, index_b = 0;
					while (index_p < Record.getReserved().size()) {
						if (Record.getReserved().get(index_p).getP().getP_id() == id) {
							while (index_b < Record.getReserved().get(index_p).getB().size()) {
						
								textPane.append(Record.getReserved().get(index_p).getB().get(index_b).getName()+ "\n");
								index_b++;
							}
							break;
						}

						index_p++;
					}
					
				}else if(data.equals("Read")){
					int index_p = 0, index_b = 0;
					while (index_p < Record.getMember().size()) {
						if (Record.getMember().get(index_p).getP_id() == id) {
							while (index_b < Record.getMember().get(index_p).getB().size()) {
								textPane.setText(Record.getMember().get(index_p).getB().get(index_b).getName() + "\n");
								index_b++;
							}
							break;
						}

						index_p++;
					}
				}
			}
		});
		
		JButton btnNewButton = new JButton("Add Waiting List");
		btnNewButton.setBounds(429, 256, 193, 23);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(477, 77, 145, 23);
		frame.getContentPane().add(btnSearch);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textPane.setText(null);
				String book = txtSearchBook.getText();
				int index = 0;
				boolean found = false;
				while (index < Record.getBooks().size()) {
					if (Record.getBooks().get(index).getName().equals(book)) {
						if (Record.getBooks().get(index).isBorrowed()) {
							textPane.setText(Record.getBooks().get(index).getName() + "\t\t Borrowed");
							btnNewButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									int i = 0;
									while (i < Record.getMember().size()) {
										if (Record.getMember().get(i).getP_id() == id)
											break;
										i++;
									}
									int j = 0;
									while (j < Record.getBooks().size()) {
										if (Record.getBooks().get(j).getName().equals(book)) {
											break;
										}
										j++;
									}
									Record.write_Waiting(Record.getMember().get(i), Record.getBooks().get(j),
											"waiting.txt");
									JOptionPane.showMessageDialog(null, "Successful", " ",
											JOptionPane.INFORMATION_MESSAGE);
								}
							});

							frame.getContentPane().add(btnNewButton);

						} else {
							textPane.setText(Record.getBooks().get(index).getName() + "\t\t Shelf");
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

	static void check_waiting_list(int id) {
		int index1 = 0, index2 = 0;
		while (index1 < Record.getWaiting().size()) {
			if (!Record.getWaiting().get(index1).getB().isBorrowed()) {
				while (index2 < Record.getWaiting().get(index1).getP().size()) {
					if (Record.getWaiting().get(index1).getP().get(index2).getP_id() == id) {
						JOptionPane.showMessageDialog(null, "The books you expect are on the shelf", " ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					index2++;
				}
			}

			index1++;
		}
	}
}
