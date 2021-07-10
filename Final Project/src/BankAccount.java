import java.util.*;
/**
 * To control the transactions and status of the bank account.
 */
public class BankAccount {
	
     private static final String STATUS_OPEN = "OPEN";
     private static final String STATUS_SUSPENDED = "SUSPENDED";
     private static final String STATUS_CLOSED = "CLOSED";
     
	 private double balance;
	 private int accountNumber;
	 private int numberOfTransaction;
	 private String accountState;
	 
	 private ArrayList<String> transactions = new ArrayList<>();
	 
	 //Setting the initial state to open, creating a transaction ArrayList
	 public BankAccount(int anAccountNumber, double initialBalance) {
		 accountNumber = anAccountNumber;
		 accountState = STATUS_OPEN;
		 deposit(initialBalance);
		 }
	 
	 public void setStatus(String status) {
		 accountState = status;
	 }
	 	
	 //The deposit is ignored unless account is open and amount is greater than zero. 
	 public void deposit(double amount) {
		if(amount>0 && accountState.equals(STATUS_OPEN)){
		  balance+=amount;
		  String number=String.valueOf(amount);
		  transactions.add(number);
		  numberOfTransaction++;
		  }
	 }
	 
	 //The withdrawal is ignored unless account is open, the amount is greater than zero and amount does not exceed balance.
	 public void withdraw(double amount) {
         if (amount>0 && accountState.equals(STATUS_OPEN) && amount<=balance) {
	       balance -= amount;
	       String number="-"+String.valueOf(amount);
		   transactions.add(number);
		   numberOfTransaction++;
         }
	 }
	 
	 //status relevant
	 public void suspend() {
		 if (accountState.equals(STATUS_SUSPENDED) == false) {
 		 setStatus(STATUS_SUSPENDED); 
		 }
 	}
	 
	 public void close() { 
		 if (accountState.equals(STATUS_CLOSED) == false) {
		 reOpen();
		 withdraw(balance); 
		 }
		 withdraw(balance); 
		 setStatus(STATUS_CLOSED); 
    }
	 
	 public void reOpen() {
		 if(accountState.equals(STATUS_SUSPENDED)) {
		 setStatus(STATUS_OPEN);
		 }
		 
	 }
	 
	 public boolean isOpen() {
		 if (accountState.equals(STATUS_OPEN)) {
		   return true; 
		 } else {
		   return false; 
		 }
	 }
	 
	 public boolean isSuspended() {
		 if (accountState.equals(STATUS_SUSPENDED)) {
		   return true; 
		 } else {
		   return false; 
		 }
	 }
	 
	 public boolean isClosed() {
		 if (accountState.equals(STATUS_CLOSED)) {
		   return true; 
		 } else {
		   return false; 
		 }
	 }
	 
	 //Adds the amount to account's transactions list 
	 public void addTransactions(double amount){
		  String number= String.valueOf(amount);
		  if(amount>=0){
		   transactions.add("+"+number);
		  }else{
		   transactions.add("-"+number);
		   balance-=amount;
		   numberOfTransaction++;
		  }
	 }
	 
	 //Getting transactions.
	 public String getTransaction() {	  
		 String a = "";
		 int b = 1;
		 for(String i : transactions) {
		 a+= b+" : "+i+"\n";
		 b++;
		 }
		 
		 return " \n" + "Account #" + accountNumber +" transactions:\n\n"
				+ a + "Balance = " + balance
		        + "\nEnd of transactions\n";
	 }
	 
	 //get account info
	 public int retrieveNumberOfTransaction() {
		 return numberOfTransaction;
	 }
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
    public double getBalance() {
        return balance;
    }
    
	public String getStatus() {
		return accountState;
	}
	 
}