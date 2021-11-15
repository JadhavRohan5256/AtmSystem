package atm;
import java.util.Scanner;
public class Account {
    private int accountNo;
    private int accountPin;
    private double bussinessAcc = 0;
    private double savingAcc = 0;
    Scanner input = new Scanner(System.in);

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }
    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public int getAccountPin() {
        return accountPin;
    }

    /** Calculation of bussinessAccount start */
    public void calcBussinessAccDeposite(double bussinessAcc) {
         this.bussinessAcc += bussinessAcc;
    }
    public void calcBussinessAccWithdrow(double withdrow) {
        bussinessAcc -= withdrow;
    }
    public double getBussinessAcc() {
        return this.bussinessAcc;
    }


    /**  Calculation of savingAccount start */
    public void calcSavingAccDeposite(double savingAcc) {
        this.savingAcc += savingAcc;
    }
    public void calcSavingAccWithdrow(double withdrow) {
        savingAcc -= withdrow;
    }
    public double getSavingAcc() {
        return savingAcc;
    }

    /** Withdrowing & Deposite money from Bussiness Account logic */
    public void getBussinessAccWithdrowInpute() {
//        System.out.println("Your Bussiness Account Balace is : " + bussinessAcc);
        System.out.print("Please enter ammount you want to withdrow from Bussiness Account : ");
        double ammount = input.nextDouble();
        if((bussinessAcc - ammount) > 0) {
            calcBussinessAccWithdrow(ammount);
            System.out.println("\t***************************************************");
            System.out.println("\t*   Your ammount has been Sucessfuly Withdrowed   *");
            System.out.println("\t***************************************************");
        }
        else {
            System.out.println();
            System.out.println("Your balance are insufficient. \nplease check your balance and try again.\n");
            getSavingAccWithdrowInpute();
            System.out.println();
        }
    }

    /** Depositing money in Bussiness account logic */
    public void getBussinessAccDepositeInput() {
        System.out.print("Enter the Ammount you want to Deposite in your Bussiness Account : ");
        double ammount = input.nextDouble();
        if(ammount>0) {
            calcBussinessAccDeposite(ammount);
            System.out.println("\t****************************************************");
            System.out.println("\t*   Your ammount has been successfuly Deposited!   *");
            System.out.println("\t****************************************************");
        }
        else {
            System.out.println();
            System.out.println("you entered ammount are invalid. \nAmmount should be positive\n");
            getBussinessAccDepositeInput();
            System.out.println();
        }
    }

    /** Withdrowing money from Saving Account logic */
    public void getSavingAccWithdrowInpute() {
//        System.out.println("Your Saving Account Balace is : " + savingAcc);
        System.out.print("Please enter ammount you want to withdrow from Saving Account : ");
        double ammount = input.nextDouble();
        if((savingAcc - ammount) > 0) {
            calcSavingAccWithdrow(ammount);
            System.out.println("\t***************************************************");
            System.out.println("\t*   Your ammount has been Sucessfuly Withdrowed   *");
            System.out.println("\t***************************************************");
        }
        else {
            System.out.println();
            System.out.println("Your balance are insufficient. \nplease check your balance and try again.\n");
            getSavingAccDepositeInput();
            System.out.println();
        }
    }

    /** Depositing money in Saving account */
    public void getSavingAccDepositeInput() {
        System.out.print("Enter the ammount you want to Deposite in your Saving Account : ");
        double ammount = input.nextDouble();
        if(ammount>0) {
            calcSavingAccDeposite(ammount);
            System.out.println("\t*************************************************");
            System.out.println("\t*  Your ammount has been sucessfuly Deposited.  *");
            System.out.println("\t*************************************************");
        }
        else {
            System.out.println();
            System.out.println("you entered ammount are invalid. \nAmmount should be positive\n");
            getSavingAccDepositeInput();
            System.out.println();
        }
    }
}
