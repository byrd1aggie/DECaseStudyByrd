package transactionDetailsModule; 
import main.mysqlConnection;

public class TransactionCustomersZip extends mysqlConnection {
	public String selectCustomerZip(String zip, String month, String year){
				System.out.println("Transaction Id for ZIP:" + zip +" MONTH:" + month + " YEAR:" + year);
		return  ("select cdw_sapp_creditcard.TRANSACTION_ID" 
			+ " from cdw_sapp_creditcard"
			+ " join cdw_sapp_customer on cdw_sapp_creditcard.CREDIT_CARD_NO = cdw_sapp_customer.CREDIT_CARD_NO "
			+ " where cdw_sapp_creditcard.year= " + year 
			+ " and cdw_sapp_creditcard.month = " + month + " and cdw_sapp_customer.CUST_ZIP = " + zip 
			+ " order by cdw_sapp_creditcard.day");
	}
}