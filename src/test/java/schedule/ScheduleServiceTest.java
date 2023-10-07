package schedule;

import modules.schedule.Schedule;
import modules.schedule.ScheduleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ScheduleServiceTest {
  ScheduleService scheduleService = new ScheduleService();

  @Test
  void testAddSchedule() {
    Schedule actual = scheduleService.addSchedule(1L, LocalDate.of(2020, 10, 25));
    Assertions.assertEquals(actual.getBillId(), 1L);
    Assertions.assertEquals(actual.getDate(), LocalDate.of(2020, 10, 25));
  }
}
