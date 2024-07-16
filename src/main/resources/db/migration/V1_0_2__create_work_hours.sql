CREATE TABLE work_hours (
  id BINARY(16) NOT NULL,
  user_id BINARY(16) NOT NULL,
  starter_time TIME NOT NULL,
  end_time TIME NOT NULL,
  work_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT us_work_fk
    FOREIGN KEY (user_id)
    REFERENCES users (id));