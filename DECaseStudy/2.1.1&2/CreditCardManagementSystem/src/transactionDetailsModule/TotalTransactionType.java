package transactionDetailsModule;

public class TotalTransactionType {
	public String selectTransactionsType(String TType){
		
		System.out.println("Transaction that has the keyword " + TType);
		return ("select cdw_sapp_creditcard.TRANSACTION_ID, cdw_sapp_creditcard.TRANSACTION_VALUE " + 
				"from cdw_sapp_creditcard " + 
				"where cdw_sapp_creditcard.TRANSACTION_TYPE = "+ " \""+ TType +"\" ");
	}
}