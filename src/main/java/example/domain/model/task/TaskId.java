package example.domain.model.task;

public class TaskId {
  Integer value;

  public TaskId() {}

  public static TaskId from(String value) {
    return new TaskId(Integer.parseInt(value));
  }

  public TaskId(Integer value) {
    this.value = value;
  }

  public Integer value() {
    return value;
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
