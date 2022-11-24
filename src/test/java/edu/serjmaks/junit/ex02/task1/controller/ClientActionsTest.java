package edu.serjmaks.junit.ex02.task1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.serjmaks.junit.ex02.task1.model.Account;
import edu.serjmaks.junit.ex02.task1.model.Client;

class ClientActionsTest {

    @Test
    void amountMoneyBelowMin() {
        List<Account> accountList01 = List.of(
                new Account(1, "123", 5_000_000),
                new Account(2, "456", 1_000_000),
                new Account(3, "789", 500_000)
        );

        List<Account> accountList02 = List.of(
                new Account(1, "321", 6_000_000),
                new Account(2, "654", 2_000_000),
                new Account(3, "987", 600_000)
        );

        List<Account> accountList03 = List.of(
                new Account(1, "123123", 4_000_000),
                new Account(2, "456456", 0),
                new Account(3, "789789", 400_000)
        );

        List<Client> clients = List.of(
                new Client(1, accountList01),
                new Client(2, accountList02),
                new Client(3, accountList03)
        );

        List<String> expected = List.of("123", "321", "654", "123123");
        List<String> actual = ClientActions.amountMoneyBelowMin(1_000_000, clients);
        assertEquals(expected, actual);
    }

    @Test
    void amountMoneyBelowMin_shouldReturnTrue() {
        List<Account> accounts = List.of(

        );
        List<Client> clients = List.of(new Client(1, accounts));

        List<String> actual = ClientActions.amountMoneyBelowMin(1_000_000, clients);
        assertTrue(actual.isEmpty());
    }
}
