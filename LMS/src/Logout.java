import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class Logout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String n) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logout window = new Logout(n);
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
	public Logout(String n) {
		initialize(n);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String n) {
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
		btnYes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				if(n.equals("Librarian")){
					Librarian.frame.setVisible(false);
					Librarian.frame.dispose();
				}else if(n.equals("Admin")){
					Admin.frame.setVisible(false);
					Admin.frame.dispose();
				}else if(n.equals("User")){
					User.frame.setVisible(false);
					User.frame.dispose();
				}
				
				Login.main(null);
			}
		});

		JButton btnNo = new JButton("No");
		btnNo.setBounds(119, 78, 89, 23);
		frame.getContentPane().add(btnNo);
		btnNo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();

			}
		});
	}

}
