import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DeleteLib {

	private JFrame frame;
	private JTextField txtSearchLibrarian;
	private JTextField textField;
	private boolean found = false;
	private int index = 0;

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

		textField = new JTextField();

		textField.setBounds(138, 143, 219, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblName = new JLabel("Username:");
		lblName.setBounds(44, 143, 84, 23);
		frame.getContentPane().add(lblName);
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(272, 85, 89, 23);
		frame.getContentPane().add(btnSearch);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = txtSearchLibrarian.getText();
				while (index < Login.record.getLibrarians().size()) {
					if (Login.record.getLibrarians().get(index).getUsername().equals(user)) {
						textField.setForeground(Color.BLACK);
						textField.setFont(new Font("Tahoma", Font.ITALIC, 12));
						textField.setText(Login.record.getLibrarians().get(index).getUsername());
						found = true;
						break;
					}
					index++;
				}
				if (found == false) {
					JOptionPane.showMessageDialog(null, "No such user record exists!", " ",
							JOptionPane.WARNING_MESSAGE);
					frame.setVisible(false);
					frame.dispose();
					DeleteLib.main(null);
				}
			}

		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(239, 196, 89, 23);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDelete.setVisible(true);
				if (found) {
					Login.record.getLibrarians().remove(index);
					JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					frame.dispose();
					DeleteLib.main(null);

				} else {
					JOptionPane.showMessageDialog(null, "No such user record exists!", " ",
							JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					frame.dispose();
					DeleteLib.main(null);
				}
			}

		});

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(22, 215, 89, 23);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnHome.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
				Admin.main(null);
			}

		});
	}

}
