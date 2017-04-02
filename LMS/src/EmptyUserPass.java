import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class EmptyUserPass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmptyUserPass window = new EmptyUserPass();
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
	public EmptyUserPass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 286, 187);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterYourUsername = new JLabel("Enter your username and password");
		lblEnterYourUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterYourUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourUsername.setBounds(10, 11, 250, 50);
		frame.getContentPane().add(lblEnterYourUsername);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.setBounds(69, 81, 126, 23);
		frame.getContentPane().add(btnTryAgain);
	}

}
