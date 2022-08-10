package edu.serjmaks.junit.ex02.task1.model;

import java.util.List;
import java.util.Objects;

public class Client {
    private long id;
    List<Account> accounts;

    public Client(long id, List<Account> accounts) {
        this.id = id;
        this.accounts = accounts;
    }

    public long getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", accounts=" + accounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accounts);
    }
}
