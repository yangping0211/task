package example.domain.model.task;

import javax.validation.constraints.NotBlank;

public class Title {
  @NotBlank
  String value = "";

  public Title() {}

  public Title(String title) {
    this.value = title;
  }

  @Override
  public String toString() {
    return value;
  }
}
