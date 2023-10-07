package modules.schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRepository {
  private List<Schedule> schedules = new ArrayList<>();

  public List<Schedule> getSchedules() {
    return schedules;
  }

  public void setSchedules(List<Schedule> schedules) {
    this.schedules = schedules;
  }
}
