import java.awt.*;
import javax.swing.*;


public class Fine {

	private JFrame frame;
	private JButton btnNewButton;
	private JTextField txtSearchMember;
	private JTextField txtName;
	private JTextField txtTl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fine window = new Fine();
					window.frame.setVisible(true);
					window.frame.setTitle("LMS");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fine() {
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
		
		btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(313, 228, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		txtSearchMember = new JTextField();
		txtSearchMember.setForeground(Color.LIGHT_GRAY);
		txtSearchMember.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtSearchMember.setText("Search Member");
		txtSearchMember.setBounds(30, 26, 340, 23);
		frame.getContentPane().add(txtSearchMember);
		txtSearchMember.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(281, 68, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		txtName = new JTextField();
		txtName.setForeground(Color.LIGHT_GRAY);
		txtName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtName.setText("Name");
		txtName.setBounds(30, 132, 132, 23);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblFine = new JLabel("Fine:");
		lblFine.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFine.setBounds(196, 136, 59, 19);
		frame.getContentPane().add(lblFine);
		
		txtTl = new JTextField();
		txtTl.setForeground(Color.LIGHT_GRAY);
		txtTl.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtTl.setText("0.0 TL");
		txtTl.setBounds(239, 133, 86, 20);
		frame.getContentPane().add(txtTl);
		txtTl.setColumns(10);
		
		JButton btnPaid = new JButton("Paid");
		btnPaid.setBounds(256, 181, 89, 23);
		frame.getContentPane().add(btnPaid);
	}
}
