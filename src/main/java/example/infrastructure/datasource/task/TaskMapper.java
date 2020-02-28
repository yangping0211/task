package example.infrastructure.datasource.task;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import example.domain.model.task.DueDate;
import example.domain.model.task.Task;
import example.domain.model.task.TaskId;
import example.domain.model.task.Title;

@Mapper
public interface TaskMapper {
  Task selectByTaskId(@Param("taskId") TaskId taskId);

  List<Task> selectTasks();

  void insertTask(@Param("taskId") TaskId taskId, @Param("title") Title title,
      @Param("dueDate") DueDate dueDate);

  void insertFinishDateTime(@Param("taskId") TaskId taskId);

  void deleteTask(@Param("taskId") TaskId taskId);

  Integer newTaskId();
}
