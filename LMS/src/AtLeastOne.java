import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AtLeastOne {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtLeastOne window = new AtLeastOne();
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
	public AtLeastOne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 264, 177);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAtLeastOne = new JLabel("At least one field must have filled");
		lblAtLeastOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtLeastOne.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAtLeastOne.setBounds(10, 41, 228, 37);
		frame.getContentPane().add(lblAtLeastOne);
	}

}
