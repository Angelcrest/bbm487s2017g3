import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class NoUser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoUser window = new NoUser();
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
	public NoUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 255, 131);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblThereIsNo = new JLabel("No such user record exists");
		lblThereIsNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThereIsNo.setBounds(28, 11, 189, 47);
		frame.getContentPane().add(lblThereIsNo);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(71, 58, 89, 23);
		frame.getContentPane().add(btnCancel);
	}
}
