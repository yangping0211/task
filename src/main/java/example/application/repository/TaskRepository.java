package example.application.repository;

import example.domain.model.task.DueDate;
import example.domain.model.task.Task;
import example.domain.model.task.TaskId;
import example.domain.model.task.Tasks;
import example.domain.model.task.Title;

public interface TaskRepository {
  Task choose(TaskId taskId);

  Tasks findTasks();

  void registerTask(Title title, DueDate dueDate);

  void registerFisinishDateTime(TaskId taskId);

  void deleteTask(TaskId taskId);
}
