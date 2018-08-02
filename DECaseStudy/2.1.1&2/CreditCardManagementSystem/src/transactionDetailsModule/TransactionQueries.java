package transactionDetailsModule;

import main.MySqlConnection;
import userInputGroup.UserInput;

public class TransactionQueries{

	public void transaction() throws Exception {
		MySqlConnection sql = new MySqlConnection();
		UserInput userInput = new UserInput();
				
		// User choice filter on this line
		userInput.setTransactionFilterType();
		
		switch (userInput.getTransactionFilterType()) {
		
		//User wants to filter by zip
		case "zip" :{
			TransactionCustomersZip zipTable = new TransactionCustomersZip();
			userInput.setZip();
			userInput.setMonth();
			userInput.setYear();
			
			// Sql queries of zip
			sql.mySqlConnection(zipTable.selectCustomerZip(userInput.getZip(), userInput.getMonth(), userInput.getYear()),1);
			break;
			}
		
		
		case "type" :{
			
			// get type to filter
			userInput.setTransactionType();
			
			//Sql queries of type
			TotalTransactionType tType = new TotalTransactionType ();
			sql.mySqlConnection(tType.selectTransactionsType(userInput.getTransactionType()),1);
			break;
			}
		
		// Filter by branch
		case "branch" :{
			
			//get state to filter
			userInput.setState();
			
			//Sql queries of State
			TransactionBranch branchState = new TransactionBranch();
			sql.mySqlConnection(branchState.selectBranchState(userInput.getState()),1);
			break;
			}
		}
	}
}
