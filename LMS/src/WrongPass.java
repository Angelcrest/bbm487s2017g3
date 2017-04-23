import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class WrongPass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WrongPass window = new WrongPass();
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
	public WrongPass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 275, 156);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWrongPassword = new JLabel("Wrong Password.");
		lblWrongPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWrongPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrongPassword.setBounds(24, 21, 198, 36);
		frame.getContentPane().add(lblWrongPassword);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.setBounds(62, 68, 121, 23);
		frame.getContentPane().add(btnTryAgain);
	}

}
