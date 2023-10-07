package modules.payment;

import java.time.LocalDate;

public class Payment {
  private Long id;
  private Long amount;
  private LocalDate paymentDate;
  private PaymentState state;
  private Long billId;

  public Payment(Long id, Long amount, LocalDate paymentDate, PaymentState state, Long billId) {
    this.id = id;
    this.amount = amount;
    this.paymentDate = paymentDate;
    this.state = state;
    this.billId = billId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public LocalDate getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(LocalDate paymentDate) {
    this.paymentDate = paymentDate;
  }

  public PaymentState getState() {
    return state;
  }

  public void setState(PaymentState state) {
    this.state = state;
  }

  public Long getBillId() {
    return billId;
  }

  public void setBillId(Long billId) {
    this.billId = billId;
  }
}
