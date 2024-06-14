import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private RequestHandler requestHandler;
	private JFrame frame;
	private JTextField textName;
	private JTextField textAmount;
	private JTextField textPreis;
	private JTextField textCategory;
	private JTextField textNote ;
	private JTable table_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		requestHandler = new RequestHandler();
		initialize();
		requestHandler.getCurrentdata();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(140, 20, 1032, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 31, 140, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Menge");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 152, 140, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Preis");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 254, 140, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kategorie");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 356, 140, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Notiz");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 452, 140, 40);
		frame.getContentPane().add(lblNewLabel_4);
		
		textName = new JTextField();
		textName.setBounds(10, 82, 185, 40);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(10, 203, 185, 40);
		frame.getContentPane().add(textAmount);
		
		textPreis = new JTextField();
		textPreis.setColumns(10);
		textPreis.setBounds(10, 305, 185, 40);
		frame.getContentPane().add(textPreis);
		
		textCategory= new JTextField();
		textCategory.setColumns(10);
		textCategory.setBounds(10, 401, 185, 40);
		frame.getContentPane().add(textCategory);
		
		textNote = new JTextField();
		textNote.setColumns(10);
		textNote.setBounds(10, 510, 185, 100);
		frame.getContentPane().add(textNote);
		
		JButton update = new JButton("Ändern");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] a = { textName.getText(), textAmount.getText(), textPreis.getText(), textCategory.getText(), textNote.getText()} ;
				requestHandler.update(a);
			}
		});
		update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		update.setBounds(222, 550, 200, 60);
		frame.getContentPane().add(update);
		
		JButton add = new JButton("Hinzufügen");
		//wenn butten gedruckt wird, dann wird actionlistner getrigert( ausgelöst) 
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// hier wird array inizialisiert und mit jtextfelder gefüllt.
				String[] a = { textName.getText(), textAmount.getText(), textPreis.getText(), textCategory.getText(), textNote.getText()} ;
				// auf den requesthandler objekt wird die addfunktion aufgerufen. 
				// @Param String[]
				requestHandler.add(a);
			}
		});
		add.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add.setBounds(512, 550, 200, 60);
		frame.getContentPane().add(add);
		
		JButton delete = new JButton("Löschen");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestHandler.delete();
			}
		});
		delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		delete.setBounds(781, 550, 200, 60);
		frame.getContentPane().add(delete);
		
		table_1 = new JTable();
		table_1.setBounds(222, 41, 759, 465);
		frame.getContentPane().add(table_1);
	}
}
