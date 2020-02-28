package example.presentation.controller.task;

import javax.validation.Valid;
import example.domain.model.task.DueDate;
import example.domain.model.task.Title;

public class TaskForm {
  @Valid
  Title title;
  @Valid
  DueDate dueDate;

  public TaskForm() {}
}
