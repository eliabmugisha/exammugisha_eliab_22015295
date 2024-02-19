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

import Entities.user;


public class userForm implements ActionListener{
	JFrame frame;
	JLabel user_id_lb=new JLabel("user_id");
	JLabel username_lb=new JLabel("username");
	JLabel password_lb=new JLabel("password");
	JLabel telephone_lb=new JLabel(" telephone");
	
	
	JTextField user_id_txf=new JTextField();
	JTextField username_txf=new JTextField();
    JTextField password_txf=new JTextField();
    JTextField telephone_txf= new JTextField();
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();


    public  userForm() {
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
        frame.setTitle("User  Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	user_id_lb.setBounds(10, 10, 200, 30);
    	username_lb.setBounds(10, 50, 200, 30);
    	password_lb.setBounds(10, 90, 200, 30);
    	telephone_lb.setBounds(10, 130, 200, 30);
    	
    	
    	
    	user_id_txf.setBounds(200, 10, 250, 30);
    	username_txf.setBounds(200, 50, 250, 30);
    	password_txf.setBounds(200, 90, 250, 30);
    	telephone_txf.setBounds(200, 130, 250, 30);
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(480, 10, 750, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	user_id_lb.setFont(fontLabel);
   	username_lb.setFont(fontLabel);
   	password_lb.setFont(fontLabel);
   	telephone_lb.setFont(fontLabel);
   	   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	user_id_txf.setFont(fontText);
   	username_txf.setFont(fontText);
   	password_txf.setFont(fontText);
   	telephone_txf.setFont(fontText);
	
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(user_id_lb);
        frame.add(username_lb);
        frame.add(password_lb);
        frame.add(telephone_lb);	
      
       
    	
        frame.add(user_id_txf);
        frame.add(username_txf);
        frame.add(password_txf);
        frame.add(telephone_txf);
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	user st=new user();
    if (e.getSource() == insert_btn) {
        st.setUsername(username_txf.getText());
        st.setPassword(password_txf.getText());
        st.setTelephone(telephone_txf.getText());
        st.insertData();
    }
    
    
    
 
    
    
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("");
        model.addColumn("user_id");
        model.addColumn("username");
        model.addColumn("password");
        model.addColumn("telephone");
        
       
        ResultSet resultSet =user.viewData();
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
    
    
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(user_id_txf.getText());
        
        st.setUsername(username_txf.getText());
        st.setPassword(password_txf.getText());
        st.setTelephone(telephone_txf.getText());
        
        st.update(id);
    } 
    else {
        int id = Integer.parseInt(user_id_txf.getText());
        st.delete(id);
    }
}	
	

	public static void main(String[] args) {
		 userForm userf=new userForm();

	}
	

}











