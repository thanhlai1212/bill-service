package modules.bill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BillRepository {
  private List<Bill> bills = new ArrayList<>(
    List.of(
      new Bill(1L, BillType.ELECTRIC, 200000L, LocalDate.of(2020, 10, 25), BillState.NOT_PAID, BillProvider.EVN_HCMC),
      new Bill(2L, BillType.WATER, 175000L, LocalDate.of(2020, 10, 30), BillState.NOT_PAID, BillProvider.SAVACO_HCMC),
      new Bill(3L, BillType.INTERNET, 800000L, LocalDate.of(2020, 11, 30), BillState.NOT_PAID, BillProvider.VNPT)
    )
  );


  public List<Bill> getBills() {
    return bills;
  }

  public void setBills(List<Bill> bills) {
    this.bills = bills;
  }
}
