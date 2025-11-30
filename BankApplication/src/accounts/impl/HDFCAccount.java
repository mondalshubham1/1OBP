package accounts.impl;

import accounts.BankAccount;

public class HDFCAccount implements BankAccount {
    @Override
    public int checkBalance(String password) {
        return 0;
    }

    @Override
    public String addMoney(int money) {
        return "";
    }

    @Override
    public String withdrawMoney(int money, String password) {
        return "";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        return "";
    }

    @Override
    public double calculateTotalInterest(int years) {
        return 0;
    }
}
