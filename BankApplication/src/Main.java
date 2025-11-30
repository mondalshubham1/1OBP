import accounts.BankAccount;
import accounts.impl.SBIAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Open 2 SBI Account with certain balance, password, name.
        // Open 1 HDFC Account with certain balance, password, name.

        // Fetch the balance of SBI accounts, checking balance needs a password, and then print that balance.
        // Do the same for the HDFC Account.

        // Add Money to the accounts.
        // Withdraw Money from the accounts.

        // Change Password for the accounts.
        // Total interest in the account.

        SBIAccount.rateOfInterest = 7;

        BankAccount account = new SBIAccount(10000, "1234", "Mondal");

        System.out.println("balance is : " + account.checkBalance("867393"));
        System.out.println("balance is : " + account.checkBalance("1234"));

        account.addMoney(4000);
        System.out.println(account.checkBalance("1234"));

        account.withdrawMoney(8000, "123434");
        System.out.println(account.checkBalance("1234"));


        account.withdrawMoney(8000, "1234");
        System.out.println(account.checkBalance("1234"));

        System.out.println(account.calculateTotalInterest(2));

    }
}