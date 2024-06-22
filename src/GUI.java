import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class GUI {
    private RequestHandler requestHandler;
    private JFrame frame;
    private JTextField textName;
    private JTextField textAmount;
    private JTextField textPrice;
    private JTextField textCategory;
    private JTextField textNote;
    private JTable table_1;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI window = new GUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GUI() {
        requestHandler = new RequestHandler();
        initialize();
        setupTable(); 
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(140, 20, 1032, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        setupLabels();  
        setupTextFields(); 
        setupButtons();  
        setupTableComponent();  
    }

    private void setupTableComponent() {
        table_1 = new JTable();
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(222, 41, 759, 465);
        frame.getContentPane().add(scrollPane); 
    }




    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        model.setRowCount(0); 
        for (String[] record : requestHandler.getCurrentData()) {
            model.addRow(record);
        }
    }

    private void setupLabels() {
        lblNewLabel = new JLabel("Name");
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
    }

    private void setupTextFields() {
        textName = new JTextField();
        textName.setBounds(10, 82, 185, 40);
        frame.getContentPane().add(textName);
        textName.setColumns(10);

        textAmount = new JTextField();
        textAmount.setColumns(10);
        textAmount.setBounds(10, 203, 185, 40);
        frame.getContentPane().add(textAmount);

        textPrice = new JTextField();
        textPrice.setColumns(10);
        textPrice.setBounds(10, 305, 185, 40);
        frame.getContentPane().add(textPrice);

        textCategory = new JTextField();
        textCategory.setColumns(10);
        textCategory.setBounds(10, 401, 185, 40);
        frame.getContentPane().add(textCategory);

        textNote = new JTextField();
        textNote.setColumns(10);
        textNote.setBounds(10, 510, 185, 100);
        frame.getContentPane().add(textNote);
    }

    private void setupButtons() {
        JButton add = new JButton("Hinzufügen");
        add.addActionListener(e -> {
        	
        	// Ruft die Methode add auf dem Objekt requestHandler auf.
        	// Übergibt ein String[] mit allen Textfield Values. 
            requestHandler.add(getArray());
            refreshTable();
            reset();
        });
        add.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add.setBounds(512, 550, 200, 60);
        frame.getContentPane().add(add);

        JButton update = new JButton("Ändern");
        update.addActionListener(e -> {
            int selectedRow = table_1.getSelectedRow();
            if (selectedRow != -1) {
                requestHandler.update(selectedRow, getArray());
                refreshTable();
                reset();
            }
        });
        update.setFont(new Font("Tahoma", Font.PLAIN, 20));
        update.setBounds(222, 550, 200, 60);
        frame.getContentPane().add(update);

        JButton delete = new JButton("Löschen");
        delete.addActionListener(e -> {
            int selectedRow = table_1.getSelectedRow();
            if (selectedRow != -1) {
                requestHandler.delete(selectedRow);
                refreshTable();
            }
        });
        delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
        delete.setBounds(781, 550, 200, 60);
        frame.getContentPane().add(delete);
    }

    private String[] getArray() {
    	String[] a = { textName.getText(), textAmount.getText(), textPrice.getText(), textCategory.getText(), textNote.getText() };
    	return a;
    }

    private void reset() {
        textName.setText("");
        textAmount.setText("");
        textPrice.setText("");
        textCategory.setText("");
        textNote.setText("");
    }
    
    private void setupTable() {
        String[] columnNames = {lblNewLabel.getText() ,"Menge","Preis","Kategorie","Notiz"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table_1.setModel(model);
        refreshTable();
    }
}
