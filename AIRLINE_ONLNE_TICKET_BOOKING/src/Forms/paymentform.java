package Forms;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Entities.payment;
public class paymentform implements ActionListener {
	JFrame frame;
	JLabel payment_id_lb=new JLabel("payment_id");
	JLabel reservation_id_lb=new JLabel("reservation_id");
	JLabel reservation_amount_lb=new JLabel("reservation_amount");
	JLabel payment_method_lb=new JLabel("payment_method");
	
	//payment_id	reservation_id	transaction_amount	payment_method
	
    JTextField payment_id_txf=new JTextField();
	JTextField reservation_id_txf=new JTextField();
	JTextField reservation_amount_txf=new JTextField();
	JTextField payment_method_txf=new JTextField();

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	
	 DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public paymentform() {
		createForm();
		ActionEvent();
		setLocationandSize();
		setFontforall();
		addcomponentforFrame();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("payment form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.green);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}
    private void setLocationandSize() {
    	payment_id_lb.setBounds(10, 10, 150, 30);
    	reservation_id_lb.setBounds(10, 50, 180, 30);
    	reservation_amount_lb.setBounds(10, 90, 180, 30);
    	payment_method_lb.setBounds(10, 130, 150, 30);
    	
    	payment_id_txf.setBounds(200, 10, 170, 30);
    	reservation_id_txf.setBounds(200, 50, 170, 30);
    	reservation_amount_txf.setBounds(200, 90, 170, 30);
    	payment_method_txf.setBounds(200, 130, 170, 30);
	
		
      //Buttons CRUD
		insert_btn.setBounds(10,220, 85, 30);
		Read_btn.setBounds(100,220, 85, 30);
		update_tbtn.setBounds(190,220, 85, 30);
		delete_btn.setBounds(280,220, 85, 30);
		table.setBounds(480, 10, 750, 200);

	}
	private void setFontforall() {
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		
		payment_id_lb.setFont(font);
		reservation_id_lb.setFont(font);
		reservation_amount_lb.setFont(font);
		payment_method_lb.setFont(font);

		payment_id_txf.setFont(font);
		reservation_id_txf.setFont(font);
		reservation_amount_txf.setFont(font);
		payment_method_txf.setFont(font);
	
		//payment_id	reservation_id	transaction_amount	payment_method
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(payment_id_lb);
		frame.add(reservation_id_lb);
		frame.add(reservation_amount_lb);
		frame.add(payment_method_lb);
		
	
		frame.add(payment_id_txf);
		frame.add(reservation_id_txf);
		frame.add(reservation_amount_txf);
		frame.add(payment_method_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		 frame.add(table);
	
	}
	public void actionPerformed(ActionEvent e) {
		 payment st=new  payment();
    if (e.getSource() == insert_btn) {
      
        st.setReservation_id(reservation_id_txf.getText());
        st.setTransaction_amount(reservation_amount_txf.getText());
        st.setPayment_method(payment_method_txf.getText());
       
        st.insertData();
    }
    
     else if (e.getSource() == Read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("payment_id");
        model.addColumn("reservation_id");
        model.addColumn("eservation_amount");
        model.addColumn("payment_method");
       
    	ResultSet resultSet = payment.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if (e.getSource() == update_tbtn) {
        int id = Integer.parseInt(payment_id_txf.getText());

        st.setReservation_id(reservation_id_txf.getText());
        st.setTransaction_amount(reservation_amount_txf.getText());
        st.setPayment_method(payment_method_txf.getText());
       ;
        
        st.update(id);
        
    } 
    else {
        int id = Integer.parseInt(payment_id_txf.getText());
        st.delete(id);
    }
}	
	public static void main(String[] args) {
		paymentform pgt=new paymentform();

	}
}


