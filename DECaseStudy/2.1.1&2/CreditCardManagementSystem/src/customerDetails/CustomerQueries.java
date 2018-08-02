package customerDetails;

import main.MySqlConnection;
import userInputGroup.UserInput;


import java.util.Scanner;

public class CustomerQueries {
	public void customerSqlQueries() throws Exception {
		MySqlConnection sql = new MySqlConnection();
		UserInput userInput = new UserInput();
		int n = 0;
		Scanner s = new Scanner(System.in);
		
		
		
		System.out.println("What filter would you like on customers?\n"
				+ "CUSTOMER: return all data for a given customer by SSN or Credit Card number\n"  
				+ "BILL: return a monthly bill for a given card\n"  
				+ "DATES: return transaction bewteen two dates.");
		
		String customerFilter = s.next().toLowerCase();
		
		
		
		
		
		//Loop until user picks a valid option for SSN or CCN
		do {
		switch(customerFilter) {
		case "customer":{
			 userInput.setTypeID();
			 
			
			AllColumnCustomers allColumn = new AllColumnCustomers(); 
			sql.mySqlConnection(allColumn.allCustomers(userInput.getTypeId()),1);
			
			
			break;
		}
		
		//If user looks up monthly bills
		case "bill":{
			 userInput.setTypeID();
						
			MonthlyBill bill = new MonthlyBill();
									
			sql.mySqlConnection(bill.monthlyBillZip(userInput.getTypeId()),1);
			
			break;
		}
		
		case "dates":{
			BetweenDates dates = new BetweenDates();
			
			//Sql queries between dates
			sql.mySqlConnection(dates.betweenDate(),1);
			
			
			break;
		}
		default:{
			
			System.out.println("Not a vaided input please choose from the following\n"
					+ "CUSTOMER: return all data for a given customers by SSN or Credit Card number\n"  
					+ "BILL: return a monthly bill for a given card\n"  
					+ "DATES: return transaction bewteen two dates\n"
					+ "EXIT: to exit");
			n=0;
			customerFilter = s.next();
			
			//Will trigger while loop if user does not type exit
			if (0 != customerFilter.compareToIgnoreCase("exit")) {
				n=0;
					}
				}
			}
		} while (n == 1 );
		s.close();
	}

}
