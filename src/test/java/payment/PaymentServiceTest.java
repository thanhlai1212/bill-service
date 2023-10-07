package payment;

import modules.payment.Payment;
import modules.payment.PaymentService;
import modules.payment.PaymentState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PaymentServiceTest {
  PaymentService paymentService = new PaymentService();

  @Test
  void testGetPayments() {
    Assertions.assertNotNull(paymentService.getPayments());
  }

  @Test
  void testAddPayment() {
    Payment actual = paymentService.addPayment(200000L, LocalDate.of(2020, 10, 25),
      PaymentState.PENDING, 1L);
    Assertions.assertEquals(actual.getAmount(), 200000L);
    Assertions.assertEquals(actual.getPaymentDate(), LocalDate.of(2020, 10, 25));
    Assertions.assertEquals(actual.getState(), PaymentState.PENDING);
    Assertions.assertEquals(actual.getBillId(), 1L);

  }
}
