package main;

import java.sql.*;


// connection to mySql
public class MySqlConnection {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	boolean searchIsNotNull =false;
	// mySqlConnection return all columns
	public String mySqlConnection(String stmt, int sqlType) throws Exception {
				
		myConn = null;
		myStmt = null;
		myRs = null;
		
		//SQL sever
		String connection = "jdbc:mysql://localhost:3306/cdw_sapp";
		
		//SQL username
		String user = "root";
		
		//SQL password
		String pass = "mysql";
					
		try {
		
			//connects using address username and password
			myConn = DriverManager.getConnection(connection, user, pass);
			
			//Execute a query
			myStmt = myConn.createStatement();
			
			if (0 == sqlType ) {
			//creates query stmt is mySqlConnection input
			myStmt.executeUpdate(stmt);
			}
			
			else if(1 ==sqlType) {
				myRs = myStmt.executeQuery(stmt);
				ResultSetMetaData rsMetaData = myRs.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();
			//print out all columns from query is mySqlConnection input 
			while (myRs.next()) {	
				for (int i = 1; i < numberOfColumns + 1; i++) {
				System.out.print(myRs.getString(i) + " ");
				}
				System.out.println();
				searchIsNotNull = true;
					}
			if (!searchIsNotNull) {
				System.out.println("There are no matches for your search");
			 	}
			 }
			
			//Check if database had entry that was searched
			else if(2 == sqlType) {
				myRs = myStmt.executeQuery(stmt);
				while (myRs.next()) {
					searchIsNotNull = true;
					if (!searchIsNotNull) {
					break;
				 	}
				}
				if (!searchIsNotNull) {
					return "There are no matches for your search";
				 	}
				}	
			}
		catch (Exception exc) {
			exc.printStackTrace();}
		finally {
			if (myRs != null) {
				myRs.close();
				
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn!= null) {
				myConn.close();
			}
		}
		return "Thank you have a nice day";
	}
}
