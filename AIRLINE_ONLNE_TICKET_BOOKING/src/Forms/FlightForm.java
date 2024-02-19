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

import Entities.flight;

public class FlightForm  implements ActionListener{
	
	JFrame frame;
	JLabel flight_id_lb=new JLabel("Flight_id");
	JLabel flight_number_lb=new JLabel("Flight_number");
	JLabel departure_city_lb=new JLabel("Departure_city");
	JLabel arrival_city_lb=new JLabel("Arrival_city");
	JLabel departure_time_lb=new JLabel("Departure_time");
	JLabel arrival_time_lb=new JLabel("Arrival_time");
	JLabel aircraft_type_lb=new JLabel("Aircraft_type");
	
	
	JTextField flight_id_txf=new JTextField();
	JTextField flight_number_txf=new JTextField();
    JTextField departure_city_txf=new JTextField();
    JTextField arrival_city_txf= new JTextField();
    JTextField departure_time_txF=new JTextField();
    JTextField arrival_time_txf= new JTextField();
    JTextField aircraft_type_txF=new JTextField();
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  FlightForm() {
    	setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }
    private void actionEvent() {
        insert_btn.addActionListener((ActionListener) this);
        read_btn.addActionListener((ActionListener) this);
        update_btn.addActionListener((ActionListener) this);
        delete_btn.addActionListener((ActionListener) this);
        }
    private void createForm() {
        frame = new JFrame();
        frame.setTitle("FLIGHT Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	flight_id_lb.setBounds(10, 10, 200, 30);
    	flight_number_lb.setBounds(10, 50, 200, 30);
    	departure_city_lb.setBounds(10, 90, 200, 30);
    	arrival_city_lb.setBounds(10, 130, 200, 30);
    	departure_time_lb.setBounds(10, 170, 200, 30);
    	arrival_time_lb.setBounds(10, 210, 200, 30);
    	aircraft_type_lb.setBounds(10, 250, 200, 30);
    	
    	
    	flight_id_txf.setBounds(200, 10, 250, 30);
    	flight_number_txf.setBounds(200, 50, 250, 30);
    	departure_city_txf.setBounds(200, 90, 250, 30);
    	arrival_city_txf.setBounds(200, 130, 250, 30);
    	departure_time_txF.setBounds(200, 170, 250, 30);
    	arrival_time_txf.setBounds(200, 210, 250, 30);
    	aircraft_type_txF.setBounds(200, 250, 250, 30);
    	
    	 
    	 
    	 insert_btn.setBounds(10, 300, 85, 30);
         read_btn.setBounds(100,  300, 85, 30);
         update_btn.setBounds(190,  300, 85, 30);
         delete_btn.setBounds(280,  300, 85, 30);
         table.setBounds(480, 10, 750, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	flight_id_lb.setFont(fontLabel);
   	flight_number_lb.setFont(fontLabel);
   	departure_city_lb.setFont(fontLabel);
   	arrival_city_lb.setFont(fontLabel);
   	departure_time_lb.setFont(fontLabel);
   	arrival_time_lb.setFont(fontLabel);
   	aircraft_type_lb.setFont(fontLabel);
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	flight_id_txf.setFont(fontText);
   	flight_number_txf.setFont(fontText);
   	departure_city_txf.setFont(fontText);
   	arrival_city_txf.setFont(fontText);
   	departure_time_txF.setFont(fontText);
   	arrival_time_txf.setFont(fontText);
   	aircraft_type_txF.setFont(fontText);
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(flight_id_lb);
        frame.add(flight_number_lb);
    	frame.add(departure_city_lb);
        frame.add(arrival_city_lb);
        frame.add(	departure_time_lb);
        frame.add(arrival_time_lb);
        frame.add(aircraft_type_lb);	
      
       
    	
        frame.add(flight_id_txf);
        frame.add(flight_number_txf);
        frame.add(departure_city_txf);
        frame.add(arrival_city_txf);
        frame.add(departure_time_txF);
        frame.add(arrival_time_txf);
        frame.add(aircraft_type_txF);
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	flight st=new flight();
    if (e.getSource() == insert_btn) {
      
        st.setFlight_number(flight_number_txf.getText());
        st.setDeparture_city(departure_city_txf.getText());
        st.setArrival_city(arrival_city_txf.getText());
        st.setDeparture_time(departure_time_txF.getText());
        st.setArrival_time(arrival_time_txf.getText()); 
        st.setAircraft(aircraft_type_txF.getText());
        st.insertData();
    }
    
    
    
 
    
    
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("flight_id");
        model.addColumn("flight_number");
        model.addColumn("departure_city");
        model.addColumn("arrival_city");
        model.addColumn("departure_time");
        model.addColumn("arrival_time");
        model.addColumn("aircraft_type");
       
        ResultSet resultSet =flight.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(flight_id_txf.getText());
        
        
        st.setFlight_number(flight_number_txf.getText());
        st.setDeparture_city(departure_city_txf.getText());
        st.setArrival_city(arrival_city_txf.getText());
        st.setFlight_number(flight_number_txf.getText());
        st.setDeparture_city(departure_city_txf.getText());
        st.setArrival_time(arrival_time_txf.getText());
        st.setAircraft(aircraft_type_txF.getText());
        
        st.update(id);
        
    } 
    else {
        int id = Integer.parseInt(flight_id_txf.getText());
        st.delete(id);
    }
}	
	

	public static void main(String[] args) {
		FlightForm Flightf=new FlightForm();

	}
	

}

























