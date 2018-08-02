package customerDetails;

import java.util.Scanner;

public class BetweenDates {
	Scanner s = new Scanner(System.in);
	
	public String betweenDate() {
	System.out.println("Inbetween what two months would you like to search?");
	System.out.println("Start Month");
	String eMonth = s.next();
	
	System.out.println("End Month");
	String lMonth = s.next();
	
	System.out.println("What Year?");
	String year = s.next();
	
	System.out.println("The transaction between " + eMonth + " and " + lMonth + "in the year " + year + "are the following:");
	return "select cdw_sapp_creditcard.TRANSACTION_ID, cdw_sapp_creditcard.TRANSACTION_TYPE, cdw_sapp_creditcard.TRANSACTION_VALUE " 
			+ "from cdw_sapp_creditcard "
			+ "join cdw_sapp_customer on cdw_sapp_creditcard.CUST_SSN = cdw_sapp_customer.SSN "
			+ "where cdw_sapp_creditcard.MONTH >= " + eMonth  
			+ " and cdw_sapp_creditcard.MONTH <= " + lMonth
			+ " and cdw_sapp_creditcard.YEAR = " + year;
	}
}
