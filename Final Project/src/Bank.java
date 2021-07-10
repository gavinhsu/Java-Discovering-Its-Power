import java.util.*;

public class Bank {
	
	private ActiveAccountsAnalyzer accAnalyzer;
	private List<BankAccount> accounts;
	
	public Bank() {
		accAnalyzer = new ActiveAccountsAnalyzer(this);
		accounts = new ArrayList<BankAccount>();
	}
	
 	 //Adding an account to your bank.
	public void addAccount(int anAccountNumber, double initialBalance) {
		BankAccount account = new BankAccount(anAccountNumber, initialBalance);
		accounts.add(account);
	}
	
 	//To find the goal account.
	private BankAccount find(int anAccountNumber) {
		for (BankAccount account : accounts) {
		    if (account.getAccountNumber() == anAccountNumber) {
		      	return account;
		    }
		}return null;
	}
	
	public void deposit(int accountNumber, double initialBalance) {
		find(accountNumber).deposit(initialBalance);
	}
	
    public void withdraw(int accountNumber, double initialBalance) {
      	find(accountNumber).withdraw(initialBalance);
	}
    
	 public void transfer(int aAccount, int bAccount, double amount) {

		 if(find(aAccount).getBalance()<amount || (!find(aAccount).getStatus().equals("OPEN")) || amount < 0) {
			 System.out.println("The transaction is not succeed");
		 }
		 else {
			 find(aAccount).withdraw(amount);
			 find(bAccount).deposit(amount);
		 }		 
	 }
    
    public double getBalance(int accountNumber) {
       return find(accountNumber).getBalance();
    }
    
	//A suspended account can be re-opened or closed. 
    public void suspendAccount(int accountNumber) {
       	find(accountNumber).suspend();
    }
    
	public void reOpenAccount(int accountNumber) {
		find(accountNumber).reOpen();
	}
	
	//Upon reaching the closed state, no further changes in status are possible.   
	public void closeAccount(int accountNumber) {
		find(accountNumber).close();
	}
	
	public String getAccountStatus(int accountNumber) {
		return find(accountNumber).getStatus();
	}
	
	//Summarizing account transactions.
	public String summarizeAccountTransactions(int accountNumber) {
		return find(accountNumber).getTransaction();
	}
	
	//Summarizing all accounts.
	public String summarizeAllAccounts() {
		String b = "";
		for(BankAccount account : accounts) {
	    b += String.format("%7d%14.1f%14d%14s", account.getAccountNumber(), account.getBalance(), account.retrieveNumberOfTransaction(), account.getStatus()) + "\n";	
		}
		
		return String.format("%7s%14s%14s%14s", "Account", "Balance", "#Transaction", "Status")
			  +"\n" + b;
	}
	
	//Get all accounts in the bank
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	
	//Analyzing active accounts.
	public String analyzerActiveAccounts() {
		return accAnalyzer.analyze();
	}
	
	public String[] analyzerActiveAccountsResult() {
		return accAnalyzer.resultAnalyze();
	}
}
