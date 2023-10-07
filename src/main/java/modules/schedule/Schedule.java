package modules.schedule;

import java.time.LocalDate;

public class Schedule {
  private Long id;
  private Long billId;
  private LocalDate date;

  public Schedule(Long id, Long billId, LocalDate date) {
    this.id = id;
    this.billId = billId;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getBillId() {
    return billId;
  }

  public void setBillId(Long billId) {
    this.billId = billId;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
