package task.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.manager.dao.TaskDao;
import task.manager.dao.UserDao;
import task.manager.entity.Task;
import task.manager.entity.User;
import java.util.List;

@Service
public class TaskService {

  @Autowired
  private TaskDao taskDao;

  @Autowired
  private UserDao userDao;

  public Task createTask(Task task, Long userId) {
    User user = userDao.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    task.setUser(user);
    return taskDao.save(task);
  }

  public List<Task> getAllTasks() {
    return taskDao.findAll();
  }

  public Task getTaskById(Long id) {
    return taskDao.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
  }

  public Task updateTask(Long id, Task task) {
    Task existingTask =
        taskDao.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    existingTask.setTitle(task.getTitle());
    existingTask.setDescription(task.getDescription());
    existingTask.setDueDate(task.getDueDate());
    return taskDao.save(existingTask);
  }

  public void deleteTask(Long id) {
    taskDao.deleteById(id);
  }
}
