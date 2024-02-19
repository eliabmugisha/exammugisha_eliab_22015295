package Entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class flight {
private int flight_id  ;
private String flight_number  ;
private String departure_city ;
private String Arrival_city ;
private String departure_time  ;
private String arrival_time;
private  String aircraft ;


 
public flight(int flight_id,String flight_number,String departure_city,String Arrival_city,String departure_time,String arrival_time, String aircraft) {
	super();
	this.flight_id = flight_id ;
	this.flight_number= flight_number ;
	this.departure_city = departure_city;
	this.Arrival_city= Arrival_city ;
	this.departure_time= departure_time ;
	this.arrival_time= arrival_time ;
	this.aircraft= aircraft;
	
	
}
public flight() {
	// TODO Auto-generated constructor stub
}






public int getFlight_id() {
	return flight_id;
}
public void setFlight_id(int flight_id) {
	this.flight_id = flight_id;
}
public String getFlight_number() {
	return flight_number;
}
public void setFlight_number(String flight_number) {
	this.flight_number = flight_number;
}
public String getDeparture_city() {
	return departure_city;
}
public void setDeparture_city(String departure_city) {
	this.departure_city = departure_city;
}
public String getArrival_city() {
	return Arrival_city;
}
public void setArrival_city(String arrival_city) {
	Arrival_city = arrival_city;
}
public String getDeparture_time() {
	return departure_time;
}
public void setDeparture_time(String departure_time) {
	this.departure_time = departure_time;
}
public String getArrival_time() {
	return arrival_time;
}
public void setArrival_time(String arrival_time) {
	this.arrival_time = arrival_time;
}
public String getAircraft() {
	return aircraft;
}
public void setAircraft(String aircraft) {
	this.aircraft = aircraft;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/airline_online_ticket_booking";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO flight (flight_number,	departure_city,	arrival_city,	departuure_time,	arrival_time,	aircraft) VALUES (?,?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statementDeparture_city 
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.flight_number);
       preparedStatement.setString(2, this.departure_city);
       preparedStatement.setString(3, this.Arrival_city);
       preparedStatement.setString(4, this.departure_time );
       preparedStatement.setString(5, this.arrival_time);
       preparedStatement.setString(6, this.aircraft);
       
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

	        String sql = "SELECT * FROM flight";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
		
		
		
public void update(int inputFlight_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/airline_online_ticket_booking";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE flight SET  flight_number=?,	departure_city=?,	arrival_city=?,	departuure_time=?,	arrival_time=?,	aircraft=? WHERE flight_id= ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  stm.setString(1, this.getFlight_number());
          stm.setString(2, this.getDeparture_city());
          stm.setString(3, this.getArrival_city()); 
          stm.setString(4, this.getDeparture_time());// Assuming there is a column named 'id' for the WHERE clause
          stm.setString(5, this.getArrival_time()); 
          stm.setString(6, this.getAircraft());//
          
          stm.setInt(7, inputFlight_id);

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
public void delete(int inputflight_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/airline_online_ticket_booking";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM flight WHERE  flight_id = ?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputflight_id); //airline_online_ticket_booking

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

}}









