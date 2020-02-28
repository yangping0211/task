package example.presentation.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import example.application.service.task.TaskQueryService;

@Controller
@RequestMapping("tasks")
public class TasksController {
  private static final String[] allowFields = {"title.value", "dueDate.value",};

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.setAllowedFields(allowFields);
  }

  TaskQueryService taskQueryService;

  public TasksController(TaskQueryService taskQueryService) {
    this.taskQueryService = taskQueryService;
  }

  @GetMapping
  String tasks(Model model) {
    var tasks = taskQueryService.findTasks();

    model.addAttribute("tasks", tasks);
    return "task/list";
  }
}
