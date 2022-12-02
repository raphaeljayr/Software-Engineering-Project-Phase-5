import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.util.Random;

public class BankProgram {

    static boolean loggedin = false;
    static int userMenuIn = 0;
    static String newLineBuffer = "";

    static String loggedInAcctNum = "";
    static double loggedInBal = 0;
    static int loggedInIndex = 0;

    public static void main(String[] args) throws Exception{

        ArrayList<Account> AcctArr = new ArrayList<Account>();

        //Some starting accounts to work with
        AcctArr.add(new Account("111111111111", "host@mail.com", "test1", "Tester",
            "111-111-1111", "11/11/1111", "111 Road Ln. Dallas, TX 75007", 100));

        AcctArr.add(new Account("123456789123", "jrisodore@gmail.com", "chickenhead22", "J.R. Isodore",
            "999-999-9999", "10/12/1999", "123 Broad Rd. Dallas, TX 75010", 50));

        AcctArr.add(new Account("224466880011", "ryanly@gmail.com", "thisismyaccount1", "Ryan Ly",
            "111-111-1111", "08/28/2001", "1421 Meadow Vista Dr. Carrollton, TX 75007", 20));

        AcctArr.add(new Account("331155678920", "frankstacos@hotmail.com", "freshquesorito8899", "Franklin Monre",
            "238-235-1547", "09/23/1980", "6942 Broadville Ave. Plano, TX 75036", 6000));

        AcctArr.add(new Account("987654321845", "klarasdresshouse@dressblog.org", "silkandfabric2022", "Klara Isfel",
            "123-246-6666", "01/01/2001", "1111 Long Rd. Paris, TX 78450", 50000));
    

        System.out.print(",-----.               ,--.   ,--.                   ,---.              \n");
        System.out.print("|  |) /_ ,--,--,--,--,|  |,-.`--,--,--, ,---.      /  O  \\ ,---. ,---. \n");
        System.out.print("|  .-.  ' ,-.  |      |     /,--|      | .-. |    |  .-.  | .-. | .-. |\n");
        System.out.print("|  '--' \\ '-'  |  ||  |  \\  \\|  |  ||  ' '-' '    |  | |  | '-' | '-' '\n");
        System.out.print("`------' `--`--`--''--`--'`--`--`--''--.`-  /     `--' `--|  |-'|  |-' \n");
        System.out.print("                                       `---'              `--'  `--'   \n\n");
            
         // User will enter an input depending if they want to "Log-in" or "Create Account".
        while(loggedin == false){
            //reset menu choice to 0
            userMenuIn = 0;
            System.out.print("Welcome, select option: \n");
            System.out.print("1.    Login with existing account\n2.    Create an account\n3.    Exit\n");

            Scanner input = new Scanner(System.in);
            userMenuIn = input.nextInt();
            newLineBuffer = input.nextLine();

            if(userMenuIn == 1){
                loggedInIndex = LogIn.login(AcctArr);

                if(loggedInIndex < 0){
                    continue;
                }
                else{
                    loggedInAcctNum = AcctArr.get(loggedInIndex).getAccountNumber();
                    loggedInBal = AcctArr.get(loggedInIndex).getBalance();
                    loggedin = true;
                }

            }

            if(userMenuIn == 2){
                CreateAcct.create(AcctArr);
            }

            if(userMenuIn == 3){
                System.out.print("Exiting...\n");
            }
        }

        while (userMenuIn != 4){
            //System.out.print("\nMAIN MENU\n\n");
            System.out.print("\n  __  __       _         __  __                  \n");
            System.out.print(" |  \\/  |     (_)       |  \\/  |                 \n");
            System.out.print(" | \\  / | __ _ _ _ __   | \\  / | ___ _ __  _   _ \n");
            System.out.print(" | |\\/| |/ _` | | '_ \\  | |\\/| |/ _ \\ '_ \\| | | |\n");
            System.out.print(" | |  | | (_| | | | | | | |  | |  __/ | | | |_| |\n");
            System.out.print(" |_|  |_|\\__,_|_|_| |_| |_|  |_|\\___|_| |_|\\__,_|\n\n");
            System.out.print("Select an option:\n");
            System.out.print("1.Withdraw Money\n2.Deposit Money\n3.Display Account Information\n4.Exit\n");
        
            Scanner input = new Scanner(System.in);
            userMenuIn = input.nextInt();
            newLineBuffer = input.nextLine();
        
            switch(userMenuIn){
                case 1://withdraw
                {
                    System.out.print("Enter the amount you want withdraw:\n");
                    double balance = input.nextDouble();
                
                    int validWithdrawal = AcctArr.get(loggedInIndex).withdraw(balance);   
                    if (validWithdrawal == 1)
                    {
                        System.out.print("Insufficient balance, withdrawal not executed\n");
                    }
                    else if (validWithdrawal == 2)
                    {
                        System.out.print("Amount cannot be negative, withdrawal not executed\n");
                    }
                    else
                    {
                        System.out.print("The new balance is $" + AcctArr.get(loggedInIndex).getBalance() + "\n");
                    }
                    break;
                }
                case 2://deposit
                {
                    System.out.print("Enter the amount you want to deposit:\n");
                    double balance = input.nextDouble();
                
                    int validDeposit = AcctArr.get(loggedInIndex).deposit(balance);
                    if (validDeposit == 1)
                    {
                        System.out.print("The amount cannot be negative, deposit not executed\n");
                    }
                    else
                    {
                        System.out.print("The new balance is $" + AcctArr.get(loggedInIndex).getBalance() + "\n");
                    }
                    break;
                }
                case 3://display information
                {
                    System.out.print("Account Number: " + AcctArr.get(loggedInIndex).getAccountNumber() + "\n");
                    System.out.print("Email: " + AcctArr.get(loggedInIndex).getEmail() + "\n");
                    System.out.print("Name: " + AcctArr.get(loggedInIndex).getName() + "\n");
                    System.out.print("Phone Number: " + AcctArr.get(loggedInIndex).getPhoneNumber() + "\n");
                    System.out.print("Date: " + AcctArr.get(loggedInIndex).getDate() + "\n");
                    System.out.print("Address: " + AcctArr.get(loggedInIndex).getAddress() + "\n");
                    System.out.print("Balance: " + AcctArr.get(loggedInIndex).getBalance() + "\n");
                    break;
                }
                case 4://exit
                {
                    System.out.print("Exiting...\n");
                }
                default:
                {
                    System.out.print("Not a valid choice, choose again");
                }
            }
        }
    }
}
