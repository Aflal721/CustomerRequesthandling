package model;

import java.sql.*;
public class Customerrequest
{ //A common method to connect to the DB
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Lab", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	public String insertcustomerdetails(String customerName, String customerEmail, String customerPhone, String projecttype,String Description,String Duration) {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 // create a prepared statement
	 String query = " INSERT INTO `customerdetails`(`customerID`, `customerName`, `customerEmail`, `customerPhone`, `projecttype`, `Description`, `Duration`)" + " values (?, ?, ?, ?, ?,?,?)"; PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, customerName);
	 preparedStmt.setString(3, customerEmail);
	 preparedStmt.setString(4, customerPhone);
	 preparedStmt.setString(5, projecttype);
	 preparedStmt.setString(6, Description);
	 preparedStmt.setString(7, Duration);
	// execute the statement

	 preparedStmt.execute();
	 con.close();
	 String newCustomerrequest = readCustomerrequest();
	 output = "{\"status\":\"success\", \"data\": \"" +newCustomerrequest + "\"}";
	 }
	 catch (Exception e)
	 {
	 output = "{\"status\":\"error\", \"data\":\"Error while inserting the request.\"}";
	 System.err.println(e.getMessage());
	 } 
	 return output;
	 }
	public String readCustomerrequest()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	//Prepare the html table to be displayed
	 output = "<table border='1' align='center'><tr><th>customer Name</th>" +
			 "<th>customer Email</th>" +
			 "<th>customer Phone</th>" +
			 "<th>project type</th>"+
			 "<th>Description</th>"+
			 "<th>Duration</th>"+
			 "<th>Update</th><th>Remove</th></tr>";
	 String query = "select * from customerdetails";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	// iterate through the rows in the result set
	while (rs.next())
	{
		//`customerID`, `customerName`, `customerEmail`, `customerPhone`, `projecttype`, `Description`, `Duration`
	String customerID = Integer.toString(rs.getInt("customerID"));
	String customerName = rs.getString("customerName");
	String customerEmail = rs.getString("customerEmail");
	String customerPhone =rs.getString("customerPhone");
	String projecttype = rs.getString("projecttype");
	String Description = rs.getString("Description");
	String Duration = rs.getString("Duration");
	// Add into the html table
	output += "<tr><td>" + customerName + "</td>";
	output += "<td>" + customerEmail + "</td>";
	output += "<td>" + customerPhone + "</td>";
	output += "<td>" + projecttype + "</td>";
	output += "<td>" + Description + "</td>";
	output += "<td>" + Duration + "</td>";
	// buttons
	output += "<td><input name='btnUpdate' type='button' value='Update' "
			+ "class='btnUpdate btn btn-secondary' data-itemid='" + customerID + "'></td>"
			+ "<td><input name='btnRemove' type='button' value='Remove' "
			+ "class='btnRemove btn btn-danger' data-itemid='" + customerID + "'></td></tr>";
			 }
			 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the items.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String updatecustomerdetails(String ID,String customerName, String customerEmail, String customerPhone, String projecttype,String Description,String Duration)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE customerdetails SET customerName=?,customerEmail=?,customerPhone=?,projecttype=?,Description=?,Duration=? WHERE customerID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, customerName);
	 preparedStmt.setString(2, customerEmail);
	 preparedStmt.setString(3, customerPhone);
	 preparedStmt.setString(4, projecttype);
	 preparedStmt.setString(5, Description);
	 preparedStmt.setString(6, Duration);
	 preparedStmt.setInt(7, Integer.parseInt(ID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newCustomerrequest = readCustomerrequest();
	 output = "{\"status\":\"success\", \"data\": \"" +newCustomerrequest + "\"}";
	 }
	 catch (Exception e)
	 {
	 output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}";
	 System.err.println(e.getMessage());
	 } 
	 return output;
	 }
	public String deleteItem(String customerID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from customerdetails where customerID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(customerID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newCustomerrequest = readCustomerrequest();
	 output = "{\"status\":\"success\", \"data\": \"" +newCustomerrequest + "\"}";
	 }
	 catch (Exception e)
	 {
	 output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
	 System.err.println(e.getMessage());
	 } 
	 return output;
	 }
	} 