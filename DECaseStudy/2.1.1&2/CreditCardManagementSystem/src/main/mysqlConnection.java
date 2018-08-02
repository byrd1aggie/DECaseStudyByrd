package main;

import java.sql.*;


// connection to mySql
public class mysqlConnection {
	
	// mySqlConnection return all columns
	public void mySqlConnection(String stmt, int sqlType) throws Exception {
				
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		//SQL sever
		String connection = "jdbc:mysql://localhost:3306/cdw_saap";
		
		//SQL username
		String user = "root";
		
		//SQL password
		String pass = "mysql";
					
		try {
		
			//connects using address username and password
			myConn = DriverManager.getConnection(connection, user, pass);
			
			//Excute a query
			myStmt = myConn.createStatement();
			
			if (0 == sqlType ) {
			//creates query stmt is mySqlConnection input
			myStmt.executeUpdate(stmt);
			}
			else {
				
			myRs = myStmt.executeQuery(stmt);
			ResultSetMetaData rsMetaData = myRs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();
			
			

			//print out all columns from query is mySqlConnection input 
			while (myRs.next()) {
				for (int i = 1; i < numberOfColumns + 1; i++) {
				System.out.print(myRs.getString(i) + " ");
				}
				System.out.println();
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
	}
}
