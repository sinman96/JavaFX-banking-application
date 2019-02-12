// This is the code for the user to execute various options with their account
package bank;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class Bank {

    
    public static void main(String[] args) {
        //this is where you enter data of the user
        Bankaccount obj1 = new Bankaccount("XYZ", 134,"Checkingsaccounts");
        obj1.Useroptions();

    }
    }
    
    class Bankaccount
    {
    double balance;
    double previousTransaction;
    double interest;
    String Customername;
    int CustomerID;
    String Accounttype;
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
    
    Bankaccount(String cname, int cid, String ctype)
    {
        Customername =cname;
        CustomerID = cid;
        Accounttype = ctype;
    }
    
    
    void deposit(double amount)
    {
        if (amount!=0)
        {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    
    void withdraw(double amount)
    {
        if (amount!=0)
        {
            balance = balance - amount;
            previousTransaction = -amount;
        } 
    }
    
    void getPreviousTransaction()
    {
        if (previousTransaction>0)
        {
            System.out.println("Deposited: " + previousTransaction);
        } 
        else if(previousTransaction<0)
        {
           System.out.println("Withdrawn: " + Math.abs(previousTransaction)); 
        }
        else
        {
            System.out.println("No transaction made");
        }
    }
    
    Scanner scanner = new Scanner(System.in);
    String accounttype = scanner.next();
    
    //calculating the interest rates per bracket of balance
    void balances()
    {
        if (accounttype.equals("Checkingsaccount")){
            interest = 0.001;
            balance = (1+interest)*balance;
        }
        else if (accounttype.equals("Savingsaccount")){
            if(balance<=1000){
                interest = 0.001;
              balance = (1+interest)*balance;
                if(balance>1000) {
                        interest = 0.002;
                        balance = 1000*(1+0.001)+(balance-1000)*(1+interest);
                        }
                else if (accounttype.equals("Maxi-Savingsaccount")){
                     if(balance<=1000){
                interest = 0.02;
              balance = (1+interest)*balance;
                if(balance>1000&&balance<=2000) {
                        interest = 0.05;
                        balance = 1000*(1+0.02)+(balance-1001)*0.05;
                        }
                if (balance>2000){
                    interest = 0.1;
                    balance = 1000*(1+0.02)+(2000-1001)*0.05+(balance-2001)*(1+interest);
                }
                }
            }
        }
    }
    }
      double transfer (double amount, double fee)
    {
        amount += fee;
        if (amount < 0) // withdraw value is negative
        {
            System.out.println ();
            System.out.println ("Error: Withdraw amount is invalid.");
            System.out.println ("Account: " + CustomerID);
            System.out.println ("Requested: " + fmt.format(amount));
        }
        else
        if (amount > balance) // withdraw value exceeds balance
        {
            System.out.println ();
            System.out.println ("Error: Insufficient funds.");
            System.out.println ("Account: " + CustomerID);
            System.out.println ("Requested: " + fmt.format(amount));
            System.out.println ("Available: " + fmt.format(balance));
        }
        else
            balance = balance - amount;

         //The account that the money is being deposited into

        if (amount < 0) // deposit value is negative
        {
            System.out.println ();
            System.out.println ("Error: Deposit amount is invalid.");
            System.out.println (CustomerID + " " + fmt.format(amount));
        }
        else
            return
            balance = balance + amount;
        return 0;
    }
    
    
    void Useroptions()
    {
       char option = '\0';
       Scanner scanner = new Scanner(System.in);
       
       System.out.println(" Welcome " +Customername);
       System.out.println(" Your ID is " +CustomerID);
       System.out.println("\n");
       System.out.println("A. CheckBalance ");
       System.out.println("B. Deposit "); 
        System.out.println("C. Withdraw "); 
        System.out.println("D. PreviousTransaction ");
        System.out.println("E. Transfer ");
        System.out.println("F. Cancel "); 
        
        do
        {
           System.out.println("=======================================");
           System.out.println("Enter an option");
           option = scanner.next().charAt(0);
           System.out.println("\n");
           
           switch(option)
           {
               case 'A':
                 System.out.println("=======================================");
                 System.out.println("Balance =" + balance);
                 System.out.println("=======================================");
                 System.out.println("\n");
                 break;
                 
               case 'B':
                 System.out.println("=======================================");
                 System.out.println("Enter an amount to deposit");
                 System.out.println("=======================================");
                 double amount = scanner.nextDouble();
                 deposit(amount);
                 System.out.println("\n");
                 break;  
                 
                 case 'C':
                 System.out.println("=======================================");
                 System.out.println("Enter an amount to withdraw");
                 System.out.println("=======================================");
                 double amount2 = scanner.nextDouble();
                 withdraw(amount2);
                 
                 System.out.println("\n");
                 break;  
                 
                 case 'D':
                 System.out.println("=======================================");
                 getPreviousTransaction();
                 System.out.println("=======================================");
                 System.out.println("\n");
                 break;
                 
                 case 'E':
                 System.out.println("=======================================");
                 System.out.println("Enter Account to transfer from: ");
                 System.out.println("=======================================");
                 System.out.println("\n");
                 break;
                 
                 case 'F':
                 System.out.println("=======================================");
                  System.out.println("Card cancelled");
                 System.out.println("=======================================");
                 
                 default:
                     System.out.println("Invalid option. Please try again");
                     break;
                     
           }
           
        }while(option != 'E');
        
        System.out.println("Thank you again for using our services");
                 
      class Bankaccounts{
       String Name;
    int CustomerID;
    String accounttype;   
                 
       public Bankaccounts(String Name, int iCustomerID, String accounttype)
    {
        this.Name=Name;
        this.CustomerID= iCustomerID;
        this.accounttype = accounttype;
    }
                 
      ArrayList<Bankaccounts> alBankaccounts = new ArrayList();
        
        Scanner osScan = new Scanner(System.in);
        Scanner oiScan = new Scanner(System.in);
       
        String sName;
        int iCustomerID;
        String saccounttype;
        int iCount;
        //for N customers
        for (iCount=0; iCount<N; iCount++)
        {
        
        System.out.println("Enter a Customer's name:");
        sName =osScan.nextLine();
        System.out.println("Enter a Customer's ID:");
        iCustomerID =oiScan.nextInt();
        System.out.println("Enter a Customers account type:");
        saccounttype =osScan.nextLine();
        alBankaccounts.add(new Bankaccounts(sName,iCustomerID, saccounttype));
    }
        //Ranking all the entries by customer name to see how many accounts they have.
        Collections.sort(alBankaccounts, new Comparator<Bankaccounts>()
        {
            @Override
            public int compare(Bankaccounts s1, Bankaccounts s2)
            {
         return (s2.Name).compareTo(s1.Name);
            }
        });
    
        for (iCount=0; iCount<alBankaccounts.size(); iCount ++)
        {
     System.out.println("CustomerName: " + alBankaccounts.get(iCount).Name + ", CustomerID: " + alBankaccounts.get(iCount).CustomerID,", Accounttype: " + alBankaccounts.get(iCount).accounttype);
        }
                 
                 
                 
                 
        }
    }
    }


        
        
        
        
        
