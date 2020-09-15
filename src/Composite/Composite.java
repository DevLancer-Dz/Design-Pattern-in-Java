package Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();
        compositeAccount.addAccount(new DepositAccount("DA001",100));
        compositeAccount.addAccount(new DepositAccount("DA002",150));
        compositeAccount.addAccount(new DepositAccount("SA001",200));

        float totalBalance=compositeAccount.getBalance();
        System.out.println("Total Balance " + totalBalance);

    }
}

abstract class Account {
    public abstract float getBalance();
}

class DepositAccount extends Account {

    private String accountNumber;
    private float accountBalance;

    public DepositAccount(String accountNumber, float accountBalance) {
        super();
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class CompositeAccount extends Account {

    private float totalBalance;
    private List<Account> accountList = new ArrayList<>();

    @Override
    public float getBalance() {
        totalBalance = 0;
        for (Account a : accountList) {
            totalBalance += a.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }
}
