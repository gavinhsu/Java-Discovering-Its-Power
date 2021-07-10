import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class User extends JMenuBar{
	
	public static void main(String[] args) {
		Bank user = new Bank();
		System.out.println("You are using a banking system.");
		//initial setting, can comment out
		user.addAccount(1001, 500);
		user.deposit(1001, 300);
		user.deposit(1001, 50);
		user.withdraw(1001, 500);
		user.withdraw(1001, 350);
		user.closeAccount(1001);
		
		user.addAccount(1002, 2500);
		user.deposit(1002, 1500);
		user.withdraw(1002, 2000);
		user.withdraw(1002, 500);
		user.deposit(1002, 4000);
		user.suspendAccount(1002);
		
		
		user.addAccount(1003, 800);
		user.deposit(1003, 1250);
		user.deposit(1003, 700);
		user.deposit(1003, 2000);
		user.withdraw(1003, 400);
		
		user.addAccount(1004, 50);
		user.deposit(1004, 100);
		user.withdraw(1004, 100);
		user.deposit(1004, 750);
		user.withdraw(1004, 500);

		back : {while(true){
			System.out.println("Input \"add\" to add new account:");
			System.out.println("Input \"deposit\" to deposit cash to your account:");
			System.out.println("Input \"withdraw\" to withdraw cash from your account:");
			System.out.println("Input \"transfer\" to transfer cash from your account to the target account:");
			System.out.println("Input \"close\" to withdraw cash from your account:");
			System.out.println("Input \"reopen\" to withdraw cash from your account:");
			System.out.println("Input \"suspend\" to withdraw cash from your account:");
			System.out.println("Input \"summarize\" to withdraw cash from your account:");
			System.out.println("Input \"analyze\" to withdraw cash from your account:");
			Scanner sc= new Scanner(System.in);
			try{
				String input = sc.nextLine();
				if(input.equals("add")) {
					System.out.println("Account number:");
					String accountNum = sc.nextLine();
					for(int i=0; i<user.getAccounts().size(); i++) { 
	                    if(String.valueOf(user.getAccounts().get(i).getAccountNumber()).equals(accountNum)) {
	                    	System.out.println("The account is already exist.");
	                    	break back;
	                    }
					}
					System.out.println("Initial cash you want to deposit:");
					String initialCash = sc.nextLine();
					user.addAccount(Integer.valueOf(accountNum), Integer.valueOf(initialCash));
					System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
				}
				else if(input.equals("deposit")) {
					System.out.println("Account number:");
					String accountNum = sc.nextLine();
					System.out.println("How much you want to deposit:");
					String depositCash = sc.nextLine();
					try {
						for(int i=0; i<user.getAccounts().size(); i++) { 
		                    if(String.valueOf(user.getAccounts().get(i).getAccountNumber()).equals(accountNum)) {
		                    	if((!user.getAccounts().get(i).getStatus().equals("OPEN"))) {
		                    		System.out.println("You can not deposit this account, please try again.");      		
		                    	}
		                    	else {
		                    		break back;
		                    	}
		                    }
						}
						user.deposit(Integer.valueOf(accountNum), Integer.valueOf(depositCash));
						System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
					}
					catch(NullPointerException e){
						System.out.println("You can not deposit this account, please try again.");
					}	
					
				}
				else if(input.equals("withdraw")) {
					System.out.println("Account number:");
					String accountNum = sc.nextLine();
					System.out.println("How much you want to withdraw:");
					String withDrawCash = sc.nextLine();
					try {
						for(int i=0; i<user.getAccounts().size(); i++) { 
		                    if(String.valueOf(user.getAccounts().get(i).getAccountNumber()).equals(accountNum)) {
		                    	if((!user.getAccounts().get(i).getStatus().equals("OPEN")) || (user.getAccounts().get(i).getBalance() < Integer.valueOf(withDrawCash))) {
		                    		System.out.println("You can not withdraw this account, please try again.");      		
		                    	}
		                    	else {
		                    		break back;
		                    	}
		                    }
						}
						user.withdraw(Integer.valueOf(accountNum), Integer.valueOf(withDrawCash));
						System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
					}
					catch(NullPointerException e){
						System.out.println("You can not withdraw this account or this amount, please try again.");
					}		
				}
				else if(input.equals("transfer")) {
					System.out.println("The account number you would like to transfer from:");
					String aAccountNum = sc.nextLine();
					System.out.println("The account number you would like to transfer to:");
					String bAccountNum = sc.nextLine();
					System.out.println("How much you want to transfer:");
					String transferCash = sc.nextLine();
					try {	
						user.transfer(Integer.valueOf(aAccountNum), Integer.valueOf(bAccountNum), Integer.valueOf(transferCash));
						System.out.println(user.summarizeAccountTransactions(Integer.valueOf(aAccountNum)));
						System.out.println(user.summarizeAccountTransactions(Integer.valueOf(bAccountNum)));
					}
					catch(NullPointerException e){
						System.out.println("You can not withdraw this account or this amount, please try again.");
					}		
				}
				else if(input.equals("close")) {
					System.out.println("Account number:");
					String accountNum = sc.nextLine();
					for(int i=0; i<user.getAccounts().size(); i++) { 
	                    if(String.valueOf(user.getAccounts().get(i).getAccountNumber()).equals(accountNum)) {
	                    	if(user.getAccounts().get(i).isClosed()) {
	                    		System.out.println("The account was already closed");
	            				System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
	                    	}
	                    	else {
	                    		user.closeAccount(Integer.valueOf(accountNum));
	                    		System.out.println("The account status is closed now.");
	            				System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
	                    	}		
	                    	}
	                    }
				}
				else if(input.equals("reopen")) {
					System.out.println("Account number:");
					String accountNum = sc.nextLine();
					for(int i=0; i<user.getAccounts().size(); i++) { 
	                    if(String.valueOf(user.getAccounts().get(i).getAccountNumber()).equals(accountNum)) {
	                    	if(user.getAccounts().get(i).isSuspended()) {
	                    		user.reOpenAccount(Integer.valueOf(accountNum));
	                    		System.out.println("The account is reopen again.");
	            				System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
	                    	}
	                    	else if(user.getAccounts().get(i).isClosed()) {
	                    		System.out.println("The account was already closed, you cannot reopen again.");
	            				System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
	                    	}
	                    	else if(user.getAccounts().get(i).isOpen()) {
	                    		System.out.println("The account was already openned, you do not need to reopen again.");
	            				System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
	                    	}	                    	
	                    	}
	                    }
				}
				else if(input.equals("suspend")) {
					System.out.println("Account number:");
					String accountNum = sc.nextLine();
					for(int i=0; i<user.getAccounts().size(); i++) { 
	                    if(String.valueOf(user.getAccounts().get(i).getAccountNumber()).equals(accountNum)) {
	                    	if(user.getAccounts().get(i).isSuspended()) {
	                    		System.out.println("The account was already suspended, you cannot suspend again.");
	            				System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
	                    	}
	                    	else if(user.getAccounts().get(i).isClosed()) {
	                    		System.out.println("The account was already closed, you cannot suspend.");
	            				System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
	                    	}
	                    	else if(user.getAccounts().get(i).isOpen()) {
	                    		user.suspendAccount(Integer.valueOf(accountNum));
	                    		System.out.println("The account is suspended.");
	            				System.out.println(user.summarizeAccountTransactions(Integer.valueOf(accountNum)));
	                    	}                   	
	                    	}
	                    }
				}
				else if(input.equals("summarize")) {
					System.out.println(user.summarizeAllAccounts());
				}
				else if(input.equals("analyze")) {
					System.out.println(user.analyzerActiveAccounts());
				}
				else {
					System.out.println("Please input your request again.");
				}
			}
			catch(NumberFormatException e){
				System.out.println("You should input in correct format, please input your request again.");
			}
		}	
		}
		}
}
	
