package modules.schedule;

import java.time.LocalDate;

public class ScheduleService {
  private final ScheduleRepository scheduleRepository = new ScheduleRepository();
  static long id = 1;

  public Schedule addSchedule(Long billId, LocalDate date) {
    Schedule schedule = new Schedule(id, billId, date);
    scheduleRepository.getSchedules().add(schedule);
    id++;
    return schedule;
  }
}
