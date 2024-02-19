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

import Entities.airport;

public class airportform implements ActionListener{
	JFrame frame;
	JLabel airport_id_lb=new JLabel("aiirport_id ");
	JLabel airport_code_lb=new JLabel("airport-code");
	JLabel country_lb=new JLabel("country");
	
	
	
	
	JTextField airport_id_txf=new JTextField();
    JTextField airport_code_txf=new JTextField();
    JTextField country_txf= new JTextField();
    
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  airportform() {
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
        frame.setTitle("AIRPORT Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	airport_id_lb.setBounds(10, 10, 200, 30);
    	airport_code_lb.setBounds(10, 50, 200, 30);
    	country_lb.setBounds(10, 90, 200, 30);
    	
    	
    	
    	airport_id_txf.setBounds(200, 10, 250, 30);
    	airport_code_txf.setBounds(200, 50, 250, 30);
    	country_txf.setBounds(200, 90, 250, 30);
    	
    	
    	 
    	 
    	 insert_btn.setBounds(10, 210, 85, 30);
         read_btn.setBounds(100,  210, 85, 30);
         update_btn.setBounds(190,  210, 85, 30);
         delete_btn.setBounds(280,  210, 85, 30);
         table.setBounds(480, 10, 750, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	airport_id_lb.setFont(fontLabel);
	airport_code_lb.setFont(fontLabel);
	country_lb.setFont(fontLabel);
   	
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	airport_id_txf.setFont(fontText);
   	airport_code_txf.setFont(fontText);
   	country_txf.setFont(fontText);
  
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(airport_id_lb);
        frame.add(airport_code_lb);
        frame.add(country_lb);
       	
      
       
    	
        
        frame.add(airport_id_txf);
        frame.add(airport_code_txf);
        frame.add(country_txf);
        
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	airport ap=new airport();
    if (e.getSource() == insert_btn) {
        ap.setAirport_code(airport_code_txf.getText());
        ap.setCountry(country_txf.getText());
       
        ap.insertData();
    }
    
      
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("airport_id");
        model.addColumn("airport_code");
        model.addColumn("country");
        
        ResultSet resultSet =airport.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(airport_id_txf.getText());
        
        ap.setAirport_code(airport_code_txf.getText());
        ap.setCountry(country_txf.getText());
        ap.update(id);
    } 
    else {
        int id = Integer.parseInt(airport_id_txf.getText());
        ap.delete(id);
    }
}	
	

	public static void main(String[] args) {
		airportform apf=new airportform();
		System.out.println(apf);

	}
	

}
	


