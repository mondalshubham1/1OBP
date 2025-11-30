package accounts;

public interface BankAccount {
    int checkBalance(String password);
    String addMoney(int money);
    String withdrawMoney(int money, String password);
    String changePassword(String oldPassword, String newPassword);
    double calculateTotalInterest(int years);
}
