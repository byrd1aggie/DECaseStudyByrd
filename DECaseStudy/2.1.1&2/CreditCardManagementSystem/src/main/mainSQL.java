package main;

import customerDetails.CustomerAdd;
import customerDetails.CustomerModify;
import customerDetails.CustomerQueries;
import transactionDetailsModule.TransactionQueries;
import userInputGroup.UserInput;


public class mainSQL {

	public static void main(String[] args) throws Exception {
		
		UserInput userInput = new UserInput ();
		TransactionQueries transcation = new TransactionQueries ();
		CustomerQueries customerQuery = new CustomerQueries (); 
		CustomerModify customerModify = new CustomerModify();
		CustomerAdd customerAdd = new CustomerAdd();
		
		userInput.setUserNeed();
		
		switch(userInput.getUserNeed()) {
		case "modify":{
			customerModify.customerModify();
			break;
		}
		case "add":{
			customerAdd.customerAdd();
			break;
		}
		
		case "search" :{
		userInput.setGroupFilter();
		
			switch (userInput.getGroupFilter()) {
		
			case "transaction" :{
				transcation.transaction();
				break;
			}
			case "customer" :{
				customerQuery.customerSqlQueries();			
				break;
						}
					}
			}
		}
	}
}
