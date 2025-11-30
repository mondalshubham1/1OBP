package accounts.impl;

import accounts.BankAccount;

import java.util.UUID;

public class SBIAccount implements BankAccount {
    private int balance;
    private String accountNumber;
    private String password;
    public String name;
    public static double rateOfInterest;

    public SBIAccount(int balance, String password, String name) {
        this.accountNumber = UUID.randomUUID().toString();
        this.balance = balance;
        this.password = password;
        this.name = name;
    }

    @Override
    public int checkBalance(String password) {
        if(password.equals(this.password))
            return this.balance;
        return -1;
    }

    @Override
    public String addMoney(int money) {
        this.balance += money;
        String message = money + " has been added to the account " + accountNumber + " " + " total balance is " + balance;
        return message;
    }

    @Override
    public String withdrawMoney(int drawMoney, String password) {
        if(password.equals(this.password)) {
            if(drawMoney > this.balance) {
                return "Insufficient Balance";
            }
            else {
                this.balance -= drawMoney;
                return "Money withdrawn successfully, Remaining balance is " + this.balance;
            }
        }
        return "Wrong Password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)) {
            this.password = newPassword;
            return "Password has been changed";
        }
        else {
            return "Wrong Password";
        }
    }

    @Override
    public double calculateTotalInterest(int years) {
        double interest = balance*years*rateOfInterest/100;
        return interest;
    }
}
