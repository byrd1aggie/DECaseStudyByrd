package customerDetails;

import userInputGroup.UserInput;

public class allColumnCustomers {
	public String allCustomers(String typeId) {
		UserInput userInput = new UserInput();
		
		// Search by SSN
		if ( 0 == typeId.compareToIgnoreCase("ssn")) {
			
			userInput.setSSN();
		
			return "select * from cdw_sapp_customer"
				+" where  cdw_sapp_customer.SSN= " + userInput.getSSN();}
		
		// Search by CCN
		else{
			userInput.setCCN();
		
			return "select * from cdw_sapp_customer"
					+" where cdw_sapp_customer.CREDIT_CARD_NO = " + userInput.getCCN();
		}	
	}
}
