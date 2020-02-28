package example.infrastructure.datasource.task;

import org.springframework.stereotype.Repository;
import example.application.repository.TaskRepository;
import example.domain.model.task.DueDate;
import example.domain.model.task.Task;
import example.domain.model.task.TaskId;
import example.domain.model.task.Tasks;
import example.domain.model.task.Title;

@Repository
public class TaskDataSource implements TaskRepository {
  TaskMapper mapper;

  public TaskDataSource(TaskMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public Task choose(TaskId taskId) {
    return mapper.selectByTaskId(taskId);
  }

  @Override
  public Tasks findTasks() {
    return new Tasks(mapper.selectTasks());
  }

  @Override
  public void registerTask(Title title, DueDate dueDate) {
    TaskId taskId = new TaskId(mapper.newTaskId());
    mapper.insertTask(taskId, title, dueDate);
  }

  @Override
  public void registerFisinishDateTime(TaskId taskId) {
    mapper.insertFinishDateTime(taskId);
  }

  @Override
  public void deleteTask(TaskId taskId) {
    mapper.deleteTask(taskId);
  }
}
