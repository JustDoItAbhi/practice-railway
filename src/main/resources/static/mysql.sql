drop table if exists Category;

Create Table Category(
id int, auto_increment PRIMARY KEY,
categoryName VARCHAR(60),
currentTime DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TRIGGER update_currentTime
  AFTER UPDATE ON Task
  FOR EACH ROW
BEGIN
  UPDATE Task
  SET currentTime = CURRENT_TIMESTAMP
  WHERE id = OLD.id;
END;