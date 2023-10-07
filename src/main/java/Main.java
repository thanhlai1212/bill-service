import modules.account.Account;
import modules.account.AccountService;
import modules.bill.Bill;
import modules.bill.BillProvider;
import modules.bill.BillService;
import modules.payment.PaymentService;
import modules.payment.PaymentState;
import modules.schedule.ScheduleService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
  public static final AccountService accountService = new AccountService();
  public static final BillService billService = new BillService();
  public static final PaymentService paymentService = new PaymentService();
  public static final ScheduleService scheduleService = new ScheduleService();

  public static void main(String[] args) {

    if (args[0].equals("CASH_IN")) {
      cashIn(Long.valueOf(args[1]));
    } else if (args[0].equals("LIST_BILL")) {
      listBill(billService.getBills());
    } else if (args[0].equals("PAY")) {
      pay(args);
    } else if (args[0].equals("DUE_DATE")) {
      listBill(billService.getBillsByDueDate());
    } else if (args[0].equals("SCHEDULE")) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate date = LocalDate.parse(args[2], formatter);
      schedule(Long.valueOf(args[1]), date);
    } else if (args[0].equals("LIST_PAYMENT")) {
      listPayment();
    } else if (args[0].equals("SEARCH_BILL_BY_PROVIDER")) {
      searchBillByProvider(BillProvider.valueOf(args[1]));
    }
  }

  public static void cashIn(Long amount) {
    Account account = accountService.addFund(1L, amount);
    System.out.println("Your available balance: " + account.getBalance());
  }

  public static void listBill(List<Bill> bills) {
    System.out.println(
      String.format("%-10s%-10s%-10s%-15s%-10s%-10s", "Bill No.", "Type", "Amount", "Due Date", "State", "Provider"));
    for (Bill b : bills) {
      System.out.println(String.format("%-10s%-10s%-10s%-15s%-10s%-10s",
        b.getId(), b.getType(), b.getAmount(), b.getDueDate(), b.getState(), b.getProvider()));
    }
  }

  public static void pay(String[] args) {
    Account account = accountService.getAccount(1L);
    Long totalBillAmount = 0L;

    for (int i = 1; i < args.length; i++) {
      Long id = Long.valueOf(args[i]);
      Bill bill = billService.getBill(id);
      if (bill == null) {
        System.out.println("Sorry! Not found a bill with such id " + id);
        return;
      }

      totalBillAmount += bill.getAmount();
    }

    if (account.getBalance() < totalBillAmount) {
      System.out.println("Sorry! Not enough fund to proceed with payment.");
    } else {
      for (int i = 1; i <= args.length; i++) {
        Bill bill = billService.getBill(Long.valueOf(args[i]));
        account.setBalance(account.getBalance() - bill.getAmount());
        paymentService.addPayment(bill.getAmount(), LocalDate.now(), PaymentState.PROCESSED, bill.getId());
        System.out.println("Payment has been completed for Bill with id " + bill.getId());
        System.out.println("Your current balance is: " + account.getBalance());
      }
    }
  }

  public static void schedule(Long billId, LocalDate date) {
    scheduleService.addSchedule(billId, date);
    Bill bill = billService.getBill(billId);
    paymentService.addPayment(bill.getAmount(), bill.getDueDate(), PaymentState.PENDING, billId);
    System.out.println("Payment for bill id "  + billId  + " is scheduled on " + date);
  }

  public static void listPayment() {
    paymentService.getPayments();
  }

  public static void searchBillByProvider(BillProvider provider) {
    List<Bill> bills = billService.getBillsByProvider(provider);
    listBill(bills);
  }
}
