package example.application.service.task;

import org.springframework.stereotype.Service;
import example.application.repository.TaskRepository;
import example.domain.model.task.DueDate;
import example.domain.model.task.TaskId;
import example.domain.model.task.Title;

@Service
public class TaskRecordService {
  TaskRepository taskRepository;

  public TaskRecordService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public void registerTask(Title title, DueDate dueDate) {
    taskRepository.registerTask(title, dueDate);
  }

  public void registerFisinihDateTime(TaskId taskId) {
    taskRepository.registerFisinishDateTime(taskId);
  }

  public void deleteTask(TaskId taskId) {
    taskRepository.deleteTask(taskId);
  }
}
