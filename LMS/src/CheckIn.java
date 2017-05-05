import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CheckIn{

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckIn window = new CheckIn(id);
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
	public CheckIn(int id) {
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(67, 66, 279, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnC = new JButton("Check Out");
		btnC.setBounds(242, 122, 104, 23);
		frame.getContentPane().add(btnC);
		btnC.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int index=0;
				boolean found = false;
				while(index < Record.getBooks().size()){
					if(Record.getBooks().get(index).getBarcode().equals(textField.getText())){
						if(Record.getBooks().get(index).isBorrowed() == false){
							JOptionPane.showMessageDialog(null, "This book is not borrowed!", " ",
									JOptionPane.WARNING_MESSAGE);
						}else{
							Record.getBooks().get(index).setBorrowed(false);
							JOptionPane.showMessageDialog(null, "Successful", " ", JOptionPane.INFORMATION_MESSAGE);
						}
						found=true;
						break;
					}
					index++;
				}
				if(found==false){
					JOptionPane.showMessageDialog(null, "No books found in this barcode!", " ",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(67, 39, 71, 23);
		frame.getContentPane().add(lblBarcode);
		
		JButton btnCancel = new JButton("Home");
		btnCancel.setBounds(67, 122, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				Member.main(id);
			}
			
		});
	}

}
