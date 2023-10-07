package modules.bill;

import java.time.LocalDate;

public class Bill {
  private Long id;
  private BillType type;
  private Long amount;
  private LocalDate dueDate;
  private BillState state;
  private BillProvider provider;

  public Bill(Long id, BillType type, Long amount, LocalDate dueDate, BillState state, BillProvider provider) {
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.dueDate = dueDate;
    this.state = state;
    this.provider = provider;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BillType getType() {
    return type;
  }

  public void setType(BillType type) {
    this.type = type;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public BillState getState() {
    return state;
  }

  public void setState(BillState state) {
    this.state = state;
  }

  public BillProvider getProvider() {
    return provider;
  }

  public void setProvider(BillProvider provider) {
    this.provider = provider;
  }

}
