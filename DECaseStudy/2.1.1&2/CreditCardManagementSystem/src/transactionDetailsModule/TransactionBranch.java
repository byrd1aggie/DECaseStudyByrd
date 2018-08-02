package transactionDetailsModule;

public class TransactionBranch {
	public String selectBranchState(String BState){
		System.out.println("Branches and Transaction Id for Branchs in " + BState);
		return "select cdw_sapp_creditcard.TRANSACTION_ID, cdw_sapp_creditcard.TRANSACTION_VALUE, cdw_sapp_branch.BRANCH_NAME "
				+"from cdw_sapp_creditcard "
				+"join cdw_sapp_branch on cdw_sapp_creditcard.BRANCH_CODE = cdw_sapp_branch.BRANCH_CODE "
				+"where cdw_sapp_branch.BRANCH_STATE = " + "\"" + BState + "\"";
	}
}
