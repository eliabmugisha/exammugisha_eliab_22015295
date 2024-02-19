package Entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class payment {

	private int payment_id;
	private String reservation_id;
	private String transaction_amount;
	private String payment_method;
	
	
	 
	public payment(int payment_id,String  reservation_id,String transaction_amount,String payment_method){
		super();
		this.payment_id=payment_id;
		this. reservation_id= reservation_id;
		this.transaction_amount=transaction_amount;
		this.payment_method=payment_method;
		
		}


	public payment() {
		// TODO Auto-generated constructor stub
	}

	public int getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	public String getReservation_id() {
		return reservation_id;
	}


	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}


	public String getTransaction_amount() {
		return transaction_amount;
	}


	public void setTransaction_amount(String transaction_amount) {
		this.transaction_amount = transaction_amount;
	}


	public String getPayment_method() {
		return payment_method;
	}


	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}


	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/airline_online_ticket_booking";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO payment(reservation_id, transaction_amount , payment_method ) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.reservation_id);
	       preparedStatement.setString(2, this.transaction_amount);
	       preparedStatement.setString(3, this.payment_method);
	       
	        
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

		        String sql = "SELECT * FROM payment";

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
	    String sql = "UPDATE payment SET  reservation_id= ?, transaction_amount= ?,  payment_method= ? WHERE payment_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getReservation_id());
	          stm.setString(2, this.getTransaction_amount());
	          stm.setString(3, this.getPayment_method()); 
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
	    String sql = "DELETE FROM payment WHERE  payment_id = ?";

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


