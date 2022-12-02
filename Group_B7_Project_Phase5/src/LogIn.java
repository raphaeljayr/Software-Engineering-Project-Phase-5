import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.util.Random;

public class LogIn{
    public static int login(ArrayList<Account> AcctArr) throws Exception {
        boolean loggedin = false;
        Scanner input = new Scanner(System.in);

        while (loggedin == false) {
            System.out.print("Enter Email: ");
            String userEmail = input.nextLine();

            System.out.print("Enter Password: ");
            String userPassword = input.nextLine();

            for (Account a : AcctArr) {
                if (a.getEmail() != null & a.getEmail().contains(userEmail)) {
                    if (a.getPassword() != null & a.getPassword().contains(userPassword)) {
                        System.out.println("Login Successful\n");
                        loggedin = true;
                        int loggedInIndex = AcctArr.indexOf(a);

                        return loggedInIndex;
                        /*
                         * System.out.println("Num = " + loggedInAcctNum);
                         * System.out.println("IndexInArr = " + loggedInIndex);
                         */
                    }
                }
            }

            if (loggedin == false) {
                System.out.println("Login Failed, try again\n");
            }
        }

        return -1;
    }
}