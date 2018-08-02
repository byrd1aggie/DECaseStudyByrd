package customerDetails;

import userInputGroup.UserInput;

public class AllColumnCustomers {
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
	//When we already have SSN or CCN for checking add and modify 
	public String allCustomers(String typeId, String customerID) {

		
		// Search by SSN
				if ( 0 == typeId.compareToIgnoreCase("ssn")) {
				
					return "select * from cdw_sapp_customer"
						+" where  cdw_sapp_customer.SSN= " + customerID;}
				
				// Search by CCN
				else{
				
					return "select * from cdw_sapp_customer"
							+" where cdw_sapp_customer.CREDIT_CARD_NO = " + customerID;
				}	
	}
}
