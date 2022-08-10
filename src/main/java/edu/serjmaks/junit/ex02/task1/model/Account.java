package edu.serjmaks.junit.ex02.task1.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Account {
    private long id;
    private String accountNumber;
    private int amountMoney;

    public Account(long id, String accountNumber, int amountMoney) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amountMoney = amountMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", amountMoney=" + amountMoney +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
               amountMoney == account.amountMoney &&
                Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, amountMoney);
    }
}
