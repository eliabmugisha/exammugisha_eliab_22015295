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

import Entities.reservation;

public class reservationform implements ActionListener {
	
	JFrame frame;
	JLabel reservation_id_lb=new JLabel("reservation_id");
	JLabel user_id_lb=new JLabel("user_id");
	JLabel flight_id_lb=new JLabel("flight_id");
	JLabel passenger_name_lb=new JLabel("passenger_name");
	

	JTextField reservation_id_txf=new JTextField();
	JTextField user_id_txf=new JTextField();
	JTextField flight_id_txf=new JTextField();
	JTextField passenger_name_txf=new JTextField();
	
 
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
public reservationform() {
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
	frame.setTitle("Reservation Form");
	frame.setBounds(0, 0, w/2, h/2);
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.yellow);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(true);
	
}


private void setLocationandSize() {
	reservation_id_lb.setBounds(10, 10, 150, 30);
	user_id_lb.setBounds(10, 50, 100, 30);
	flight_id_lb.setBounds(10, 90, 100, 30);
	passenger_name_lb.setBounds(10, 130, 150, 30);
	
	reservation_id_txf.setBounds(180, 10, 130, 30);
	user_id_txf.setBounds(180, 50, 130, 30);
	flight_id_txf.setBounds(180, 90, 130, 30);
	passenger_name_txf.setBounds(180, 130, 130, 30);
	
  //Buttons CRUD
	insert_btn.setBounds(10,250, 85, 30);
	Read_btn.setBounds(100,250, 85, 30);
	update_tbtn.setBounds(190,250, 85, 30);
	delete_btn.setBounds(280,250, 85, 30);
	table.setBounds(480, 10, 750, 200);

}
private void setFontforall() {
	Font font = new Font("Times New Roman", Font.BOLD, 20);

	reservation_id_lb.setFont(font);
	user_id_lb.setFont(font);
	flight_id_lb.setFont(font);
	passenger_name_lb.setFont(font);
	

	reservation_id_txf.setFont(font);
	user_id_txf.setFont(font);
	flight_id_txf.setFont(font);
	passenger_name_txf.setFont(font);
	
	Font fonti = new Font("Courier New", Font.ITALIC, 12);

	insert_btn.setFont(fonti);
	Read_btn.setFont(fonti);
	update_tbtn.setFont(fonti);
	delete_btn.setFont(fonti);

}
private void addcomponentforFrame() {
	frame.add(reservation_id_lb);
	frame.add(user_id_lb);
	frame.add(flight_id_lb);
	frame.add(passenger_name_lb);
	
	frame.add(reservation_id_txf);
	frame.add(user_id_txf);
	frame.add(flight_id_txf);
	frame.add(passenger_name_txf);
	
	//Buttons CRUD
	frame.add(insert_btn);
	frame.add(Read_btn);
	frame.add(update_tbtn);
	frame.add(delete_btn);
	frame.add(table);
}
public void actionPerformed(ActionEvent e) {
	reservation st=new reservation();
if (e.getSource() == insert_btn) {
    
    st.setUserid(user_id_txf.getText());
    st.setFlight_id(flight_id_txf.getText());
    st.setPassenger_name(passenger_name_txf.getText());
    st.insertData();
}
else if (e.getSource() == Read_btn) {
    model.setColumnCount(0);
    model.setRowCount(1);
    model.addColumn("");
    model.addColumn("reservation_id");
    model.addColumn("user_id");
    model.addColumn("flight");
    model.addColumn("passenger_name");
    
    ResultSet resultSet =reservation.viewData();
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
    int id = Integer.parseInt(user_id_txf.getText());
    st.setUserid(user_id_txf.getText());
    st.setFlight_id(flight_id_txf.getText());
    st.setPassenger_name(passenger_name_txf.getText());
    
    st.update(id);
} 
else {
    int id = Integer.parseInt(user_id_txf.getText());
    st.delete(id);
}
}	


	public static void main(String[] args) {
		reservationform stf=new reservationform();
	}
}




