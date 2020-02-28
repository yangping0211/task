package example.application.service.task;

import org.springframework.stereotype.Service;
import example.application.repository.TaskRepository;
import example.domain.model.task.Task;
import example.domain.model.task.TaskId;
import example.domain.model.task.Tasks;

@Service
public class TaskQueryService {
  TaskRepository taskRepository;

  public TaskQueryService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  /**
   * タスク選択
   */
  public Task choose(TaskId taskId) {
    return taskRepository.choose(taskId);
  }

  /**
   * タスク一覧
   */
  public Tasks findTasks() {
    return taskRepository.findTasks();
  }
}
