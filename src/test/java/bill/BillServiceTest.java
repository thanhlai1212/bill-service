package bill;

import modules.bill.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class BillServiceTest {
  BillService billService = new BillService();

  @Test
  void testGetBills() {
    Assertions.assertNotNull(billService.getBills());
  }

  @Test
  void testGetBillsByProvider() {
    BillProvider provider = BillProvider.VNPT;
    List<Bill> bills = billService.getBillsByProvider(provider);
    for (Bill bill : bills) {
      Assertions.assertEquals(bill.getProvider(), provider);
    }
  }

  @Test
  void testGetBillsByDueDate() {
    Assertions.assertNotNull(billService.getBillsByDueDate());
  }

  @Test
  void testGetBill() {
    Bill expected = new Bill(1L, BillType.ELECTRIC, 200000L,
      LocalDate.of(2020, 10, 25),
      BillState.NOT_PAID, BillProvider.EVN_HCMC);
    Bill actual = billService.getBill(1L);
    Assertions.assertEquals(expected.getId(), actual.getId());
  }

  @Test
  void testCreateBill() {
    Bill bill = new Bill(1L, BillType.ELECTRIC, 200000L,
      LocalDate.of(2020, 10, 25),
      BillState.NOT_PAID, BillProvider.EVN_HCMC);
    Bill actual = billService.createBill(bill);
    Assertions.assertEquals(bill.getAmount(), actual.getAmount());
  }

  @Test
  void testUpdateBill() {
    Bill bill = new Bill(1L, BillType.ELECTRIC, 300000L,
      LocalDate.of(2020, 10, 25),
      BillState.NOT_PAID, BillProvider.EVN_HCMC);
    Bill actual = billService.updateBill(bill);
    Assertions.assertEquals(bill.getAmount(), actual.getAmount());
  }

  @Test
  void testDeleteBill() {
    Assertions.assertNotNull(billService.deleteBill(1L));
  }
}
