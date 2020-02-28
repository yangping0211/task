package example.domain.model.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FinishDateTime {
  LocalDateTime value;

  @Deprecated
  FinishDateTime() {}

  public FinishDateTime(LocalDateTime value) {
    this.value = value;
  }

  public static FinishDateTime parse(String date, String time) {
    LocalDate d = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    LocalTime t = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:m"));
    return new FinishDateTime(LocalDateTime.of(d, t));
  }

  public static FinishDateTime parse(String date, String hour, String minute) {
    return parse(date, hour + ":" + minute);
  }

  @Override
  public String toString() {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(value);
  }
}
