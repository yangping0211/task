package example.domain.model.task;

import java.util.List;

public class Tasks {
  List<Task> list;

  public Tasks(List<Task> list) {
    this.list = list;
  }

  public List<Task> list() {
    return list;
  }

  @Override
  public String toString() {
    return list.toString();
  }
}
