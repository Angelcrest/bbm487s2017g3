import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Account {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtusername;
	private JPasswordField passwordField;
	private JTextField txtemail;
	private JTextField txtfine;
	private int index = 0;

	/**
	 * Launch the application.
	 */
	public static void main(int id,boolean type) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account(id,type);
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
	public Account(int id,boolean type) {
		initialize(id,type);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id,boolean type) {
		
		while (index < Login.record.getMember().size()) {
			if (id == Login.record.getMember().get(index).getP_id()) {
				break;
			}

			index++;
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(10, 26, 89, 22);
		frame.getContentPane().add(lblName);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSurname.setBounds(10, 54, 102, 22);
		frame.getContentPane().add(lblSurname);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(20, 84, 79, 22);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(10, 115, 102, 22);
		frame.getContentPane().add(lblPassword);

		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(17, 148, 82, 22);
		frame.getContentPane().add(lblEmail);

		JLabel lblFine = new JLabel("Fine:");
		lblFine.setHorizontalAlignment(SwingConstants.CENTER);
		lblFine.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFine.setBounds(257, 54, 62, 22);
		frame.getContentPane().add(lblFine);

		txtName = new JTextField();
		txtName.setBounds(144, 28, 110, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(Login.record.getMember().get(index).getName());

		txtSurname = new JTextField();
		txtSurname.setBounds(144, 56, 110, 20);
		frame.getContentPane().add(txtSurname);
		txtSurname.setColumns(10);
		txtSurname.setText(Login.record.getMember().get(index).getSurname());

		txtusername = new JTextField();
		txtusername.setBounds(144, 83, 110, 23);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		txtusername.setText(Login.record.getMember().get(index).getUsername());

		passwordField = new JPasswordField();
		passwordField.setBounds(144, 115, 110, 23);
		frame.getContentPane().add(passwordField);
		passwordField.setText(Login.record.getMember().get(index).getPass());

		txtemail = new JTextField();
		txtemail.setBounds(144, 149, 110, 23);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		txtemail.setText(Login.record.getMember().get(index).getEmail());

		txtfine = new JTextField();
		txtfine.setBounds(306, 56, 86, 20);
		frame.getContentPane().add(txtfine);
		txtfine.setColumns(10);
		txtfine.setText(String.valueOf(Login.record.getMember().get(index).getFine()));

		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(306, 202, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(type==true){
					frame.setVisible(false);
					frame.dispose();
					Librarian.main(null);
				}	
				else{
					frame.setVisible(false);
					frame.dispose();
					User.main();
				}
					
			}
			
		});

		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(31, 203, 89, 23);
		frame.getContentPane().add(btnEdit);
		btnEdit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtusername.getText().isEmpty()
						|| passwordField.getText().isEmpty() || txtemail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter necessary field!", " ",
							JOptionPane.WARNING_MESSAGE);
				}

				else {
					btnEdit.setVisible(true);
					editMember(txtName.getText(), txtSurname.getText(),
							txtemail.getText(), txtusername.getText(), passwordField.getText());
					JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					frame.dispose();
					Account.main(id,type);
				
				}
			}
			
		});

		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(144, 203, 89, 23);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDelete.setVisible(true);
				Login.record.getMember().remove(index);
				JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				frame.dispose();
				Librarian.main(null);

			}

		});

		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(333, 82, 62, 22);
		frame.getContentPane().add(btnPay);
	}
	
	void editMember(String name, String surname, String email, String user_name, String pass) {
		Login.record.getMember().get(index).setName(name);
		Login.record.getMember().get(index).setSurname(surname);
		Login.record.getMember().get(index).setEmail(email);
		Login.record.getMember().get(index).setUsername(user_name);
		Login.record.getMember().get(index).setPass(pass);
	}
	
}
