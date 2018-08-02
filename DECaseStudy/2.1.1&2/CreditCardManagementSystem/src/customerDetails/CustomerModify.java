package customerDetails;

import java.util.Scanner;

import main.mysqlConnection;
import userInputGroup.UserInput;

public class CustomerModify{
	mysqlConnection sql = new mysqlConnection();
	UserInput userInput = new UserInput();
	int columnNumberArray [] = new int[11];
	String sqlStatement, userValue, customerID;
	
	public void customerModify() throws Exception {
	
		Scanner s = new Scanner(System.in);
		
		//Array for editing a entry to Customer Table
		String columnMTechNameArray [] = {"FIRST_NAME","MIDDLE_NAME","LAST_NAME","APT_NO","STREET_NAME","CUST_CITY","CUST_STATE","CUST_COUNTRY","CUST_ZIP","CUST_PHONE","CUST_EMAIL"};
		
		//Array for asking the user what column they would like to change. [] = 10
		String columnNameArray [] = {"First Name","Middle Name","Last Name","Apt No","Street Name (ST)","City","State","Country","Zip","Phone Number","Email"};
		
		userInput.setTypeID();
		
		if (0 == userInput.getTypeId().compareToIgnoreCase("SSN")) {
			userInput.setSSN();
			customerID = userInput.getSSN();
		}
		
		else {
		userInput.setCCN();
		customerID = userInput.getCCN();
		}
		
		for (int i=0; i < columnNameArray.length; i++) {
			System.out.println("Would you like to modify " + columnNameArray[i] +"?"
					+ " Y for YES or N for NO");
			String answer = s.next();
			if(0 == answer.compareToIgnoreCase("y")) {
					columnNumberArray[i] = i;
					}
			else {
				columnNumberArray[i] = -1;
			}
				}
		
		for (int i=0; i <= columnNumberArray.length-1; i++) {
			if (columnNumberArray[i] > -1) {
			
				switch (i) {
				case 0:{
				userInput.setFirstName();
				userValue = userInput.getFirstName();
				break;
				}
				
				case 1:{
				userInput.setMiddleName();
				userValue = userInput.getMiddleName();
					break;
				}
				
				case 2:{
				userInput.setLastName();
				userValue = userInput.getLastName();
					break;
				}
				case 3:{
				userInput.setAptNo();
				userValue = userInput.getAptNo();
				break;
				}
				
				case 4:{
				userInput.setStreetName();
				userValue = userInput.getStreetName();
					break;
				}
				
				case 5:{
				userInput.setCity();
				userValue = userInput.getCity();
					break;
				}
				
				case 6:{
				userInput.setState();
				userValue = userInput.getState();
					break;
				}
				
				case 7:{
				userInput.setCountry();
				userValue = userInput.getCountry();
					break;
				}
				
				case 8:{
				userInput.setZip();
				userValue = userInput.getZip();
					break;
				}
				
				case 9:{
				userInput.setphoneNumber();
				userValue = userInput.getphoneNumber();
					break;
				}
				
				case 10:{
				userInput.setEmail();
				userValue = userInput.getEmail();
					break;
				}
				
				default:{
					userValue = "";
					break;
					}
				}
				if (0 == userInput.getTypeId().compareToIgnoreCase("SSN")) {
					sqlStatement = "update cdw_sapp_customer "
									+ "set cdw_sapp_customer." + columnMTechNameArray[i] + " = \"" + userValue
									+ "\" where cdw_sapp_customer.SSN = " + userInput.getSSN() + ";";
				}
				
				else {
					sqlStatement = "update cdw_sapp_customer "
									+ "set cdw_sapp_customer." + columnMTechNameArray[i] + " = \"" + userValue
									+ "\" where cdw_sapp_customer.CREDIT_CARD_NO = "  + userInput.getCCN()+";";
				System.out.println(sqlStatement);
				}
			
			
			sql.mySqlConnection(sqlStatement, 0);
			userValue = "";
			}
		}
	s.close();	
	}
}
