package example.presentation.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import example.application.service.task.TaskRecordService;

@Controller
@RequestMapping("tasks/register")
public class TaskRegisterController {
  private static final String[] allowFields = {"title.value", "dueDate.value",};

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.setAllowedFields(allowFields);
  }

  TaskRecordService taskRecordService;

  public TaskRegisterController(TaskRecordService taskRecordService) {
    this.taskRecordService = taskRecordService;
  }

  @GetMapping
  String showForm(Model model) {
    model.addAttribute("taskForm", new TaskForm());
    return "task/register/form";
  }

  @PostMapping
  String register(@Validated @ModelAttribute("taskForm") TaskForm taskForm, BindingResult result) {
    if (result.hasErrors()) {
      return "task/register/form";
    }

    taskRecordService.registerTask(taskForm.title, taskForm.dueDate);
    return "redirect:/tasks/";
  }
}
