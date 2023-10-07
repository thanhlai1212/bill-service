package account;

import modules.account.Account;
import modules.account.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountServiceTest {
  AccountService accountService = new AccountService();

  @Test
  void testAddFund() {
    Account expected = new Account(1L, 1000000L);
    Account actual = accountService.addFund(1L, 1000000L);
    Assertions.assertEquals(expected.getBalance(), actual.getBalance());
  }

  @Test
  void testGetAccount() {
    Account expected = new Account(1L, 0L);
    Account actual = accountService.getAccount(1L);
    Assertions.assertEquals(expected.getId(), actual.getId());
    Assertions.assertEquals(expected.getBalance(), actual.getBalance());
  }
}
