package atm;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class AccountType extends Account{
    Scanner input = new Scanner(System.in);
    HashMap<Integer,Integer> data = new HashMap<>();

    /** User data stored */
    public void userData() {
        data.put(1111,1234);
        data.put(2222,1234);
        data.put(3333,1234);
    }

    /** Login page logic */
    public void getLogin() {
        userData();
        int x;
        do {
            x = 1;
            System.out.println("Welcome To The ATM System!");
            System.out.print("Enter your ATM Number : ");
            setAccountNo(input.nextInt());
            System.out.print("Enter Your ATM Pin : ");
            setAccountPin(input.nextInt());
            System.out.println();
            int accNo = getAccountNo();
            int accPin = getAccountPin();
            if (data.containsKey(accNo) && data.get(accNo) == accPin) {
                getAccountType();
            } else if (!data.containsKey(accNo)) {
                System.out.println("You entered Account No does not exist.\nPlease Try again");
                System.out.println();
                x = 2;
            } else {
                System.out.println("you entered Account Pin are invalid! \nPlease try again later");
                System.out.println();
                x = 2;
            }
        }while(x != 1);
    }

    /** Account type mentioned in method */
    public void getAccountType() {
        System.out.println("Select The Account you want to Access: ");
        System.out.println("Choice 1: Bussiness Account.");
        System.out.println("Choice 2: Saving Account.");
        System.out.println("Choice 3: Exits");
        System.out.print("Please entered your choice : ");
        int selection = input.nextInt();
        System.out.println();
        switch (selection) {
            case 1:
                getBussiness();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using The ATM service! Visit again");
                break;
            default :
                System.out.println("you entered invalid choice. Please choose valid choice.");
                getAccountType();
                break;
        }

    }

    /** This method is transaction related method.
     * This common both saving and bussines account.
     */
    public void transactionChoice() {
        System.out.println("Choice 1: View Balance.");
        System.out.println("Choice 2: Withdrow Funds.");
        System.out.println("Choice 3: Deposite Funds.");
        System.out.println("Choice 4: Exit.");
        System.out.print("Entered Your Choice :");
    }

    /** this continue method for Saving Account to repeat the process code or not */
    public void continueMethodSaving() {
        System.out.print("If you want to continue please press 1 other wise press any key : ");
        char ans = input.next().charAt(0);
        System.out.println();
        if(ans == '1') {
            getSaving();
        }
        else {
            System.out.println("Thank you using ATM Service! Visit again.");
        }
    }

    /** this continue method for Bussiness Account to repeat the process code or not */
    public void continueMethodBussiness() {
        System.out.print("If you want to continue please press 1 other wise press any key : ");
        int ans = input.nextInt();
        System.out.println();
        if(ans == 1) {
            getBussiness();
        }
        else {
            System.out.println("Thank you using ATM Service! Visit again.");
        }
    }

    /** this is Bussiness Account related method.
     *  this method can be handled all Bussiness Account related process.
     *  like withdrowing money, deposit money etc.
     */

    public void getBussiness() {
        System.out.println("Bussiness Account :");
        transactionChoice();
        int selection = input.nextInt();
        switch(selection) {
            case 1:
                System.out.println("\t************************************");
                System.out.println("\t    Your Balance is :$" + getBussinessAcc());
                System.out.println("\t************************************");
                continueMethodBussiness();
                break;
            case 2:
                getBussinessAccWithdrowInpute();
                continueMethodBussiness();
                break;
            case 3:
                getBussinessAccDepositeInput();
                continueMethodBussiness();
                break;
            case 4:
                System.out.println("Thank you using ATM Service! Visit again");
                break;
            default:
                System.out.println("You entered choice is invlid. \nPlease entered valid choice.");
                getBussiness();
                break;

        }
    }

     /** this is Saving Account related method.
     *  this method can be handled all Saving Account related process.
     *  like withdrowing money, deposit money etc.
     */
    public void getSaving() {
        System.out.println("Saving Account :");
        transactionChoice();
        int selection = input.nextInt();
        switch(selection) {
            case 1:
                System.out.println("\t**********************************");
                System.out.println("\t    Your Balance is :$" + getSavingAcc());
                System.out.println("\t**********************************");
                continueMethodSaving();
                break;
            case 2:
                getSavingAccWithdrowInpute();
                continueMethodSaving();
                break;
            case 3:
                getSavingAccDepositeInput();
                continueMethodSaving();
                break;
            case 4:
                System.out.println("Thank you using ATM Service! Visit again");
                break;
            default:
                System.out.println("You entered choice is invlid. \n Please entered valid choice.");
                getSaving();
                break;

        }

    }
}
