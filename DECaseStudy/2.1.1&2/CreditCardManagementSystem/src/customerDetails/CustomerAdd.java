package customerDetails;

import java.util.Scanner;

import main.mysqlConnection;
import userInputGroup.UserInput;

public class CustomerAdd {
	
	mysqlConnection sql = new mysqlConnection();
	UserInput userInput = new UserInput();
	int columnNumberArray [] = new int[10];
	String sqlStatement, userValue, customerID;
	String sqlStatement1 = "insert cdw_sapp_customer (";
	String sqlStatement2 = "values ( ";
	
	public void customerAdd() throws Exception {
		
		Scanner s = new Scanner(System.in);
	
			//Array for adding a entry to Customer Table
			String columnITechNameArray [] = {"FIRST_NAME","MIDDLE_NAME","LAST_NAME","SSN","CREDIT_CARD_NO", "APT_NO", "STREET_NAME","CUST_CITY","CUST_STATE","CUST_COUNTRY","CUST_ZIP","CUST_PHONE","CUST_EMAIL"};
			
			//Array for asking the user what the value for the new entry. [] = 10
			String columnNameArray [] = {"First Name","Middle Name","Last Name", "SSN", "CCN", "APT NO", "Street Name (ST)", "City", "State", "Country", "Zip", "Phone Number", "Email"};
					

			for (int i=0; i < columnNameArray.length; i++) {
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
					userInput.setSSN();
					userValue = userInput.getSSN();
					break;
					}
					
					case 4:{
					userInput.setCCN();
					userValue = userInput.getCCN();
					break;
					}
					
					case 5:{
					userInput.setAptNo();
					userValue = userInput.getAptNo();
					break;
					}
					
					case 6:{
					userInput.setStreetName();
					userValue = userInput.getStreetName();
						break;
					}
					
					case 7:{
					userInput.setCity();
					userValue = userInput.getCity();
						break;
					}
					
					case 8:{
					userInput.setState();
					userValue = userInput.getState();
						break;
					}
					
					case 9:{
					userInput.setCountry();
					userValue = userInput.getCountry();
						break;
					}
					
					case 10:{
					userInput.setZip();
					userValue = userInput.getZip();
						break;
					}
					
					case 11:{
					userInput.setphoneNumber();
					userValue = userInput.getphoneNumber();
						break;
					}
					
					case 12:{
					userInput.setEmail();
					userValue = userInput.getEmail();
						break;
					}
					
					default:{
						userValue = "";
						break;
						}
					}
					
					//formating for either adding a ',' or ')' at the end of the statement
					if (i == 12) {
						sqlStatement1 += "cdw_sapp_customer." + columnITechNameArray[i] +")";
						sqlStatement2 += "\'" + userValue + "\')";
						}
					else {
						sqlStatement1 += "cdw_sapp_customer." + columnITechNameArray[i] + ", ";
						sqlStatement2 += "\'" + userValue + "\', ";
						} 
				
				userValue = "";
				}
			
			sqlStatement = sqlStatement1 + " " + sqlStatement2;
			System.out.println(sqlStatement);
			sql.mySqlConnection(sqlStatement,0);
		s.close();
		}
}
