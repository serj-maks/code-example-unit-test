package edu.serjmaks.junit.ex02.task1.controller;

import java.util.*;
import java.util.stream.Collectors;

import edu.serjmaks.junit.ex02.task1.model.Client;

public class ClientActions {

    public static List<String> amountMoneyBelowMin(int min, List<Client> clients) {
        return clients.stream()
                .map(client -> client.getAccounts())
                .flatMap(account -> account.stream())
                .filter(account -> account.getAmountMoney() > min)
                .map(account -> account.getAccountNumber())
                .collect(Collectors.toList());
    }
}
