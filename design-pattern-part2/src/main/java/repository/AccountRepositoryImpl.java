package repository;

import model.AccountStatus;
import model.AccountType;
import model.BankAccount;
import model.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {


    private static final AccountRepositoryImpl accountRepository;
    static {
        System.out.println("Singleton instantiation");
        accountRepository=new AccountRepositoryImpl();
    }

    private AccountRepositoryImpl(){}
    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private long accountsCount = 0;

    @Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId;
        synchronized (this) {
            accountId = ++accountsCount; // Critical zone
        }
        bankAccount.setAccountId(accountId);
        synchronized (this) {
            bankAccountMap.put(accountId, bankAccount);
        }
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long Id) {
        BankAccount account = bankAccountMap.get(Id);
        if(account == null)
            return Optional.empty();
        else
            return Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccountMap.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public void deleteById(Long Id) {
        bankAccountMap.remove(Id);
    }

    public void populateData() {
        for (int i=0; i<10; i++) {
            BankAccount account = BankDirector.accountBuilder()
                    .currency(Math.random()>0.5?"MAD":"USD")
                    .status(Math.random()>0.5?AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .type(Math.random()>0.5?AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                    .balance(10000+Math.random()*9000)
                    .build();
            save(account);
        }
        System.out.println("==============================================");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Account count = "+accountsCount);
        System.out.println("Size = "+bankAccountMap.size());
    }

    public static synchronized AccountRepositoryImpl getInstance(){
        return accountRepository;
    }
}
