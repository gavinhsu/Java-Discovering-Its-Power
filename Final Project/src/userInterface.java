import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class userInterface {
	Bank user = new Bank();
	//initial UI setup
	JFrame f = new JFrame("Bank Account");

	//panel
	//home page
	JPanel home = new JPanel();
	JPanel homeRight = new JPanel();
	//Summarize page
	JPanel allAccountPage = new JPanel();
	JPanel allAccountPageUp = new JPanel();
	JPanel allAccountPageDown = new JPanel();
	JPanel allAccountPageDownBtn = new JPanel();
	JPanel allAccountPageDownNum = new JPanel();
	JPanel allAccountPageDownBalance = new JPanel();
	JPanel allAccountPageDownTrnx = new JPanel();
	JPanel allAccountPageDownStatus = new JPanel();	
	//Analysis Page
	JPanel analyzePage = new JPanel();
	JPanel analyzePageCenter = new JPanel();
	JPanel analyzePageDown = new JPanel();
	//Account Page
	JPanel accountPage = new JPanel();
	JPanel accountPageUp = new JPanel();
	JPanel info = new JPanel();
	JPanel action = new JPanel();
	JPanel actionName = new JPanel();
	JPanel actionTODO = new JPanel();
	JPanel accountPageDown = new JPanel();
		
	//label
	//home page 
	JLabel accountNum = new JLabel();
	JLabel initialDeposit = new JLabel();
	JLabel allAccounts = new JLabel();
	//summarize page
	JLabel accountPageNum = new JLabel();
	JLabel accountPageBalance = new JLabel();
	JLabel accountPageTrnx = new JLabel();
	JLabel accountPageStatus = new JLabel();
	//analysis page
	JLabel analyzePageTitle = new JLabel();
	JLabel analyzePageCount = new JLabel();
	JLabel analyzePageTotal = new JLabel();
	JLabel analyzePageAvg = new JLabel();
	JLabel analyzePageMin = new JLabel();
	JLabel analyzePageMax = new JLabel();
	//account page
	JLabel accountID = new JLabel();
	JLabel accountBalance = new JLabel();
	JLabel accountTrnx = new JLabel();
	JLabel accountStatus = new JLabel();
	
	//textfield
	JTextField accNum = new JTextField(30);
	JTextField iniDeposit = new JTextField(30);
	JTextField depositCash = new JTextField(30);
	JTextField withdrawCash = new JTextField(30);
	
	//button
	JButton add = new JButton("Add Account");
	JButton check = new JButton("Check All Accounts");
	JButton analyze = new JButton("Analyze");
	JButton back = new JButton("Back to adding new account");
	JButton accountDeposit = new JButton("Deposit");
	JButton accountWithdraw = new JButton("Withdraw");
	
	 public void home() {	
         f.setVisible(true);
         //home page
         f.add(home);
         home.setLayout(new BorderLayout(20,20)); 
         home.add(add,BorderLayout.WEST);
         home.add(check,BorderLayout.SOUTH);
         home.add(homeRight,BorderLayout.CENTER);
         homeRight.setLayout(new GridLayout(0, 1, 0, 5));
         homeRight.add(accountNum);
         homeRight.add(accNum);
         homeRight.add(initialDeposit);
         homeRight.add(iniDeposit);
         accountNum.setText("Account Number");
         initialDeposit.setText("The initial Deposit");
         f.setSize(500,250);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         System.out.println("The initial Deposit");
         add();
         check();
     }
     
     public void add() {
         add.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         String id = accNum.getText();
         String money = iniDeposit.getText();
         System.out.println(Integer.valueOf(id));
         System.out.println(Integer.valueOf(money));
         Integer accountNumber = Integer.valueOf(id);
         Integer iniDepos = Integer.valueOf(money);
         user.addAccount(accountNumber,iniDepos);
         accNum.setText("");
         iniDeposit.setText("");
         }	
         });
     }
     
     public void analyze() {
         analyze.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 f.getContentPane().removeAll();
                 f.repaint();
                 f.add(analyzePage);
                 analyzePage.setLayout(new BorderLayout()); 
                 analyzePage.add(analyzePageCenter,BorderLayout.CENTER);
                 analyzePageCenter.setLayout(new GridLayout(6,1,15,5));
                 analyzePageCount.setText("Active Accounts = " + user.analyzerActiveAccountsResult()[0]);
                 analyzePageTotal.setText("Total Balance = " + user.analyzerActiveAccountsResult()[1]);
                 analyzePageAvg.setText("Average Balance = " + user.analyzerActiveAccountsResult()[2]);
                 analyzePageMin.setText("Minimum Balance = " + user.analyzerActiveAccountsResult()[3]);
                 analyzePageMax.setText("Maximum Balance = " + user.analyzerActiveAccountsResult()[4]);
                 analyzePageCenter.add(analyzePageTitle);
                 analyzePageTitle.setText("Analysis of active accounts");
                 analyzePageCenter.add(analyzePageCount);
                 analyzePageCenter.add(analyzePageTotal);
                 analyzePageCenter.add(analyzePageAvg);
                 analyzePageCenter.add(analyzePageMin);
                 analyzePageCenter.add(analyzePageMax);
                 analyzePage.add(analyzePageDown,BorderLayout.SOUTH);
                 analyzePageDown.add(back);
             }
         });
     }
     
     public void check() {
         check.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             f.getContentPane().removeAll();
             f.repaint();
 
             f.add(allAccountPage);
             
             //Upper setup
             allAccountPage.setLayout(new BorderLayout()); 
             allAccountPage.add(allAccountPageUp,BorderLayout.NORTH);
             allAccountPageUp.add(allAccounts);
             
             //Center setup
             allAccountPage.add(allAccountPageDown,BorderLayout.CENTER);
             //add each section panel
             allAccountPageDown.setLayout(new GridLayout(1,4,15,5));
             allAccountPageDown.add(allAccountPageDownNum);
             allAccountPageDown.add(allAccountPageDownTrnx);
             allAccountPageDown.add(allAccountPageDownBalance);
             allAccountPageDown.add(allAccountPageDownStatus);
             allAccounts.setText("All Accounts");
             accountPageNum.setText("Number");
             accountPageBalance.setText("      Balance");
             accountPageTrnx.setText("Transaction      ");
             accountPageStatus.setText("Status");
             
             //add num btns
             allAccountPageDownNum.setLayout(new GridLayout(user.getAccounts().size() + 1,1,5,5));
             allAccountPageDownNum.add(accountPageNum);
             JButton[] numsBtn = new JButton[user.getAccounts().size()];
             for(int i=0; i<user.getAccounts().size(); i++) {  			
                     JButton accNumsBtn = new JButton("#" + String.valueOf(user.getAccounts().get(i).getAccountNumber()));
                     accNumsBtn.setPreferredSize(new Dimension(15, 10));
                     numsBtn[i] = accNumsBtn;
                     allAccountPageDownNum.add(numsBtn[i]);	
                 }
                             
             //add trnx record
             allAccountPageDownTrnx.setLayout(new GridLayout(user.getAccounts().size() + 1,1,5,5));
             allAccountPageDownTrnx.add(accountPageTrnx);
             JLabel[] trnxs = new JLabel[user.getAccounts().size()];
             for(int i=0; i<user.getAccounts().size(); i++) {  			
                     JLabel accTrnxs = new JLabel(String.valueOf(user.getAccounts().get(i).retrieveNumberOfTransaction()));
                     trnxs[i] = accTrnxs;
                     allAccountPageDownTrnx.add(trnxs[i]);
                 }	
             
             //add balance record
             allAccountPageDownBalance.setLayout(new GridLayout(user.getAccounts().size() + 1,1,5,5));
             allAccountPageDownBalance.add(accountPageBalance);
             JLabel[] balances = new JLabel[user.getAccounts().size()];
             for(int i=0; i<user.getAccounts().size(); i++) {  			
                     JLabel accBalances = new JLabel("      " + String.valueOf(user.getAccounts().get(i).getBalance()));
                     balances[i] = accBalances;
                     allAccountPageDownBalance.add(balances[i]);
                 }	
             
             //add status record
             allAccountPageDownStatus.setLayout(new GridLayout(user.getAccounts().size() + 1,1,5,5));
             allAccountPageDownStatus.add(accountPageStatus);
             JLabel[] statuses = new JLabel[user.getAccounts().size()];
             for(int i=0; i<user.getAccounts().size(); i++) {  			
                     JLabel accStatuses = new JLabel(String.valueOf(user.getAccounts().get(i).getStatus()));
                     statuses[i] = accStatuses;
                     allAccountPageDownStatus.add(statuses[i]);
                 }	
             
             //Downward setup
             allAccountPage.add(allAccountPageDownBtn,BorderLayout.SOUTH);
             allAccountPageDownBtn.setLayout(new GridLayout(1,2,5,5));
             allAccountPageDownBtn.add(analyze);
             allAccountPageDownBtn.add(back);
           //single account page
             for(int j=0; j<user.getAccounts().size(); j++) {
                 final String accountNumber =  numsBtn[j].getText().substring(1);
                 numsBtn[j].addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         allAccountPage.setVisible(false);
                         //accountPage
                         f.add(accountPage);
                         accountPage.setLayout(new BorderLayout(20,20));
                         accountPage.add(accountPageUp,BorderLayout.CENTER);
                         accountPage.add(accountPageDown,BorderLayout.SOUTH);
                         accountPageDown.add(back);
                         accountPageUp.setLayout(new GridLayout(1,2,5,5));
                         accountPageUp.add(info);
                         info.setLayout(new GridLayout(3,1,5,5));
                         accountID.setText("Account   #" + accountNumber);
                         info.add(accountID);
                         
                         for(int i=0; i<user.getAccounts().size(); i++) { 
                             if(String.valueOf(user.getAccounts().get(i).getAccountNumber()).equals(accountNumber)) {
                                 String balance = String.valueOf(user.getAccounts().get(i).getBalance());
                                 String trnx = String.valueOf(user.getAccounts().get(i).retrieveNumberOfTransaction());
                                 accountBalance.setText("Balance = " + balance);
                                 accountTrnx.setText("Transactions = " + trnx + " times");
                                 info.add(accountBalance);
                                 info.add(accountTrnx);

                             }
                         }
                         
                         //deposit
                         accountDeposit.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                             Double depositAccount = Double.parseDouble(depositCash.getText());
                             user.deposit(Integer.valueOf(accountNumber),depositAccount);
                             depositCash.setText(null);
                             }	
                         });
                         
                         //withdraw
                         accountWithdraw.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                             Double withdrawAccount = Double.parseDouble(withdrawCash.getText());
                             user.withdraw(Integer.valueOf(accountNumber),withdrawAccount);
                             withdrawCash.setText(null);
                             }	
                         });
                         accountPageUp.add(action);
                         action.setLayout(new GridLayout(1,2,5,5));
                         action.add(actionName);
                         actionName.setLayout(new GridLayout(3,1,5,5));
                         actionName.add(accountDeposit);
                         actionName.add(accountWithdraw);
                         actionName.add(accountStatus);
                     	accountStatus.setText("Status");
                         action.add(actionTODO);
                         actionTODO.setLayout(new GridLayout(3,1,5,5));
                         actionTODO.add(depositCash);
                         actionTODO.add(withdrawCash);
                         //status menu bar
                         JMenuBar mb = new JMenuBar();
                         JMenu status = new JMenu();
                            for(int i=0; i<user.getAccounts().size(); i++) {  			
                             if(String.valueOf(user.getAccounts().get(i).getStatus()).equals("OPEN")) {
                                 status.setText("OPEN");
                                 
                             }
                             else if(String.valueOf(user.getAccounts().get(i).getStatus()).equals("SUSPEND")) {
                                 status.setText("SUSPEND");
                             }
                             else if(String.valueOf(user.getAccounts().get(i).getStatus()).equals("CLOSED")) {
                                 status.setText("CLOSED");
                             }
                         }	
                            JMenuItem open = new JMenuItem("OPEN");
                         JMenuItem suspend = new JMenuItem("SUSPEND");
                         JMenuItem close = new JMenuItem("CLOSED");
                         mb.add(status);
                         status.add(open);
                         status.add(suspend);
                         status.add(close);
                         actionTODO.add(mb);
                                                 
                     }
                 });
             };
             analyze();
             back();
         }	
         });
     }
     
     public void back() {
         back.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 f.getContentPane().removeAll();
                 f.repaint();
                 home();
             }	
         });
     }
}
