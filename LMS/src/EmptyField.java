import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class EmptyField {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmptyField window = new EmptyField();
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
	public EmptyField() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 265, 164);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearchFieldCannot = new JLabel("Search field cannot be empty");
		lblSearchFieldCannot.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearchFieldCannot.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchFieldCannot.setBounds(10, 32, 218, 26);
		frame.getContentPane().add(lblSearchFieldCannot);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.setBounds(66, 69, 102, 26);
		frame.getContentPane().add(btnTryAgain);
	}

}
