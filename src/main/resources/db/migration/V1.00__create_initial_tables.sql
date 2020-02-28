CREATE TABLE task (
  task_id INTEGER PRIMARY KEY,
  title VARCHAR(90) NOT NULL,
  due_date DATE NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE task_id;

CREATE TABLE task_finished (
  task_id INTEGER PRIMARY KEY,
  finished_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);