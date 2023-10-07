package modules.payment;

import java.time.LocalDate;
import java.util.List;

public class PaymentService {
  private static long id = 1;
  private final PaymentRepository paymentRepository = new PaymentRepository();

  public List<Payment> getPayments() {
    return paymentRepository.getPayments();
  }

  public Payment addPayment(Long amount, LocalDate payDate, PaymentState state, Long billId) {
    Payment payment = new Payment(id, amount, payDate, state, billId);
    id++;
    return payment;
  }
}
