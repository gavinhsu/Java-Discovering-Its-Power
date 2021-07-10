import java.util.*;

/**
 * To analyze active accounts ,which implements class Analyzer.
 */
class ActiveAccountsAnalyzer implements Analyzer{

	    public Bank bank;
	  
	    public ActiveAccountsAnalyzer(Bank b) {
	        this.bank = b;
	    }
	    

		 //Adding balance to active account.
		@Override
	    public List<Double> requestData() {
	     	List<Double> activeAccountBalances = new ArrayList<Double>();
	     	for(BankAccount account : bank.getAccounts()) {
	     		if(!account.isClosed()) {
	     			activeAccountBalances.add(account.getBalance());
	     		}
	     	}return activeAccountBalances;
		}
		
		 //analyzing active accounts.  
		@Override
		public String analyze() {
			String result = "Analysis of active accounts \n";
			
			result += " Active accounts = " + Stats.count(this) + "\n";
			result += " Total balance = " + Math.round(Stats.sum(this)) + "\n";
			result += " Average balance = " + Math.round(Stats.average(this)) + " +/- "
			                                + Math.round(Stats.stdDeviation(this)) + "\n";
			result += " Minimum balance = " + Math.round(Stats.min(this)) + "\n";
			result += " Maximum balance = " + Math.round(Stats.max(this)) + "\n";
			
			return result;
		}	
		
		public String[] resultAnalyze() {
			String[] resultAnalyze = new String[5];
			resultAnalyze[0] = String.valueOf(Stats.count(this));
			resultAnalyze[1] = String.valueOf(Stats.sum(this));
			resultAnalyze[2] = Math.round(Stats.average(this)) + " +/- "
                    + Math.round(Stats.stdDeviation(this));
			resultAnalyze[3] = String.valueOf(Stats.min(this));
			resultAnalyze[4] = String.valueOf(Stats.max(this));
			return resultAnalyze;
		}
}
