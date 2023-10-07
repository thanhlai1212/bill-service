package modules.payment;

import modules.bill.Bill;

import java.time.LocalDate;
import java.util.List;

public class PaymentService {
  private static long id = 1;
  private final PaymentRepository paymentRepository = new PaymentRepository();

  public List<Payment> getPayments() {
    return paymentRepository.getPayments();
  }

  public Payment getPayment(Long id) {
    return paymentRepository.getPayments().stream().filter(b -> b.getId().equals(id)).findFirst().get();
  }

  public Payment addPayment(Long amount, LocalDate payDate, PaymentState state, Long billId) {
    Payment payment = new Payment(id, amount, payDate, state, billId);
    id++;
    return payment;
  }
}
