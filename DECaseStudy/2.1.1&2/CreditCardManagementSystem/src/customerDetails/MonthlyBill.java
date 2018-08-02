package customerDetails;

import userInputGroup.UserInput;

public class MonthlyBill {
	public String monthlyBillZip(String typeId) {
		UserInput userInput = new UserInput();
		
		if ( 0 == typeId.compareToIgnoreCase("ssn")) {
			
			userInput.setSSN();
			
			userInput.setMonth();
			
			userInput.setYear();
			
			System.out.println("The customer bill for the Month " + userInput.getMonth());
			
			return "select round(sum(cdw_sapp_creditcard.TRANSACTION_VALUE),2) " + 
			"from cdw_sapp_creditcard " + 
			"join cdw_sapp_customer on cdw_sapp_creditcard.CUST_SSN = cdw_sapp_customer.SSN " + 
			"where cdw_sapp_customer.SSN = " + userInput.getSSN() + " and cdw_sapp_creditcard.MONTH = " + userInput.getMonth() +" and cdw_sapp_creditcard.YEAR = " + userInput.getYear(); 
			}
		else {
		
			// reused typeId as CCN
			
			userInput.setCCN();
			
			userInput.setMonth();

			userInput.setYear();
			
			System.out.println("The customer bill for the Month " + userInput.getMonth());
			
			return "select round(sum(cdw_sapp_creditcard.TRANSACTION_VALUE),2) " + 
			"from cdw_sapp_creditcard " + 
			"join cdw_sapp_customer on cdw_sapp_creditcard.CREDIT_CARD_NO = cdw_sapp_customer.CREDIT_CARD_NO " + 
			"where cdw_sapp_customer.CREDIT_CARD_NO = " + userInput.getCCN() + " and cdw_sapp_creditcard.MONTH = " + userInput.getMonth() +" and cdw_sapp_creditcard.YEAR = " + userInput.getYear();
		}
	}
}