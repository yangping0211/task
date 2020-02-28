package example.presentation.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import example.application.service.task.TaskQueryService;
import example.application.service.task.TaskRecordService;
import example.domain.model.task.Task;
import example.domain.model.task.TaskId;

@Controller
@RequestMapping("tasks/{taskId}")
public class TaskController {
  TaskQueryService taskqueryService;
  TaskRecordService taskRecordService;

  public TaskController(TaskQueryService taskqueryService, TaskRecordService taskRecordService) {
    this.taskqueryService = taskqueryService;
    this.taskRecordService = taskRecordService;
  }

  @ModelAttribute("task")
  Task task(@PathVariable(value = "taskId") TaskId taskId) {
    return taskqueryService.choose(taskId);
  }

  @GetMapping
  public String init(Model model) {
    return "task/detail";
  }

  @GetMapping("finish")
  String registerFisinihDateTimeThenRedirect(@PathVariable(value = "taskId") TaskId taskId,
      RedirectAttributes attributes) {
    taskRecordService.registerFisinihDateTime(taskId);

    return "redirect:/tasks/";
  }

  @GetMapping("delete")
  String deleteThenRedirect(@PathVariable(value = "taskId") TaskId taskId,
      RedirectAttributes attributes) {
    taskRecordService.deleteTask(taskId);

    return "redirect:/tasks/";
  }
}
