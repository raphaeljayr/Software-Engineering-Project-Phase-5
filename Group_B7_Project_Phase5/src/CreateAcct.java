import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.util.Random;

public class CreateAcct {
    public static void create(ArrayList<Account> AcctArr) throws Exception {
        String newUsername, newPassword, newName, newPhone, newBirthdate, newAddr;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your email: ");
        newUsername = input.nextLine();
        while(!newUsername.contains("@") & (!newUsername.contains(".com") || !newUsername.contains(".org") || !newUsername.contains(".net"))){
            System.out.println("Error: Not a valid email address\n");
            System.out.print("Please enter your email: ");
            newUsername = input.nextLine();
        }

        System.out.print("Please enter your password: ");
        newPassword = input.nextLine();

        System.out.print("Please enter your name: ");
        newName = input.nextLine();

        System.out.print("Please enter your phone number: ");
        newPhone = input.nextLine();
        while(!newPhone.contains("-")){
            System.out.println("Error: Not a valid phone number\n");
            System.out.print("Please enter your phone number: ");
            newPhone = input.nextLine();
        }

        System.out.print("Please enter your birth date: ");
        newBirthdate = input.nextLine();
        while(!newBirthdate.contains("/")){
            System.out.println("Error: Not a valid birth date\n");
            System.out.print("Please enter your birth date: ");
            newBirthdate = input.nextLine();
        }

        System.out.print("Please enter your address: ");
        newAddr = input.nextLine();

        Random rand = new Random();
        int upBound = 9;
        int randInt;
        String newUserID = "";
        for(int i = 1; i < 13; i++){
            randInt = rand.nextInt(upBound);
            newUserID = newUserID + randInt;
        }

        AcctArr.add(new Account(newUserID, newUsername, newPassword, newName, newPhone, newBirthdate, newAddr, 0));

        System.out.println("Account Created!\n");
    }
}
