package modules.account;

public class AccountService {
  private final AccountRepository accountRepository = new AccountRepository();

  public Account addFund(Long accountId, Long amount) {
    Account account = accountRepository.getAccounts().stream().filter(a -> a.getId().equals(accountId)).findFirst().get();
    account.setBalance(amount);
    return account;
  }

  public Account getAccount(Long accountId) {
    return accountRepository.getAccounts().stream().filter(a -> a.getId().equals(accountId)).findFirst().get();
  }
}
