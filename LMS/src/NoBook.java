import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class NoBook {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoBook window = new NoBook();
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
	public NoBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 249, 166);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblThereIsNo = new JLabel("No books found in this name");
		lblThereIsNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblThereIsNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThereIsNo.setBounds(10, 39, 213, 36);
		frame.getContentPane().add(lblThereIsNo);
	}

}
