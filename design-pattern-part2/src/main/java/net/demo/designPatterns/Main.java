package net.demo.designPatterns;

import Util.JsonSerializer;
import model.AccountStatus;
import model.AccountType;
import model.BankAccount;
import model.BankDirector;
import repository.AccountRepositoryImpl;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
//        BankDirector director = new BankDirector();
//        BankAccount account = director.accountBuilder()
//                .accountId(1L)
//                .currency("MAD")
//                .status(AccountStatus.CREATED)
//                .type(AccountType.SAVING_ACCOUNT)
//                .balance(70000)
//                .build();
//
//        System.out.printf(account.toString());

        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();

        // without Singleton Instantiation
//        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        // with  Singleton Instantiation
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();

        // synchronization multi threads
        for(int i=0; i<10; i++) {
            new Thread(()->{
                accountRepository.populateData();
            }).start();
        }
        System.out.println("Tape a character :");
        System.in.read();

//        accountRepository.populateData();

        List<BankAccount> accounts = accountRepository.findAll();
//        List<BankAccount> accounts = accountRepository.searchAccounts(account -> account.getStatus().equals(AccountStatus.ACTIVATED) && account.getBalance()>13000);
        accounts.stream().map(bankAccountJsonSerializer::toJson).forEach(System.out::println);

        System.out.println("===================================");
        BankAccount account =  accountRepository.findById(1L).orElse(null);
        if(account!=null){
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }
        
    }
}