package modules.account;

import modules.payment.Payment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AccountRepository {
  private List<Account> accounts = new ArrayList<>(
    List.of(new Account(1L, 0L))
  );

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }
}
