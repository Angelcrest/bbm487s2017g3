import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Logout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logout window = new Logout();
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
	public Logout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 257, 179);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouAreGoing = new JLabel("Do you agree to sign out?");
		lblYouAreGoing.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYouAreGoing.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouAreGoing.setBounds(10, 24, 209, 35);
		frame.getContentPane().add(lblYouAreGoing);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setBounds(10, 78, 89, 23);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(119, 78, 89, 23);
		frame.getContentPane().add(btnNo);
	}

}
