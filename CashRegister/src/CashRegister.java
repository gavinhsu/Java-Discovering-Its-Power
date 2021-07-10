import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//Input stop to check for the result

public class CashRegister {
	private static int trans = 0;
	private static int total = 0;
	private static ArrayList<Integer> amountList = new ArrayList<Integer>();
	private static ArrayList<String> registList = new ArrayList<String>();
	
	//add an amount to a running total and increments the number of transactions
	public static double AddTransaction(double transAmount) {
        total += transAmount;
        return total;
	}
	
	//returns the number of transactions received
	public static int TransactionCount() {
		return trans;
	}
	
	//returns the sum of the amounts of the transactions
	public static double Total() {
		return total;
	}
	
	//sets the total amount and transaction count to 0
	public static void ResetTransactions() {
		CashRegister.trans = 0;
		CashRegister.total = 0;
		CashRegister.amountList.clear();
		CashRegister.registList.clear();
	}
	
	//returns the number of cash registers created
	public static int RegisterCount() {
		return registList.size();
	}
	
	public static void main (String[] args) throws IOException {
		boolean stop = true;
		
		while(stop) {
			Scanner sc= new Scanner(System.in);
			System.out.println("If no longer regist for cash, input 'stop' ");
	        System.out.println("Regist your name:");
	        String registName = sc.nextLine();
	        if(registName.contains("stop") ){
	        	stop = false;
	        	break;
	        }
	        
	        System.out.println("How much:");
	        int transAmount = sc.nextInt();
	        if(Integer.toString(transAmount).contains("stop") ){
	        	stop = false;
	        	break;
	        }

	        //Check whether the name is in the registList
	        int same = 0;
	        for (int i=0; i<registList.size(); i++) {
	        	if(registName.compareTo(registList.get(i)) == 0){
	        		 same = 1;
	        	}
	        }
	        if(same == 0) {
	        	registList.add(registName);
	        }
	        
	        //Add number of transaction and amount
	        trans += 1;
	        AddTransaction(transAmount);
		}
		
		//verify
		System.out.println("The number of transactions received:" + TransactionCount());
		System.out.println("The sum of the amounts of the transactions:" + Total());
		System.out.println("The number of cash registers created:" + RegisterCount());
    	ResetTransactions();
    	System.out.println("");
    	System.out.println("Check whether the record is refresh");
		System.out.println("The number of transactions received:" + TransactionCount());
		System.out.println("The sum of the amounts of the transactions:" + Total());
		System.out.println("The number of cash registers created:" + RegisterCount());

	}

}
