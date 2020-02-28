package example.domain.model.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class DueDate {
  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  LocalDate value;

  public DueDate() {}

  public static DueDate from(String value) {
    return new DueDate(LocalDate.parse(value, DateTimeFormatter.ISO_DATE));
  }

  public DueDate(LocalDate value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value.format(DateTimeFormatter.ISO_DATE);
  }

  public boolean isExpired() {
    return value.isBefore(LocalDate.now());
  }
}
