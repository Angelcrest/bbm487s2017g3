import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class CheckOut  {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut  window = new CheckOut (id);
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
	public CheckOut (int id) {
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
		textField.setBounds(54, 60, 314, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(55, 44, 83, 14);
		frame.getContentPane().add(lblBarcode);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(70, 121, 89, 23);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				frame.dispose();
				Member.main(id);
			}
			
		});
		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.setBounds(266, 121, 89, 23);
		frame.getContentPane().add(btnCheckIn);
		btnCheckIn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int index=0;
				boolean found = false;
				while(index < Record.getBooks().size()){
					if(Record.getBooks().get(index).getBarcode().equals(textField.getText())){
						if(Record.getBooks().get(index).isBorrowed() == true){
							JOptionPane.showMessageDialog(null, "This book is borrowed!", " ",
									JOptionPane.WARNING_MESSAGE);
						}else{
							Record.getBooks().get(index).setBorrowed(true);
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
	}

}
