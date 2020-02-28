package example.domain.model.task;

public class Task {
  TaskId taskId;
  Title title;
  DueDate dueDate;

  FinishDateTime finishDateTime;

  public Task() {}

  public Task(TaskId taskId, Title title, DueDate dueDate, FinishDateTime finishDateTime) {
    this.taskId = taskId;
    this.title = title;
    this.dueDate = dueDate;
    this.finishDateTime = finishDateTime;
  }

  public TaskId taskId() {
    return taskId;
  }

  public Title title() {
    return title;
  }

  public DueDate dueDate() {
    return dueDate;
  }

  public Status status() {
    if (finishDateTime != null)
      return Status.完了;
    if (dueDate.isExpired())
      return Status.期限切れ;

    return Status.未完了;
  }
}
