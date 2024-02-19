package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class reservation {//reservation_id	user_idd	flight_id	passenger_name
	private int resvid;
	private String userid;
	private String flight_id;
	private String passenger_name;
	
	
	 
	public reservation(int resvid,String userid,String flight_id,String passenger_name){
		super();
		this.resvid=resvid;
		this.userid= userid;
		this.flight_id=flight_id;
		this.passenger_name=passenger_name;
		
		}


	public reservation() {
		// TODO Auto-generated constructor stub
	}


	public int getResvid() {
		return resvid;
	}


	public void setResvid(int resvid) {
		this.resvid = resvid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getFlight_id() {
		return flight_id;
	}


	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}


	public String getPassenger_name() {
		return passenger_name;
	}


	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}


	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/airline_online_ticket_booking";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO reservation(user_idd,	flight_id,	passenger_name ) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.userid);
	       preparedStatement.setString(2, this.flight_id);
	       preparedStatement.setString(3, this.passenger_name);
	     
	   	
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
			
			
	 
			public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/airline_online_ticket_booking";
		        String user = "root";
		        String password = "";

		        String sql = "SELECT * FROM reservation";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
			
			
			
	public void update(int inputpayment_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/airline_online_ticket_booking";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE reservation SET  user_idd=?,	flight_id=?,	passenger_name=? WHERE reservation_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getUserid());
	          stm.setString(2, this.getFlight_id());
	          stm.setString(3, this.getPassenger_name()); 
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputpayment_id);
	          
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputpayment_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/airline_online_ticket_booking";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM reservation WHERE  reservation_id= ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpayment_id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}


	
