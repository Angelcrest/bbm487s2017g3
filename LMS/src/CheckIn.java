import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CheckIn {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckIn window = new CheckIn();
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
	public CheckIn() {
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
		textField.setBounds(54, 60, 314, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(55, 44, 83, 14);
		frame.getContentPane().add(lblBarcode);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(70, 121, 89, 23);
		frame.getContentPane().add(btnHome);
		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.setBounds(266, 121, 89, 23);
		frame.getContentPane().add(btnCheckIn);
	}

}
