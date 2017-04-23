import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Books {

	private JFrame frame;
	private JTextField txtSearchBook;
	private JButton btnNewButton_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Books window = new Books();
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
	public Books() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 424, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtSearchBook = new JTextField();
		txtSearchBook.setForeground(Color.LIGHT_GRAY);
		txtSearchBook.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtSearchBook.setText("Search Book");
		txtSearchBook.setBounds(44, 29, 206, 25);
		frame.getContentPane().add(txtSearchBook);
		txtSearchBook.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(260, 29, 88, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Book");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(260, 226, 116, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Home");
		btnNewButton_2.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(44, 76, 294, 115);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 294, 115);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Situation"
			}
		));
		
	}
}
