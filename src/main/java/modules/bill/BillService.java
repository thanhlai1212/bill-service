package modules.bill;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BillService {
  private static long id = 4;
  private final BillRepository billRepository = new BillRepository();

  public List<Bill> getBills() {
    return billRepository.getBills();
  }

  public List<Bill> getBillsByProvider(BillProvider provider) {
    return billRepository.getBills().stream().filter(b -> b.getProvider().equals(provider)).collect(Collectors.toList());
  }

  public List<Bill> getBillsByDueDate() {
    return billRepository.getBills().stream().filter(b -> b.getState().equals(BillState.NOT_PAID))
      .sorted(Comparator.comparing(Bill::getDueDate)).collect(Collectors.toList());
  }

  public Bill getBill(Long id) {
    return billRepository.getBills().stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
  }

  public Bill createBill(Bill bill) {
    bill.setId(id);
    billRepository.getBills().add(bill);
    id++;
    return bill;
  }

  public Bill updateBill(Bill bill) {
    Bill curentBill = billRepository.getBills().stream().filter(b -> b.getId().equals(bill.getId())).findFirst().get();
    int currentIndex = billRepository.getBills().indexOf(curentBill);
    return billRepository.getBills().set(currentIndex, bill);
  }

  public Bill deleteBill(Long id) {
    Bill curentBill = billRepository.getBills().stream().filter(b -> b.getId().equals(id)).findFirst().get();
    int currentIndex = billRepository.getBills().indexOf(curentBill);
    return billRepository.getBills().remove(currentIndex);
  }
}
