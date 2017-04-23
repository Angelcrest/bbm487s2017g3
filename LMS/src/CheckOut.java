import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CheckOut {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut window = new CheckOut();
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
	public CheckOut() {
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
		
		textField = new JTextField();
		textField.setBounds(67, 66, 279, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnC = new JButton("Check Out");
		btnC.setBounds(242, 122, 104, 23);
		frame.getContentPane().add(btnC);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(67, 39, 71, 23);
		frame.getContentPane().add(lblBarcode);
		
		JButton btnCancel = new JButton("Home");
		btnCancel.setBounds(67, 122, 89, 23);
		frame.getContentPane().add(btnCancel);
	}

}
