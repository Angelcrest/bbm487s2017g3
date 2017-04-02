import java.awt.*;
import javax.swing.*;

public class Account {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
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
	public Account() {
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
		
		Label label = new Label("Name:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(30, 26, 90, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Surname:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(30, 54, 82, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Password:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(30, 80, 82, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("Username:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(30, 108, 82, 22);
		frame.getContentPane().add(label_3);
		
		Label label_4 = new Label("e-mail:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(30, 133, 62, 22);
		frame.getContentPane().add(label_4);
		
		TextField textField = new TextField();
		textField.setBounds(133, 26, 102, 22);
		frame.getContentPane().add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(133, 54, 102, 22);
		frame.getContentPane().add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(133, 80, 102, 22);
		frame.getContentPane().add(textField_2);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(133, 108, 102, 22);
		frame.getContentPane().add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(133, 136, 130, 22);
		frame.getContentPane().add(textField_4);
		
		Label label_5 = new Label("Fine:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(261, 54, 62, 22);
		frame.getContentPane().add(label_5);
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(313, 54, 82, 22);
		frame.getContentPane().add(textField_5);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(306, 202, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(31, 203, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(144, 203, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(333, 82, 62, 22);
		frame.getContentPane().add(btnPay);
	}
}
